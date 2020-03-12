   * [调查问卷](#调查问卷)
      * [项目包结构](#项目包结构)
      * [数据库结构](#数据库结构)
      * [前端](#前端)
      * [数据库](#数据库)
         * [HikariCP](#hikaricp)
         * [Mybatis](#mybatis)
      * [单元测试](#单元测试)
         * [Junit5](#junit5)
      * [前端安全](#前端安全)
         * [Xss 攻击](#xss-攻击)
         * [CSRF 攻击](#csrf-攻击)
         * [JSR303 数据校验](#jsr303-数据校验)
         * [投票器](#投票器)

# 调查问卷

[Click me to jump to English version Readme](./README.en.md)

## 项目包结构


一. 代码层结构
com.run  
1. 启动类(QuestionaireApplication.java）放在根目录com.run包下  
2. 实体类（pojo） com.run.pojo
3. 数据接口访问层(Dao) com.run.mapper 
4. 数据服务接口层（Service）com.run.service
5. 数据服务实现层（Service Implements） com.run.serviceimpl
6. 前端控制器层（Controller） com.run.controller
7. 工具类库（com.run.utils）com.run.com.run.utils
8. 配置类（config）com.run.config
9. 数据传输对象（dto）com.run.dto 
    数据传输对象（Data Transfer Object）用于封装多个实体类（domain）之间的关系，不破坏原有的实体类结构
10. 视图包装对象（vo）com.run.vo
    视图包装对象（View Object）用于封装客户端请求的数据，防止部分数据泄露（如：管理员ID），保证数据安全，不破坏 原有的实体类结构
二. 资源目录结构
根目录：resources
1. mybatis映射文件：resources/mapper/
2. mybatis配置文件：resources/mapper/config/
根目录: webapp
classes 
statis: html js css


## 数据库结构

**注意 coding=utf-8**

- 问卷表 questionnaire
    - 问卷编号 id
        - bigint unsigned not null auto_increment 主键
    - 问卷名 name
        - varchar(100) not null
    - 问卷描述 qn_describe
        - text
    - 问卷创建时间 creat_time
        - datetime not null
    - 问卷更新时间 update_time
        - datetime not null
    - 问卷状态 status
        - enum('public', 'close')
        - comment "问卷当前是否开放"

- 问题表 question
    - 问题编号 q_id
        - int unsigned not null auto_increment 主键
    - 问题描述 q_describe
        - text
    - 问卷编号 id
        - int not null 外键
    - 题型 question_type
        - enum('subjective', 'objective') not null

- 选项表 question_option
    - 选项编号 op_id
        - int unsigned not null auto_increment 主键
    - 选项内容 op_describe
        - varchar(50)
    - 问题编号 q_id
        - int not null 外键

- 主观题答案 subjective_question_answer
    - 答案编号 sub_q_id
        - int unsigned passwordnot null auto_increment 主键
    - 答案内容 content
        - text

- 客观题选择 objective_question_answer
    - 答案编号 obj_q_id
        - int unsigned not null auto_increment 主键
    - 选项编号 op_id
        - int not null 外键

## 前端
- login.html
    - 负责登陆跳转至后台界面 
- questionnaire.html
    - 单个问卷展示模板
- addQuestionnaire.html
    - 创建新的问卷
- backstage.html
    - 后台管理
    - 查看所有问卷
- thymeleaf和bootstrap
    - 1.bootstrap:https://v3.bootcss.com/css/
        - 格栅系统
         ```html
            <div class="form-group">
              <div class="row" style="padding-bottom:15px;">
                  <div class="col-sm-3" >
                  ...
                  </div>
              </div>
            </div>
         ```
          
        - 表格
        ```html
           <table class="table">
           ...
           </table>
        ```
        - 表单
        ```html
           <label for="questionnaire_describe" class="col-sm-4 control-label">问卷描述</label>
        ```
        - 单选和多选框
        ```html
           <div class="radio col-sm-8">
              <label th:for="question_ + (${qid}) + _answer_radio_ + (${option.getOpId()})">
                  <th:block th:unless="(${username}) == 'root'" >
                      <h4 type="text" class="form-control" th:id="question_ + (${qid}) + _answer_input_ + (${option.getOpId()})" th:text="(${option.getOpDescribe()})" > </h4>
                  </th:block>
              </label>
           </div>
        ```
    - 2.thymeleaf
        - 添加thymeleaf依赖
        ```yaml
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-thymeleaf</artifactId>
            </dependency>
        ```
        - 创建用来准备数据的Controller
        ```
            @RequestMapping(value = {"/{id}/{type}"})
                public String getAllQuestions(@PathVariable("id") BigInteger id, @PathVariable("type") String type, Model model, HttpServletRequest request) throws Exception {
                    //获取所有问题信息
                    ···
                    //把问题信息放入Attribute
                            model.addAttribute("questionnaire_id", id);
                            model.addAttribute("questionnaire_name", questionnaire.getName());
                            model.addAttribute("allquestions", list);
                    ···
                }
      
        ```
        - 创建questionnaire.html,通过th:each表达式来遍历controller中返回的数据。
        ```
            <div th:id="question_ + (${questions.getQId()}) + _box" class="form-group" th:each="questions,index:${allquestions}">
        ```
## 数据库 

1. 数据池

    ### HikariCP
   
       spring-boot 2.x 官方描述：
       ```
            Production database connections can also be auto-configured by using 
       a poolingDataSource. Spring Boot uses the following algorithm for 
       choosing a specific implementation:  
       We preferHikariCP for its performance and concurrency. 
           - If HikariCP is available, we always choose it.
           - Otherwise, if the Tomcat pooling DataSourceis available, we use it.
           - If neither HikariCP nor the Tomcat pooling datasource are available and ifCommons DBCP2is available, we use it.
       ```
        Spring Boot 为我们准备了最佳的数据库连接池方案，
        2.x版本后数据库连接池就采用了HikariCP，
        只需要在属性文件（例如application.properties）中配置需要的连接池参数即可。
        
        application.properties
        ``` properties
        spring.datasource.url=jdbc:mysql://120.79.224.142:3306/questionaire
        spring.datasource.id=id
        spring.datasource.password=password
        ```
       
       pom.xml
       ```xml    
        <dependency>
           <groupId>com.zaxxer</groupId>
           <artifactId>HikariCP</artifactId>
           <version>3.4.1</version>
        </dependency>
        ```
   
    项目地址    
    https://github.com/brettwooldridge/HikariCP
    
2. ORM框架  
    ### Mybatis
       ``` xml
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
       ```

    
## 单元测试

### Junit5
官方文档: https://junit.org/junit5/docs/current/user-guide/

| 注解 | 描述 |
| :----------: | :------------ |
| @Test | 注解在方法上标记方法为测试方法，以便构建工具和 IDE 能够识别并执行它们。 JUnit5不需要手动将测试类与测试方法为public，包可见的访问级别就足够了。|
| @ParameterizedTest | 表示方法是参数化测试 |
| @RepeatedTest | 表示方法是重复测试模板 |
| @TestFactory | 表示方法是动态测试的测试工程 |
| @TestInstance | 用于配置测试实例生命周期 |
| @TestTemplate | 表示方法是为多次调用的测试用例的模板 |
| @DisplayName | 为测试类或者测试方法自定义一个名称 |
| @BeforeEach | 表示方法在每个测试方法运行前都会运行 |
| @AfterEach | 表示方法在每个测试方法运行之后都会运行 |
| @BeforeAll | 表示方法在所有测试方法之前运行 |
| @AfterAll | 表示方法在所有测试方法之后运行 |
| @Nested | 表示带注解的类是嵌套的非静态测试类,@BeforeAll和@AfterAll方法不能直接在@Nested测试类中使用，除非修改测试实例生命周期。 |
| @Tag | 用于在类或方法级别声明用于过滤测试的标记 |
| @Disabled | 用于禁用测试类或测试方法 |
| @ExtendWith | 用于注册自定义扩展，该注解可以继承 |


## 导入问卷

excel表导入数据库


### 后端处理 


// TODO

## 前端安全

### Xss 攻击

对用户的输入进行判断


### CSRF 攻击 

添加token 进行验证


### JSR303 数据校验


### 投票器

Security AccessDecisionVoter


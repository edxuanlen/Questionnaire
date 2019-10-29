# 调查问卷

## 数据库结构

**注意 coding=utf-8**

- 问卷表 questionaire
    - 问卷编号 id
        - int unsigned not null auto_increment 主键
    - 问卷名 name
        - varchar(20) not null
    - 问卷描述 describe
        - text
    - 问卷创建时间 creation_time
        - datetime not null
    - 问卷状态 status
        - enum('public', 'close')
        - comment "问卷当前是否开放"

- 问题表 question
    - 问题编号 q_id
        - int unsigned not null auto_increment 主键
    - 问题描述 describe
        - text
    - 问卷编号 id
        - int not null 外键
    - 题型 question_type
        - enum('subjective', 'objective') not null

- 选项表 option
    - 选项编号 op_id
        - int unsigned not null auto_increment 主键
    - 选项内容 describe
        - varchar(50)
    - 问题编号 q_id
        - int not null 外键

- 主观题答案 subjective_question_answer
    - 答案编号 sub_q_id
        - int unsigned not null auto_increment 主键
    - 答案内容 content
        - text

- 客观题选择 objective_question_answer
    - 答案编号 obj_q_id
        - int unsigned not null auto_increment 主键
    - 选项编号 op_id
        - int not null 外键



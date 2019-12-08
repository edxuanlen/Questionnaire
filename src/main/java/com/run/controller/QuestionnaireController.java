package com.run.controller;

import com.run.mapper.QuestionnaireMapper;
import com.run.pojo.Question;
import com.run.pojo.QuestionOption;
import com.run.pojo.Questionnaire;
import io.swagger.annotations.Api;
import org.apache.ibatis.jdbc.Null;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.jdt.internal.compiler.codegen.ConstantPool.ValueOf;


@Controller
@RequestMapping("/questionnaire")
@EnableSwagger2 // 启动swagger注解
// api-value：定义名称，如果没有定义，则默认显示类名
@Api(value = "Questionnaire Controller", tags = "Questionnaire Control Tag")
public class QuestionnaireController {
    @Autowired
    QuestionnaireMapper questionnaireMapper;
    @RequestMapping("/{id}")
    public String getAllQuestions(@PathVariable("id") BigInteger id, Model model) throws Exception {
        //获取所有问题信息
        List<Question> list = questionnaireMapper.getAllQuestions(id);
        //获取问卷名
        Questionnaire questionnaire = questionnaireMapper.getQuestionnaireById(id);
        //把问题信息放入Attribute
        model.addAttribute("questionnaire_name", questionnaire.getName());
        model.addAttribute("allquestions", list);
        //循环每一个问题获取每一个问题的选项
        int total = list.size();
        BigInteger QId;
        String s = "options";
        List<QuestionOption> option_list;
//        Map<String, List<QuestionOption>> m = null;
        HashMap<BigInteger, List<QuestionOption>> M = new HashMap<>();
        for(int i = 0; i < total; i ++) {
            QId = list.get(i).getQId();
//            System.out.println("QID: " + QId);
            option_list = questionnaireMapper.getQuestionOptionById(QId);
//            System.out.println("option list " + option_list);
            M.put(QId, option_list);
        }
        model.addAttribute(s , M);
//        System.out.println(M);
        return "questionnaire";
    }
}

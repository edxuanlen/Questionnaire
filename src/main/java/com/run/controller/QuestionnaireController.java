package com.run.controller;

import com.run.mapper.QuestionnaireMapper;
import com.run.pojo.Question;
import com.run.pojo.QuestionOption;
import com.run.pojo.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/questionnaire")
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
        BigInteger qId;
        List<QuestionOption> optionList;
        Map<BigInteger, List<QuestionOption>> optionsMap = null;
        for(int i = 0; i < total; i ++) {
            qId = list.get(i).getQId();
            optionList = questionnaireMapper.getQuestionOptionById(qId);


            optionsMap.put(qId,optionList);
            System.out.println(optionsMap.get(qId));
        }
       // model.addAttribute("options",optionsMap);

        return "questionnaire";
    }
}

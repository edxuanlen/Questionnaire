package com.run.controller;

import com.run.mapper.QuestionnaireMapper;
import com.run.pojo.Questionnaire;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigInteger;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/13 上午11:10
 * @Version 1.0
 **/

@RestController
@RequestMapping(value = "/questionnaire")
public class QuestionnaireController {

    QuestionnaireMapper questionnaireMapper;

    @GetMapping("/{id}")
    public Questionnaire getQuestionnaire(@PathVariable(value = "id") BigInteger id){
        Questionnaire questionnaire = questionnaireMapper.getQuestionnaireById(id);

        System.out.println(questionnaire);
        return questionnaire;
    }
}

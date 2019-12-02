package com.run.controller;

import com.run.mapper.QuestionnaireMapper;
import com.run.pojo.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/13 上午11:10
 * @Version 1.0
 **/

@Controller
@RequestMapping(value = "/admin")
public class BackstageController {
    @Autowired
    QuestionnaireMapper questionnaireMapper;
    /**跳转后台管理页面并获取问卷信息*/
    @GetMapping("/")
    public String getAllQuestionnaire(Model model) throws Exception {
        List<Questionnaire> list = questionnaireMapper.getQuestionnaireAll();
        model.addAttribute("allquestionnaire",list);
        return "/admin/backstage";
    }
    /**跳转问卷添加页面*/
    @GetMapping("/add")
    public String addQuestionniare() throws Exception{
        return "/admin/addQuestionnaire";
    }
    /**处理插入请求并重定向*/
    @RequestMapping("/insert")
    public String save(@Valid Questionnaire questionnaire, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
//            return bindingResult.getFieldError().getDefaultMessage();
            return "问卷名称或问卷描述为空！";
        }else{
            System.out.println(questionnaire.getName());
            System.out.println(questionnaire.getQnDescribe());
            questionnaireMapper.insertQuestionnaire(questionnaire);
            return "redirect:/admin/";
        }
    }
//    @GetMapping("/{id}")
//    public Questionnaire getQuestionnaire(@PathVariable(value = "id") BigInteger id) throws Exception {
//        Questionnaire questionnaire = questionnaireMapper.getQuestionnaireById(id);
//
//        System.out.println(questionnaire);
//        return questionnaire;
//    }
//
//    @GetMapping("/new")
//    public Questionnaire insertQuestionnaire(HttpServletRequest request){
//        Questionnaire questionnaire= new Questionnaire();
//        questionnaire.setId(request.getParameter("id"));
//        questionnaire.setName(request.getParameter("name"));
//        questionnaire.setStatus(request.getParameter("status"));
//        questionnaire.setQnDescribe(request.getParameter("qn_describe"));
//
//        return questionnaire;
//    }
}

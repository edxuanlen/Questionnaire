package com.run.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletSecurityElement;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/11 下午8:23
 * @Version 1.0
 **/

@Controller
@RequestMapping(value = "/ERROR")
public class ErrorController {

    /**
     * 404页面
     */
    @GetMapping(value = {"", "/404"})
    public String error404() {
        System.out.println("error");
        return "error/404";
    }



}




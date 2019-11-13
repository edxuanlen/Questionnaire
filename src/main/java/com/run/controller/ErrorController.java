package com.run.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletSecurityElement;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/11 下午8:23
 * @Version 1.0
 **/

@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 404页面
     */
    @GetMapping(value = "/404")
    public String error404() {
        return "/error/404";
    }

}




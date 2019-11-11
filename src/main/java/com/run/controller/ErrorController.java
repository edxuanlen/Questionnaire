package com.run.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/11 下午8:23
 * @Version 1.0
 **/


@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping("/error")
    public String error(HttpServletRequest request){
//        return "别问，问就是404";
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}




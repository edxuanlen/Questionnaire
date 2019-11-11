package com.run.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/11 下午7:58
 * @Version 1.0
 **/


@Controller
@RequestMapping("/")
public class TestController {
//    return "hello";


    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "hello";
    }


}
//11935dec-faae-4202-86c6-df33eae89964

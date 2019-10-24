package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author edxuanlen
 * @PROJECT demo
 * @Date 2019/10/24 上午9:14
 * @Version 1.0
 **/

@RestController
public class HelloTest {
    @RequestMapping("/")
    public String test() { return "hello java";}
}

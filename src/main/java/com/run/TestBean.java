package com.run;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testBean")
public class TestBean {
    @RequestMapping("/testDemo")
    public String TestDemo()   {

        return "backstage";
    }
}

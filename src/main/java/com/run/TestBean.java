package com.run;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/testBean")
public class TestBean {


    @RequestMapping("/testDemo")
    public String testDemo()   {

        return "login";
    }



//    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
//    String userLogin(User user, Model model) {
//        boolean verify = userService.verifyUser(user);
//        if (verify) {
//            model.addAttribute("name", user.getName());
//            model.addAttribute("password", user.getPassword());
//            return "result";
//        } else {
//            return "redirect:/notVerify";
//        }
//
//    }


}

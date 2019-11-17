package com.run.controller;


import com.run.mapper.UserMapper;
import com.run.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/11 下午3:24
 * @Version 1.0
 **/


@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping(value = "/user/{username}")
    public User getUser(@PathVariable(value = "username") String username) {
//        return null;

        User user = userMapper.getUserByUsername(username);
        System.out.println(user);
        return user;
//        return userMapper.getUserByid(id);
    }

//    @GetMapping(value = "/dept")
//    public User insertUser(User user){
//        userMapper.insertUser(user);
//        return user;
//        //        return userMapper.insertUserByid(id, passWord);
//    }

}

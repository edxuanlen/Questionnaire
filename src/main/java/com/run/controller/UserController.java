package com.run.controller;


import com.run.annotation.Table;
import com.run.mapper.UserMapper;
import com.run.pojo.User;
import com.run.service.BaseServiceClient;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/11 下午3:24
 * @Version 1.0
 **/


@RestController

@EnableSwagger2 // 启动swagger注解
// api-value：定义名称，如果没有定义，则默认显示类名
@Api(value = "User Controller", tags = "User Control Tag")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping(value = "/user/{username}")
    public User getUser(@PathVariable(value = "username") String username) {
        System.out.println(username);

        User user = userMapper.getUserByUsername(username);
        System.out.println(user);
        return user;
    }

    @GetMapping(value = "")
    public void getIndex(HttpServletResponse response) throws Exception{
        response.sendRedirect("./admin");
    }

}
;
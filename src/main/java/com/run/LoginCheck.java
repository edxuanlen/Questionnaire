package com.run;

/**
 * @Author edxuanlen
 * @PROJECT demo
 * @Date 2019/11/4 上午8:09
 * @Version 1.0
 **/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.X11.XSystemTrayPeer;

@RestController
public class LoginCheck {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/LoginCheck", method=RequestMethod.POST)
    public String loginCheck(@RequestParam("username") String userName, @RequestParam("password") String userPassword) {

        userPassword = DigestUtils.md5DigestAsHex(userPassword.getBytes());
        System.out.println(userName + userPassword);
        String findUser = "select id from root where id = '" + userName + "' and password = '" + userPassword + "'";
        int findUserStatus = 0;
        try{

            findUserStatus = jdbcTemplate.queryForObject(findUser, int.class);
        } catch (Exception e){
            return "login";
        }

        System.out.println(" count: " + findUserStatus);

        if (findUserStatus == 0){
            return "账号或密码错误";
        } else {
            return "login";
        }
    }
}

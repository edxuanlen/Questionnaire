package com.run.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/11 下午7:52
 * @Version 1.0
 **/

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll().
            antMatchers("/user/*").hasRole("root");

        // 开启自动配置的登录功能
        http.formLogin();

    }
}

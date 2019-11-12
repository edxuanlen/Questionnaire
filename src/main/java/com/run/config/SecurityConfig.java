package com.run.config;

import com.run.serviceImpl.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/11 下午7:52
 * @Version 1.0
 **/

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String KEY = "questionnaire";

    @Bean
    UserDetailsService customUserService(){
        return new UserService();
    }

    @Bean
    public  static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(customUserService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        auth.authenticationProvider(authenticationProvider);
//    }

    // 认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {



        // 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
            .antMatchers("/user/**").hasRole("root")
            .antMatchers("/management/**").hasRole("root")
            .and()
            .rememberMe().key(KEY).tokenValiditySeconds(1209600);
            // 记住两周


        http.csrf().disable();
        // 开启自动配置的登录功能
        http.formLogin().failureForwardUrl("/login?error").failureUrl("/login?error");
        http.logout().permitAll();
    }
}

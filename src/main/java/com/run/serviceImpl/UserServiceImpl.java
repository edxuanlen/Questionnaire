package com.run.serviceImpl;

import com.run.mapper.UserMapper;
import com.run.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author edxuanlen
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    /**
    * 重写 loadUserByUsername 方法获得 userdetails 类型用户
    */
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        if ( user != null ) {
            return user;
        } else {
//            System.out.println("NO");
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }
}
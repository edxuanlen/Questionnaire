package com.run.mapper;


/*
 * @author edxuanlen
 */

import com.run.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    @Select("select * from user where id = #{id}")
    public User getUserById(String id);

//    public User insertUser(User user);
}
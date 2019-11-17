package com.run.mapper;
import com.run.pojo.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author edxuanlen
 */
@Mapper
public interface UserMapper {


//    @Select("select * from user where id = #{id}")
//    public User getUserById(String id);

    /**
     * 通过用户名获取User
     * @param username
     * @return User
     * return user
     */
    User getUserByUsername(String username);

//    public User insertUser(User user);
}


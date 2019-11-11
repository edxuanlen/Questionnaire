//package com.run.mapper;
//
//import com.run.pojo.User;
//import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//
//
///**
// * @Author edxuanlen
// * @PROJECT questionnaire
// * @Date 2019/11/11 下午2:43
// * @Version 1.0
// **/
//
//// 置顶是操作数据库的mapper
//
//@Mapper
//public interface TestMapper {
//
//    @Select("select * from root where id = #{id}")
//    public User getUserByid(String id);
//
//    @Delete("delete from department where id = #{id}")
//    public String deleteUserByid(String id);
//
//    @Insert("insert into user(id, password) values(#{id}, #{passWord}")
//    public User insertUserByid(String id);
//
//
//
//
//}

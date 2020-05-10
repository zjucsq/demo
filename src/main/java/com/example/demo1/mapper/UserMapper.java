package com.example.demo1.mapper;

import com.example.demo1.dto.Book;
import com.example.demo1.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface UserMapper {

    @Insert("insert into user (email,name,password,phone) values (#{email},#{name},#{password},#{phone})")
    void createUser(User user);

    @Select("select password from user where email = #{email}")
    String verifyUser(String email);

    @Update("update user set password = #{password} where email = #{email} ")
    void updatePassword(String email, String password);

    @Select("select count(*) from user where email=#{email}")
    int isUserExist(User user);

    @Select("select name from user where email = #{email}")
    String searchName(String email);

    @Select("select * from user")
    List<User> getAllUsers();
}

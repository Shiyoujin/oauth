package com.example.oauth.mapper;

import com.example.oauth.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author white matter
 */
@Mapper
@Component
public interface SignAndLoginMapper {

    @Insert("insert into user(u_name,u_password) value (#{u_name},#{u_password})")
    boolean signUp(User user);

    @Select("select id from user where u_name = #{u_name} and u_password = #{u_password}")
    boolean signIn(User user);

    @Select("select u_name from user where u_name = #{u_name}")
    boolean isExistSignUp(User user);

    @Select("select u_name from user where u_name=#{u_name}")
    String selectFromCode(String code);


}

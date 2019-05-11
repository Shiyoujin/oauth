package com.example.oauth.controller;

import com.example.oauth.entity.User;
import com.example.oauth.mapper.SignAndLoginMapper;
import com.example.oauth.service.SLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author white matter
 */
public class SLController {
    @Autowired
    SLService slService;

    @GetMapping(value = "signUp",produces = "application/json")
    public String signUp(String u_name,String pass) {
        if (slService.signUp(u_name,pass)){
            return "注册成功";
        }else {
            return "注册失败";
        }
    }

    @GetMapping(value = "signIn",produces = "application/json")
    public String signIn(String u_name,String pass){
        if (slService.signIn(u_name,pass)){
            return "登录成功";
        }else {
            return "账号或者密码错误";
        }
    }
}

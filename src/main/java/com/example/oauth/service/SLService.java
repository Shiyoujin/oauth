package com.example.oauth.service;

import com.example.oauth.entity.User;
import com.example.oauth.mapper.SignAndLoginMapper;
import com.example.oauth.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author white matter
 */
@Service
public class SLService {
    @Autowired
    SignAndLoginMapper signAndLoginMapper;

    public boolean isExistSignp(String u_name){
        User user = new User();
        user.setU_name(u_name);
        return signAndLoginMapper.isExistSignUp(user);
    }

    public boolean signUp(String u_name,String pass){
        User user = new User();
        if (isExistSignp(u_name)){
            user.setU_password(pass);
            user.setU_name(u_name);
            return signAndLoginMapper.signUp(user);
        }else {
            return false;
        }
    }


    public boolean signIn(String u_name,String pass){
        String password = MD5Utils.inputPassToDbPass(pass,"1a2b3c4d");
        User user = new User();
        user.setU_name(u_name);
        user.setU_password(password);

        if (signAndLoginMapper.signIn(user)){
            return true;
        }else {
            return false;
        }
    }


}

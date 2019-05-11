package com.example.oauth.service;

import com.example.oauth.entity.User;
import com.example.oauth.mapper.SignAndLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author white matter
 */
@Service
public class CodeService {
    @Autowired
    private SignAndLoginMapper signAndLoginMapper;

    public String selectFromCode(String code){
        String u_name = signAndLoginMapper.selectFromCode(code);
        return u_name;
    }
}

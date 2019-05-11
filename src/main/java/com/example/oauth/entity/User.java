package com.example.oauth.entity;

import lombok.Data;

/**
 * @author white matter
 */
@Data
public class User {

    public String u_name;

    public String u_password;

    public String token;

    public User(String u_name,String u_password){
        this.u_name = u_name;
        this.u_password = u_password;
    }

    public User(){

    }
}

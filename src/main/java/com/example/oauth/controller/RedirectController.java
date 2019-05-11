package com.example.oauth.controller;

import com.example.oauth.entity.User;
import com.example.oauth.service.SLService;
import com.example.oauth.util.BASE64Utils;
import com.example.oauth.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.UnknownHostException;

/**
 * @author white matter
 */
@RestController
public class RedirectController {
    @Autowired
    SLService slService;

    private static String getLocalHost() throws UnknownHostException {
        //return InetAddress.getLocalHost().getHostAddress();
        return "10.100.19.211";
    }

    @GetMapping(value = "redirect",produces = "application/json")
    public boolean Redirect(String redirect_uri, String u_name, String pass, HttpServletResponse response) throws Exception {

        if (slService.signIn(u_name,pass)){
            String code = BASE64Utils.encryptBASE64(u_name);
            response.sendRedirect("http://"+getLocalHost()+"&"+redirect_uri+"code="+code);
            return true;
        }else {
            return false;
        }
    }
}

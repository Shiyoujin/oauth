package com.example.oauth.controller;

import com.example.oauth.entity.User;
import com.example.oauth.service.CodeService;
import com.example.oauth.util.BASE64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author white matter
 */
@RestController
public class CodeController {
    @Autowired
    CodeService codeService;

    /**
     * 通过解密后的 code获取 u_name从而获取用户信息
     * @param code
     * @return
     * @throws Exception
     */
    @GetMapping(value = "code",produces = "application/json")
    public String Code(String code) throws Exception {
        String newCode = BASE64Utils.decryptBASE64(code);
        String u_mame = codeService.selectFromCode(newCode);
        return u_mame;
    }
}

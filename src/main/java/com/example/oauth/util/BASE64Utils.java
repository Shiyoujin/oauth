package com.example.oauth.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Base64;

/**
 * @author white matter
 */
public class BASE64Utils {
    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();

    /**
     * BASE64 解密
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptBASE64(String key) throws Exception{
        String result = new String(decoder.decode(key),"UTF-8");
        return result;
    }

    /**
     * BASE64 加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(String key) throws Exception{
        final byte[] textByte = key.getBytes("UTF-8");
        //编码
        String result = encoder.encodeToString(textByte);
        return result;
    }

}

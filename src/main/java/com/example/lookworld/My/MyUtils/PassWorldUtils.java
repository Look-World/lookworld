package com.example.lookworld.My.MyUtils;


import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 密码工具集
 */
@Component
public class PassWorldUtils {

    //AES 加密密钥
    private static final String AES_KEY = "jkl;POIU1234++==";

    /**
     * AES 加密
     *
     * @param src 加密文本
     * @return 密文
     */
    public static String AESEncoder(String src) {
        try {
            if (src == null) {
                throw new IllegalAccessException("非法入参");
            }
            byte[] raw = AES_KEY.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));
            return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        } catch (Exception e) {
            e.printStackTrace();

        }
        return src;
    }

    /**
     * AES解密
     * @param src 密文
     * @return 明文
     */
    public static String AESDecoder(String src) {
        try {
            byte[] raw = AES_KEY.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(src);//先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

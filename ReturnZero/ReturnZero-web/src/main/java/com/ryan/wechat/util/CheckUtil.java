package com.ryan.wechat.util;

import java.util.Arrays;

/**
 * @author: ryan
 * @create: 2020/5/23
 * @description: 加密工具类
 **/
public class CheckUtil {

    private static String TOKEN = "java";

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] str = new String[]{TOKEN,timestamp, nonce};
        //排序
        Arrays.sort(str);
        //拼接字符串
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            buffer.append(str[i]);
        }
        //进行sha1加密
        String temp = null;
        try {
            temp = SHA1.encode(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //与微信提供的signature进行匹对
        return signature.equals(temp);
    }

    }
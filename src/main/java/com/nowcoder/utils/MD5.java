package com.nowcoder.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Component
public class MD5 {

    //得到32位的加密结果
    public static String encrypt(String str){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] str_byte = str.getBytes();
            byte[] md5_result_byte = md.digest(str_byte);
//          System.out.println(md5_result_byte);
//          System.out.println("字节数组的长度是："+md5_result_byte.length);
            String md5_result = bytesToHex(md5_result_byte);
            return md5_result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    //将字节数组转化为16进制字符串
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        //把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("，   "+bytes[i]);
            digital = bytes[i];
            if(digital < 0) {  //16及以上的数转16进制是两位
                digital += 256;
            }
            if(digital < 16){
                md5str.append("0");//如果是0~16之间的数的话则变成0X
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

    public static void main(String[] args) {
        String str = "123";
        if(encrypt(str)!=null){
            String result = encrypt(str);
            System.out.println("加密结果为"+result);
        }
    }

}
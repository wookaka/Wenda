package com.nowcoder.service;

import com.nowcoder.DAO.UserDAO;
import com.nowcoder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nowcoder.utils.MD5;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class UserService {


    @Autowired
    UserDAO userDAO;

    @Autowired
    MD5 md5;



    public int addUser(String name, String password){
        User user = new User();
        //需要带盐加密
        String salt = UUID.randomUUID().toString();
        String md_password = md5.encrypt(password+salt);
        String head_url = "";
        Random rand = new Random();
        head_url = String.format("http://images.nowcoder.com/head/%dt.png",rand.nextInt());

        user.setSalt(salt);
        user.setPassword(password);
        user.setHead_url(head_url);
        user.setName(name);
        return userDAO.addUser(user) > 0? 1: -1;
    }
}

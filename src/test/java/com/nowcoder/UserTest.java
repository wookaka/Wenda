package com.nowcoder;

import com.nowcoder.service.UserService;
import com.nowcoder.utils.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WendaApplication.class)
@Component
public class UserTest {
    @Autowired
    UserService userService;

    @Autowired
    MD5 md5;
    public void addUser(){
        userService.addUser(String.format("xxxx"), String.valueOf("xxxx"));
    }
    public static void main(String []args){
    }
}

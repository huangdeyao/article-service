package com.dy.oauth2service;

import com.dy.oauth2service.dao.user.UsersDao;
import com.dy.oauth2service.model.user.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Oauth2ServiceApplicationTests {

//    @Autowired
//    UsersDao usersRepository;
//
//    @Test
//    public void contextLoads() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String finalPassword = "{bcrypt}" + bCryptPasswordEncoder.encode("123456");
//
//        Users userInfo = new Users();
//        userInfo.setPassword(finalPassword);
//        userInfo.setUsername("user");
//        usersRepository.save(userInfo);
//
//    }

}

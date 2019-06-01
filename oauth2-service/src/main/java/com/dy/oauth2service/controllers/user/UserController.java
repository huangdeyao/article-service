package com.dy.oauth2service.controllers.user;

import com.dy.oauth2service.dao.user.UsersDao;
import com.dy.oauth2service.model.user.Users;
import com.dy.oauth2service.service.users.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: root
 * @date: 2018/2/11  12:18
 * @desc: IntelliJ IDEA
 */
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    UsersDao usersRepository;

    private static final String TYPE_USER = "article";

    @PostMapping(value = "/register")
    public String register(@RequestBody Users users) {
        Users register = usersRepository.findByUsername(users.getUsername());
        if (register != null) {
            return "该用户已经存在！";
        }
        if (users.getType().equals(TYPE_USER)) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String finalPassword = "{bcrypt}" + bCryptPasswordEncoder.encode(users.getPassword());

            Users userInfo = new Users();
            userInfo.setPassword(finalPassword);
            userInfo.setUsername(users.getUsername());
            usersRepository.save(userInfo);
            return "你好，管理员；注册成功！";
        } else {
            return "非法注册信息！！";
        }
    }

}

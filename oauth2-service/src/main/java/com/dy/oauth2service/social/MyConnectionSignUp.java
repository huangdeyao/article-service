package com.dy.oauth2service.social;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @author root
 * @date 2018/12/18 16:45
 */
@Component
public class MyConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户信息，默认创建用户并返回用户唯一标识
        return connection.getDisplayName();
    }
}

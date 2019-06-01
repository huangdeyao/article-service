package com.dy.oauth2service.service.users;


import com.dy.oauth2service.model.user.Users;

/**
 * @author: root
 * @create: 2018-09-11 11:42
 **/

public interface UserInfoService {
    /**
     * 获取登录人的信息
     * @return
     */
    Users getUserDetails();
}

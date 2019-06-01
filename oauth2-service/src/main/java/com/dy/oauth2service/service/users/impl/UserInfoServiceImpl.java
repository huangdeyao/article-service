package com.dy.oauth2service.service.users.impl;

import com.dy.oauth2service.dao.user.UsersDao;
import com.dy.oauth2service.model.user.Users;
import com.dy.oauth2service.service.users.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author: root
 * @create: 2018-09-11 11:44
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UsersDao usersRepository;

    @Override
    public Users getUserDetails() {
        // 获取登录人的权限信息  没有登录权限接口的是anonymous
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = ((UserDetails) principal);
            Users users = usersRepository.findByUsername(userDetails.getUsername());
            if (null != users) {
                return users;
            }
        }
        return null;
    }
}

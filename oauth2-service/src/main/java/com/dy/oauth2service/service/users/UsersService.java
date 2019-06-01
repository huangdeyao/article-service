package com.dy.oauth2service.service.users;

import com.dy.oauth2service.dao.user.UsersDao;
import com.dy.oauth2service.model.user.Role;
import com.dy.oauth2service.model.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author root
 */
@Service(value = "usersService")
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersDao usersRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(userId);
        if (users == null) {
            throw new UsernameNotFoundException(" not found " + userId + " , plase check your account again !");
        }
        /**
         * 获取权限
         */
        Collection<SimpleGrantedAuthority> collection = new HashSet<>();
        for (Role role : users.getList()) {
            collection.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new User(users.getUsername(), users.getPassword(), collection);
    }

}
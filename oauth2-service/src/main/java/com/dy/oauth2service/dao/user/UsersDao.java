package com.dy.oauth2service.dao.user;

import com.dy.oauth2service.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: root
 * @date: 2018/2/11  12:18
 * @desc: IntelliJ IDEA
 */
@Repository
public interface UsersDao extends JpaRepository<Users,Long> {

    Users findByUsername(String name);

}

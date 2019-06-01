package com.dy.oauth2service.dao.user;

import com.dy.oauth2service.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: root
 * @date: 2018/2/11  12:18
 * @desc: IntelliJ IDEA
 */
@Repository
public interface UsersRoleDao extends JpaRepository<UserRole,Long> {

    List<UserRole> findByuid(int uid);

    @Query(value = "select r.role_name from user_role ur left join role r on ur.rid=r.id where ur.uid = ?1",nativeQuery = true)
    List<String> findRoleName(int uid);
}

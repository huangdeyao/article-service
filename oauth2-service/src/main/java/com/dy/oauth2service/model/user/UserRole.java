package com.dy.oauth2service.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: root
 * @date: 2018/2/11  12:18
 * @desc: IntelliJ IDEA
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable{

    @Id
    @GeneratedValue
    private int id;
    private int uid;
    private int rid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}

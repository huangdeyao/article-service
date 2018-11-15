package com.dy.oauth2service.model.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: huangdeyao
 * @date: 2018/2/11  12:18
 * @desc: IntelliJ IDEA
 */
@Entity
@Table(name = "role")
public class Role implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String roleName;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name="menu_role",
            joinColumns={@JoinColumn(name="rid",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="mid",referencedColumnName="id")})
    private List<Menu> list = new ArrayList<>();

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

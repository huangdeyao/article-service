package com.dy.storageservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: root
 * @create: 2018-11-07 17:26
 **/
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class ArticleImage {
    /**
     * 自动生产uuid作为表主键
     *
     * @GenericGenerator 注解是hibernate的注解，声明一个主键生成器；
     * @GeneratedValue 注解的 generator属性指定主键生成器
     */
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    /**
     * 提交图片用户
     */
    private String userName;
    /**
     * 图片状态 0 初始状态，1 使用状态， 2 删除文章后状态
     */
    private int state;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 创建时间
     */
    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 修改时间
     */
    @LastModifiedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastmodifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastmodifiedTime() {
        return lastmodifiedTime;
    }

    public void setLastmodifiedTime(Date lastmodifiedTime) {
        this.lastmodifiedTime = lastmodifiedTime;
    }
}

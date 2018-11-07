package com.dy.storageservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: huangdeyao
 * @create: 2018-11-07 17:26
 **/
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class AritcleImage {

    @Id
    @GeneratedValue
    private int id;
    /**
     * 提交图片用户
     */
    private String userName;
    /**
     *  图片状态 0 初始状态，1 使用状态， 2 删除文章后状态
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

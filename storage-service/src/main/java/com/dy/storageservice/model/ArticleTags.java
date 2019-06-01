package com.dy.storageservice.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 标签
 * @author: root
 * @create: 2018-11-19 10:30
 **/
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class ArticleTags {
    @Id
    @GeneratedValue
    private int id;
    /**
     * 标签
     */
    private String tagsName;
    /**
     * 标签编码
     */
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

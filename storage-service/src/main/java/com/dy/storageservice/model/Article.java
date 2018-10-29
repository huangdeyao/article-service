package com.dy.storageservice.model;

import javax.persistence.*;

/**
 * 文章表
 * @author: huangdeyao
 * @create: 2018-10-29 15:30
 **/
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue
    private int id;
    /**
     * 作者
     */
    private String author;
    /**
     * 作者（用户id）
     */
    private int authorId;
    /**
     * 文章名称
     */
    private String title;
    /**
     * 缩略图
     */
    private String thumbnailUrl;
    /**
     * 文章内容
     */
    @Column(columnDefinition = "varchar(500000)")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package com.dy.elasticsearchservice.entities;

/**
 * @author: huangdeyao
 * @create: 2018-08-21 18:51
 **/
public class Article {
    private String author;
    private String content;
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

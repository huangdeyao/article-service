package com.dy.storageservice.controllers;

import com.dy.storageservice.dao.ArticleTagsDao;
import com.dy.storageservice.model.ArticleTags;
import com.dy.storageservice.result.RespCode;
import com.dy.storageservice.result.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: root
 * @create: 2018-11-19 10:29
 **/
@RestController
@RequestMapping("/api")
public class TagsController {

    @Autowired
    ArticleTagsDao articleTagsDao;

    @RequestMapping("/add/article/tags")
    public RespEntity addArticleTags(@RequestBody ArticleTags articleTags) {
        return new RespEntity(RespCode.SUCCESS, articleTagsDao.save(articleTags));
    }

    @RequestMapping("/get/article/tags")
    public RespEntity getArticleTags() {
        return new RespEntity(RespCode.SUCCESS, articleTagsDao.findAll());
    }
}

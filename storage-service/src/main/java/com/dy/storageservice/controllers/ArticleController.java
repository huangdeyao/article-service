package com.dy.storageservice.controllers;

import com.dy.storageservice.model.Article;
import com.dy.storageservice.result.RespCode;
import com.dy.storageservice.result.RespEntity;
import com.dy.storageservice.service.article.ArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @author: root
 * @create: 2018-10-29 15:19
 **/
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/add/article")
    public RespEntity addArticle(@RequestBody Article article) throws UnsupportedEncodingException {
        return new RespEntity(RespCode.SUCCESS, articleService.addArticle(article));
    }

    @RequestMapping("/get/all/article")
    public RespEntity getAllArticle(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = "20", required = false) int pageSize) {
        return new RespEntity(RespCode.SUCCESS, articleService.getAllArticle(pageNo, pageSize));
    }

    @RequestMapping("/get/article/details")
    public RespEntity getArticleDetails(String id) {
        if (StringUtils.isBlank(id)) {
            return new RespEntity(RespCode.EMPTY, "id can not be null!");
        }
        return new RespEntity(RespCode.SUCCESS, articleService.getArticleDetails(id));
    }
}

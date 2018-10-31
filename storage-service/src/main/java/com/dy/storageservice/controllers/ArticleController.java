package com.dy.storageservice.controllers;

import com.dy.storageservice.model.Article;
import com.dy.storageservice.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangdeyao
 * @create: 2018-10-29 15:19
 **/
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article/add")
    public Object addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }
}

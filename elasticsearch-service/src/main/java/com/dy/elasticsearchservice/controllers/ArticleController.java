package com.dy.elasticsearchservice.controllers;

import com.dy.elasticsearchservice.entities.Article;
import com.dy.elasticsearchservice.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;

/**
 * @author: root
 * @create: 2018-10-20 18:51
 **/
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @RequestMapping("/add/article")
    public Object addAritcle(@RequestBody Article article) throws IOException {
        Article article1 = new Article();
        article1.setTitle("测试标题123456");
        article1.setAuthor("hdy");
        byte[] asBytes = Base64.getDecoder().decode(article.getContent());
        String content = new String(asBytes, "utf-8");
        article1.setContent(content);

        return articleService.addArticle(article1);
    }

    @GetMapping("/get/article")
    public Object elasticGetDecoment() throws IOException {
        return articleService.getArticle();
    }
}

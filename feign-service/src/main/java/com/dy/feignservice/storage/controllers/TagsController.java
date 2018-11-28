package com.dy.feignservice.storage.controllers;

import com.dy.feignservice.storage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangdeyao
 * @create: 2018-11-28 16:52
 **/
@RestController
public class TagsController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/get/tags")
    public Object getTags(){
       return articleService.getArticleTags();
    }
}

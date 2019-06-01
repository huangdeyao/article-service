package com.dy.feignservice.storage.controllers;

import com.dy.feignservice.base.BaseController;
import com.dy.feignservice.storage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: root
 * @create: 2018-11-28 16:52
 **/
@RestController
public class TagsController extends BaseController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/get/tags")
    public Object getTags() {
        logger.info("************************************");
        return articleService.getArticleTags();
    }

    @RequestMapping(value = "/api/get/hello")
    public String getOauth() {
        return "feign get";
    }

    @RequestMapping(value = "/api/update/hello")
    public String updateOauth() {
        return "feign update";
    }


    @RequestMapping(value = "/api/add/hello")
    public String addOauth() {
        return "feign add";
    }

    @RequestMapping(value = "/api/delete/hello")
    public String deleteOauth() {
        return "feign delete";
    }
}

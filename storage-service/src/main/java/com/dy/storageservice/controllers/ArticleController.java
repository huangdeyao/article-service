package com.dy.storageservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangdeyao
 * @create: 2018-10-29 15:19
 **/
@RestController
@RequestMapping("/api")
public class ArticleController {

    @RequestMapping("/hello")
    public String getTest() {
        return "success";
    }
}

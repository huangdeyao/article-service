package com.dy.feignservice.storage.service.impl;

import com.dy.feignservice.storage.service.ArticleService;
import org.springframework.stereotype.Component;

/**
 * @author: root
 * @create: 2018-11-28 16:10
 **/
@Component
public class ArticleServiceFeignFallbackImpl implements ArticleService {

    @Override
    public String getArticleTags() {
        return "get tags error";
    }
}

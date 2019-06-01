package com.dy.feignservice.storage.service;

import com.dy.feignservice.storage.service.impl.ArticleServiceFeignFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: root
 * @create: 2018-11-28 16:03
 **/
@FeignClient(name = "storage-service", fallback = ArticleServiceFeignFallbackImpl.class)
public interface ArticleService {

    /**
     * 获取标签
     *
     * @return tag标签
     */
    @RequestMapping(value = "/api/get/article/tags", method = RequestMethod.GET)
    Object getArticleTags();
}

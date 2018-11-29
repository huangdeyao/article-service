package com.dy.feignservice.storage.service;

import com.dy.feignservice.storage.service.impl.ArticleServiceFeignFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: huangdeyao
 * @create: 2018-11-28 16:03
 **/
@FeignClient(name = "storage-service", url = "http://47.94.144.123:8770", fallback = ArticleServiceFeignFallbackImpl.class)
public interface ArticleService {

    /**
     * 获取标签
     *
     * @return tag标签
     */
    @RequestMapping(value = "/api/get/article/tags", method = RequestMethod.GET)
    Object getArticleTags();
}

package com.dy.storageservice.service.article;

import com.dy.storageservice.model.Article;

/**
 * @author: huangdeyao
 * @create: 2018-10-29 16:22
 **/
public interface ArticleService {
    /**
     * 添加文章
     * @param article
     * @return
     */
    Article addArticle(Article article);
}

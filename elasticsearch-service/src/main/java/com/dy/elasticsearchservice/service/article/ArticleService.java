package com.dy.elasticsearchservice.service.article;

import com.dy.elasticsearchservice.entities.Article;

import java.io.IOException;
import java.util.Map;

/**
 * @author: huangdeyao
 * @create: 2018-10-20 18:32
 **/
public interface ArticleService {

    /**
     * 新增文章
     * @param article
     * @return
     */
    Article addArticle(Article article) throws IOException;

    Map getArticle();
}

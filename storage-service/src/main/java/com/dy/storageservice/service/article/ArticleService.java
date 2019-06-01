package com.dy.storageservice.service.article;

import com.dy.storageservice.model.Article;
import org.springframework.data.domain.Page;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

/**
 * @author: root
 * @create: 2018-10-29 16:22
 **/
public interface ArticleService {
    /**
     * 添加文章
     * @param article
     * @return
     */
    Article addArticle(Article article) throws UnsupportedEncodingException;

    Page<Article> getAllArticle(int pageNo, int pageSize);

    Optional<Article> getArticleDetails(String id);
}

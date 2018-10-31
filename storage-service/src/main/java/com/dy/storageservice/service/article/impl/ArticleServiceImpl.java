package com.dy.storageservice.service.article.impl;

import com.dy.storageservice.dao.ArticleDao;
import com.dy.storageservice.model.Article;
import com.dy.storageservice.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: huangdeyao
 * @create: 2018-10-29 16:25
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Article addArticle(Article article) {
        return articleDao.save(article);
    }
}

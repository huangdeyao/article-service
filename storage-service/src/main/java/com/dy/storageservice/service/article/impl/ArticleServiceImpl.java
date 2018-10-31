package com.dy.storageservice.service.article.impl;

import com.dy.storageservice.dao.ArticleDao;
import com.dy.storageservice.model.Article;
import com.dy.storageservice.service.article.ArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

/**
 * @author: huangdeyao
 * @create: 2018-10-29 16:25
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Article addArticle(Article article) throws UnsupportedEncodingException {
        if (StringUtils.isNotEmpty(article.getContent())) {
            byte[] asBytes = Base64.getDecoder().decode(article.getContent());
            String content = new String(asBytes, "utf-8");
            article.setContent(content);
        }
        return articleDao.save(article);
    }

    @Override
    public List<Article> serrchArticle() {
        return articleDao.findAll();
    }
}

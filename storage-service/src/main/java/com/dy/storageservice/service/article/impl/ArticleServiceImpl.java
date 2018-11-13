package com.dy.storageservice.service.article.impl;

import com.dy.storageservice.dao.ArticleDao;
import com.dy.storageservice.model.Article;
import com.dy.storageservice.service.article.ArticleService;
import com.dy.storageservice.utils.FilterStringTypeUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Optional;

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
            // 提取说明
            Document doc = Jsoup.parse(article.getContent());
            System.out.println(doc.childNodeSize());
            Elements threm = doc.getElementsByTag("p");
            for (Element elements : threm) {
                Elements thrum = elements.getAllElements();
                if (FilterStringTypeUtils.checkCheseLength(thrum.toString())) {
                    System.out.println("thrum.toString() = " + thrum.toString());
                    article.setDescribe(thrum.toString());
                    break;
                }
            }

        }
        return articleDao.save(article);
    }

    @Override
    public Page<Article> getAllArticle(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return articleDao.findAll(pageable);
    }

    @Override
    public Optional<Article> getArticleDetails(String id) {
        return articleDao.findById(id);
    }
}

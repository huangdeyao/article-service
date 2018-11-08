package com.dy.storageservice.dao;

import com.dy.storageservice.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: huangdeyao
 * @create: 2018-10-29 16:20
 **/
@Repository
public interface ArticleDao extends JpaRepository<Article, String> {
}

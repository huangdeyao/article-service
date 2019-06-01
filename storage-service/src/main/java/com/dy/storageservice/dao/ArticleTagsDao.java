package com.dy.storageservice.dao;

import com.dy.storageservice.model.ArticleTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 标签
 *
 * @author: root
 * @create: 2018-11-19 10:35
 **/
@Repository
public interface ArticleTagsDao extends JpaRepository<ArticleTags, Long> {
}

package com.dy.storageservice.dao;

import com.dy.storageservice.model.ArticleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: root
 * @create: 2018-10-29 16:20
 **/
@Repository
public interface ArticleImageDao extends JpaRepository<ArticleImage, String> {
}

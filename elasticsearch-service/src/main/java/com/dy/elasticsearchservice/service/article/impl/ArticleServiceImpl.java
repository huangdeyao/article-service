package com.dy.elasticsearchservice.service.article.impl;

import com.dy.elasticsearchservice.entities.Article;
import com.dy.elasticsearchservice.service.article.ArticleService;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author: root
 * @create: 2018-10-20 18:32
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    TransportClient client;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Article addArticle(Article article) throws IOException {

        IndexResponse response =  client.prepareIndex("article", "content", "1").setSource(XContentFactory.jsonBuilder().startObject()
                .field("author", article.getAuthor())
                .field("content", article.getContent())
                .field("title", article.getTitle())
                .field("join_date", new Date())
                .endObject()).get();
        logger.info("=>" + response.getResult());

        return null;
    }

    @Override
    public Map getArticle() {
        GetResponse response = client.prepareGet("article","content","1").get();
        return response.getSource();
    }
}

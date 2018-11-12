package com.dy.storageservice;

import com.dy.storageservice.model.Article;
import com.dy.storageservice.service.article.ArticleService;
import com.dy.storageservice.utils.FilterStringTypeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageServiceApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void contextLoads() {

        Optional<Article> article = articleService.getArticleDetails("2c9169fe66f3618c0166f4629f060009");
        Document doc = Jsoup.parse(article.get().getContent());
        System.out.println(doc.childNodeSize());
        Elements threm = doc.getElementsByTag("p");
        for (Element elements : threm) {
            Elements thrum = elements.getAllElements();

            if (FilterStringTypeUtils.checkCheseLength(thrum.toString())) {
                System.out.println("========================================");
                System.out.println("thrum.toString() = " + thrum.toString());
                System.out.println("========================================");
            }
        }

    }

}

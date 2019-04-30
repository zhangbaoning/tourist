package me.baoning.tourist.service;

import me.baoning.tourist.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: zhangbaoning
 * @date: 2019/4/29
 * @since: JDK 1.8
 * @description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    ArticleService service;
    @Test
    public void getNewsByUser() {
       Article article =  service.getNewsByUser(1);
        System.out.println(article.toString());
    }
}
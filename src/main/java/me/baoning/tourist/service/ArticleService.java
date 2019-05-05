package me.baoning.tourist.service;

import me.baoning.tourist.dao.ArticleDao;
import me.baoning.tourist.model.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: zhangbaoning
 * @date: 2019/4/29
 * @since: JDK 1.8
 * @description: 文章服务层
 */
@Service
public class ArticleService {
    @Resource
    private ArticleDao dao;
    public Article getNewsByUser(int uid){
        Article article = new Article();
        article.setUid(uid);
        // 新闻类型为0
        article.setType(0);
       return dao.selectOne(article);
    }
    public Article getTravelsById(int id){
        Article article = new Article();
        article.setId(id);
        article.setType(1);
        return dao.selectOne(article);
    }
    public Article getViewById(int id){
        Article article = new Article();
        article.setId(id);
        article.setType(2);
        return dao.selectOne(article);
    }
}

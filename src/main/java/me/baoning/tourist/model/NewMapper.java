package me.baoning.tourist.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 新闻对象CRUD
 *
 * @author qyn
 */
@Mapper
public interface NewMapper {
    //统计所有新闻数量
    Integer countNewNum();

    //查询所有新闻信息
    List<News> findAllNews();

    //根据新闻标题查询
    News findByNtitle(String ntitle);

    //根据新闻内容路径查询
    News findByNpresent(String present);

    //根据图片路径查找
    News findByNewphoto(String newphoto);

    //插入新新闻信息
    void insertNews(News news);

    //根据关键字模糊查找
    List<News> mfindNews(String keywords);

    //根据nid删除新闻信息
    void deleteNewByNid(Integer nid);

    //根据nid查找新闻对象
    News findByNid(Integer nid);

    //更新概述
    void updateSummary(News news);

    //查询最新一天的新闻
    List<News> findByStimeFour();

    //根据发布时间排序查询所有
    List<News> findAllNewsByStime();
}

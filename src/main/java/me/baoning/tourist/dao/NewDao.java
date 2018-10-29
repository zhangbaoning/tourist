package me.baoning.tourist.dao;

import me.baoning.tourist.model.News;

import java.util.List;

/**
 * 新闻CRUD灵活性接口
 * @author qyn
 *
 */
public interface NewDao {


    /**
     * 查询所有新闻信息
     *
     * @return
     */
	List<News> findAllNews();


    /**
     * 统计所有新闻数量
     * @return
	 */
	Integer countNewNum();

    /**
     * 根据新闻标题查询
     * @param ntitle
     * @return
	 */
	News findByNtitle(String ntitle);


    /**
     * 根据新闻标题查询
     * @param present
     * @return
	 */
	News findByNpresent(String present);


    /**
     * 根据内容路径查找
     * @param newphoto
     * @return
	 */
	News findByNewphoto(String newphoto);


    /**
     * 插入新新闻信息
     * @param news
     * @return
	 */
	Integer insertNews(News news);


    /**
     * 根据关键字模糊查找
     * @param keywords
     * @return
     */
	List<News> mfindNews(String keywords);


    /**
     * 根据nid删除新闻信息
     * @param nid
     * @return
     */
	Integer deleteNewByNid(Integer nid);


    /**
     * 根据nid查找新闻对象
     * @param nid
     * @return
     */
	News findByNid(Integer nid);


    /**
     * 更新概述
     * @param news
     * @return
     */
	Integer updateSummary(News news);


    /**
     * 查询最新一天的新闻
     * @return
     */
	List<News> findByStimeFour();


    /**
     * 根据发布时间排序查询所有
     * @return
     */
	List<News> findAllNewsByStime();

}

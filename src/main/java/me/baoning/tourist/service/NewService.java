package me.baoning.tourist.service;

import me.baoning.tourist.dao.NewDao;
import me.baoning.tourist.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 新闻信息业务层
 * @author qyn
 *
 */
@Service
public class NewService {

	@Autowired private NewDao newDao;

	/**
	 * 查询所有新闻信息
	 * @return
	 */
	public List<News> findAllNews() {
		List<News> newList=newDao.findAllNews();
		return newList;
	}

	/**
	 * 根据新闻标题查询
	 * @param ntitle
	 * @return
	 */
	public News findByNtitle(String ntitle) {
		News news=newDao.findByNtitle(ntitle);
		return news;
	}

	/**
	 * 根据新闻标题查询
	 * @param present
	 * @return
	 *
     */
	public News findByNpresent(String present) {
		News news=newDao.findByNpresent(present);
		return news;
	}

	/**
	 * 根据内容路径查找
	 * @param newphoto
	 * @return
	 */
	public News findByNewphoto(String newphoto) {
		News news=newDao.findByNewphoto(newphoto);
		return news;
	}

	/**
	 * 插入新新闻信息
	 * @param ntitle
	 * @param currentTimeMillis
	 * @param summary
	 * @param present
	 * @param quarry
	 * @param newphoto
	 * @return
	 */
	public Integer insertNew(String ntitle, long currentTimeMillis,
			String summary, String present, String quarry, String newphoto) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date stime=new Date(currentTimeMillis);
		Integer i=newDao.insertNews(new News(ntitle, stime, summary, present, quarry, newphoto));
		return i;
	}

	/**
	 * 根据关键字模糊查找
	 * @param keywords
	 * @return
	 */
	public List<News> mfindNews(String keywords) {
		List<News> newsList=newDao.mfindNews(keywords);
		return newsList;
	}

	/**
	 * 根据nid删除新闻信息
	 * @param nid
	 * @return
	 */
	public Integer deleteNewByNid(Integer nid) {
		Integer i=newDao.deleteNewByNid(nid);
		return i;
	}

	/**
	 * 根据nid查找新闻对象
	 * @param nid
	 * @return
	 */
	public News findByNid(Integer nid) {
		News news=newDao.findByNid(nid);
		return news;
	}

	/**
	 * 更新概述
	 * @param nid
	 * @param summary
	 * @return
	 */
	public Integer updateSummary(Integer nid, String summary) {
		Integer i=newDao.updateSummary(new News(nid,summary));
		return i;
	}

	/**
	 * 查询最新一天的新闻
	 * @return
	 */
	public List<News> findByStimeFour() {
		List<News> newLists=newDao.findByStimeFour();
		return newLists;
	}

	/**
	 * 根据发布时间排序查询所有
	 * @return
	 */
	public List<News> findAllNewsByStime() {
		List<News> newLists=newDao.findAllNewsByStime();
		return newLists;
	}


}

package me.baoning.tourist.dao;

import me.baoning.tourist.model.News;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 新闻CRUD灵活性接口的实现类
 * @author qyn
 *
 */
@Repository("newDao")
public class MyBatisNewDao implements NewDao {
	
	/**注入SqlSessionTemplate用于调用CRUD*/
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

    //

    /**
     * 查询所有新闻信息
     *
     * @return
     */
    @Override
	public List<News> findAllNews() {
		return sqlSessionTemplate.selectList("findAllNews");
    }

    //

    /**
     * 统计所有新闻数量
     * @return
	 */
	@Override
	public Integer countNewNum() {
		return sqlSessionTemplate.selectOne("countNewNum");
    }

    //

    /**
     * 根据新闻标题查询
     * @param ntitle
     * @return
	 */
	@Override
	public News findByNtitle(String ntitle) {
		return sqlSessionTemplate.selectOne("findByNtitle", ntitle);
    }

    //

    /**
     * 根据新闻内容路径查询
     * @param present
     * @return
	 */
	@Override
	public News findByNpresent(String present) {
		return sqlSessionTemplate.selectOne("findByNpresent", present);
    }

    //

    /**
     * 根据图片路径查找
     * @param newphoto
     * @return
	 */
	@Override
	public News findByNewphoto(String newphoto) {
		return sqlSessionTemplate.selectOne("findByNewphoto", newphoto);
    }

    //

    /**
     * 插入新新闻信息
     * @param news
     * @return
	 */
	@Override
	public Integer insertNews(News news) {
		return sqlSessionTemplate.insert("insertNews", news);
    }

    //

    /**
     * 根据关键字模糊查找
     * @param keywords
     * @return
	 */
	@Override
	public List<News> mfindNews(String keywords) {
		return sqlSessionTemplate.selectList("mfindNews", keywords);
    }

    //

    /**
     * 根据nid删除新闻信息
     * @param nid
     * @return
	 */
	@Override
	public Integer deleteNewByNid(Integer nid) {
		return sqlSessionTemplate.delete("deleteNewByNid", nid);
    }

    //

    /**
     * 根据nid查询新闻信息
     * @param nid
     * @return
	 */
	@Override
	public News findByNid(Integer nid) {
		return sqlSessionTemplate.selectOne("findByNid", nid);
    }

    //

    /**
     * 更新概述
     * @param news
     * @return
	 */
	@Override
	public Integer updateSummary(News news) {
		return sqlSessionTemplate.update("updateSummary", news);
    }

    //

    /**
     * 查询最新一天的新闻
     * @return
	 */
	@Override
	public List<News> findByStimeFour() {
		return sqlSessionTemplate.selectList("findByStimeFour");
    }

    //

    /**
     * 根据发布时间排序查询所有
     * @return
	 */
	@Override
	public List<News> findAllNewsByStime() {
		return sqlSessionTemplate.selectList("findAllNewsByStime");
	}

	
}

package me.baoning.tourist.service;

import me.baoning.tourist.dao.DiscussDao;
import me.baoning.tourist.model.Discuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DiscussService {
	@Autowired private DiscussDao discussDao;

    /**
     * 统计所有评论数量
     * @return
     */
	public Integer countdiscussNum() {
		Integer discussNum=discussDao.countDiscussNum();
		return discussNum;
	}

    /**
     * 查询所有评论信息
     */
	public List<Discuss> findAllDiscuss() {
		List<Discuss> discussList=discussDao.findAllDiscuss();
		return discussList;
	}

    /**
     * 根据关键字模糊查找评论信息
     */

	public List<Discuss> mfindDiscuss(String keywords) {
		List<Discuss> discussList=discussDao.mfindDiscuss(keywords);
		return discussList;
	}

    /**
     * 删除选中的评论
     */
	public Integer deleteDiscussById(Integer id) {
		Integer i=discussDao.deleteDiscussById(id);
		return i;
	}

    /**
     * 插入新评论
     */

	public Integer insertDiscuss(Discuss discuss) {
		Integer i=discussDao.insertDiscuss(discuss);
		return i;
	}

    /**
     * 根据景点信息号查找评论
     */

	public List<Discuss> findDiscussByVid(Integer vid) {
		List<Discuss> discussList=discussDao.findDiscussByVid(vid);
		return discussList;
	}

    /**
     * 根据新闻号查找评论
     */

	public List<Discuss> findDiscussByNid(Integer nid) {
		List<Discuss> discussList=discussDao.findDiscussByNid(nid);
		return discussList;
	}

    /**
     * 根据问答号查找问答评论
     */
	public List<Discuss> findDiscussByQid(Integer qid) {
		List<Discuss> discussList=discussDao.findDiscussByQid(qid);
		return discussList;
	}

    /**
     * 根据游记号查找问答评论
     */
	public List<Discuss> findDiscussByTid(Integer tid) {
		List<Discuss> discussList=discussDao.findDiscussByTid(tid);
		return discussList;
	}
	

	
}

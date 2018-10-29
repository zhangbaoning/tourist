package me.baoning.tourist.dao;

import me.baoning.tourist.model.Discuss;

import java.util.List;

/**
 * 评论类CRUD灵活性接口
 * @author qyn
 *
 */
public interface DiscussDao {


    /**
     * 统计所有评论数量
     *
     * @return
     */
	Integer countDiscussNum();


    /**
     * 查询所有评论信息
	 * @return
	 */
	List<Discuss> findAllDiscuss();


    /**
     * 根据关键字模糊查找评论信息
     * @param keywords
	 * @return
	 */
	List<Discuss> mfindDiscuss(String keywords);


    /**
     * 删除选中的评论
     * @param id
	 * @return
	 */
	Integer deleteDiscussById(Integer id);


    /**
     * 插入新评论
     * @param discuss
	 * @return
	 */
	Integer insertDiscuss(Discuss discuss);


    /**
     * 根据景点信息号查找评论
     * @param vid
	 * @return
	 */
	List<Discuss> findDiscussByVid(Integer vid);


    /**
     * 根据新闻号查找评论
     * @param nid
	 * @return
	 */
	List<Discuss> findDiscussByNid(Integer nid);


    /**
     * 根据问答号查找评论
     * @param qid
	 * @return
	 */
	List<Discuss> findDiscussByQid(Integer qid);


    /**
     * 根据游记号查找问答评论
     * @param tid
	 * @return
	 */
	List<Discuss> findDiscussByTid(Integer tid);

}

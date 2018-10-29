package me.baoning.tourist.dao;

import me.baoning.tourist.model.Discuss;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论类CRUD灵活性接口的实现类
 * @author qyn
 *
 */
@Repository("discussDao")
public class MyBatisDiscussDao implements DiscussDao{
	
	/**注入SqlSessionTemplate用于调用CRUD*/
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	//统计所有评论数量
	@Override
	public Integer countDiscussNum() {
		return  sqlSessionTemplate.selectOne("countDiscussNum");
	}
	
	//查询所有评论信息
	@Override
	public List<Discuss> findAllDiscuss() {
		return  sqlSessionTemplate.selectList("findAllDiscuss");
	}
	
	//根据关键字模糊查找评论信息 
	@Override
	public List<Discuss> mfindDiscuss(String keywords) {
		return  sqlSessionTemplate.selectList("mfindDiscuss",keywords);
	}
		
	//删除选中的评论 
	@Override
	public Integer deleteDiscussById(Integer id) {
		return  sqlSessionTemplate.delete("deleteDiscussById",id);
	}
	
	//插入新评论
	@Override
	public Integer insertDiscuss(Discuss discuss) {
		return  sqlSessionTemplate.insert("insertDiscuss",discuss);
	}
	
	//根据景点信息号查找评论
	@Override
	public List<Discuss> findDiscussByVid(Integer vid) {
		return  sqlSessionTemplate.selectList("findDiscussByVid",vid);
	}
	
	//根据新闻号查找评论
	@Override
	public List<Discuss> findDiscussByNid(Integer nid) {
		return  sqlSessionTemplate.selectList("findDiscussByNid",nid);
	}
	
	//根据问答号查找评论
	@Override
	public List<Discuss> findDiscussByQid(Integer qid) {
		return  sqlSessionTemplate.selectList("findDiscussByQid",qid);
	}
	
	//根据游记号查找问答评论
	@Override
	public List<Discuss> findDiscussByTid(Integer tid) {
		return  sqlSessionTemplate.selectList("findDiscussByTid",tid);
	}
	
}

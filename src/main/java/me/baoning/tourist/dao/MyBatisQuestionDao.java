package me.baoning.tourist.dao;

import me.baoning.tourist.model.Question;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 *	问答类CRUD灵活性接口的实现类
 * @author qyn
 *
 */
@Repository("questionDao")
public class MyBatisQuestionDao implements QuestionDao{
	/**注入SqlSessionTemplate用于调用CRUD*/
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;


	/**
	 * 发布问答信息
	 *
	 * @param question
	 * @return
	 */
	@Override
	public Integer insertQuestion(Question question) {
		return sqlSessionTemplate.insert("insertQuestion", question);
	}


	/**
	 * 统计所有问题的个数
	 * @return
	 */
	@Override
	public Integer countQuestionNum() {
		return sqlSessionTemplate.selectOne("countQuestionNum");
	}


	/**
	 * 查询所有问答信息
	 * @return
	 */
	@Override
	public List<Question> findAllQuestion() {
		return sqlSessionTemplate.selectList("findAllQuestion");
	}


	/**
	 * 根据关键字模糊查找所需要的问答
	 * @param keywords
	 * @return
	 */
	@Override
	public List<Question> mfindQuestion(String keywords) {
		return sqlSessionTemplate.selectList("mfindQuestion", keywords);
	}


	/**
	 * 根据qid删除问答信息
	 * @param qid
	 * @return
	 */
	@Override
	public Integer deleteQuestionByQid(Integer qid) {
		return sqlSessionTemplate.delete("deleteQuestionByQid", qid);
	}


	/**
	 * 查询未解决的问题
	 * @return
	 */
	@Override
	public List<Question> findQuestionByState() {
		return sqlSessionTemplate.selectList("findQuestionByState");
	}


	/**
	 * 根据问题编号查询问题信息
	 * @param qid
	 * @return
	 */
	@Override
	public Question findByQid(Integer qid) {
		return sqlSessionTemplate.selectOne("findByQid",qid);
	}
	
}

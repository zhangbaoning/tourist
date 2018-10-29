package me.baoning.tourist.dao;

import me.baoning.tourist.model.Question;

import java.util.List;

/**
 * 问答类的灵活性CRUD接口
 * @author qyn
 *
 */
public interface QuestionDao {


    /**
     * 前台用户发布问题等待提问
     *
     * @param question
     * @return
     */
	Integer insertQuestion(Question question);


    /**
     * 统计所有问题的个数
	 * @return
	 */
	Integer countQuestionNum();


    /**
     * 查询所有的问答信息
	 * @return
	 */
	List<Question> findAllQuestion();


    /**
     * 根据关键字模糊查找问答
     * @param keywords
	 * @return
	 */
	List<Question> mfindQuestion(String keywords);


    /**
     * 根据qid删除问答信息
     * @param qid
	 * @return
	 */
	Integer deleteQuestionByQid(Integer qid);


    /**
     * 查询未解决的问题
	 * @return
	 */
	List<Question> findQuestionByState();


    /**
     * 根据问题编号查询问题信息
     * @param qid
	 * @return
	 */
	Question findByQid(Integer qid);
	
}

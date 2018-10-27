package me.baoning.tourist.service;

import me.baoning.tourist.dao.QuestionDao;
import me.baoning.tourist.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * 问题业务层
 * @author qyn
 *
 */

@Service
public class QuestionService {
	@Autowired private QuestionDao questionDao;


	/**
	 * 前台用户发布问题等待提问
	 * @param uid
	 * @param qtime
	 * @param present
	 * @param state
	 * @param title
	 * @return
	 */

	public Integer insertQusetion(Integer uid, Date qtime, String present,
			String state, String title) {
		Question question=new Question(uid,qtime,present,state,title);
		Integer i=questionDao.insertQuestion(question);
		return i;
	}


    /**
     * 后台查询所有问答根据状态和时间进行排序
     * @return
     */
	public List<Question> findAllQuestion() {
		List<Question> questionList=questionDao.findAllQuestion();
		return questionList;
	}


    /**
     * 统计问答的总个数
     * @return
     */
	public Integer countQuestionNum() {
		Integer i=questionDao.countQuestionNum();
		return i;
	}


    /**
     * 根据关键字模糊查找
     * @param keywords
     * @return
     */
	public List<Question> mfindQuestion(String keywords) {
		List<Question> questionList=questionDao.mfindQuestion(keywords);
		return questionList;
	}


    /**
     * 根据qid删除问答信息
     * @param qid
     * @return
     */
	public Integer deleteQuestionByQid(Integer qid) {
		Integer i=questionDao.deleteQuestionByQid(qid);
		return i;
	}


    /**
     * 查询未解决的问题
     * @return
     */
	public List<Question> findQuestionByState() {
		List<Question> squestionList=questionDao.findQuestionByState();
		return squestionList;
	}
	

    /**
     * 根据问题编号查询问题信息
     * @param qid
     * @return
     */
	public Question findByQid(Integer qid) {
		Question question=questionDao.findByQid(qid);
		return question;
	}

}

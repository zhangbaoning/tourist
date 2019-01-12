package me.baoning.tourist.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 问答类的CRUD接口
 *
 * @author qyn
 */
@Mapper
public interface QuestionMapper {

    //前台用户发布问题等待提问
    void insertQuestion(Question question);

    //统计所有问题的个数
    Integer countQuestionNum();

    //查询所有的问答信息
    List<Question> findAllQuestion();

    //根据关键字模糊查找问答
    List<Question> mfindQuestion(String keywords);

    //根据qid删除问答信息
    void deleteQuestionByQid(Integer qid);

    //查询未解决的问题
    List<Question> findQuestionByState();

    //根据问题编号查询问题信息
    Question findByQid(Integer qid);
}

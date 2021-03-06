package me.baoning.tourist.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评论对象 CRUD
 *
 * @author qyn
 */
@Mapper
public interface DiscussMapper {

    //统计所有评论数量
    Integer countDiscussNum();

    //根据关键字模糊查找评论信息
    List<Discuss> mfindDiscuss(String keywords);

    //查询所有评论信息
    List<Discuss> findAllDiscuss();

    //删除选中的评论
    void deleteDiscussById(Integer id);

    //插入新评论
    void insertDiscuss(Discuss discuss);

    //根据景点信息号查找评论
    List<Discuss> findDiscussByVid(Integer vid);

    //根据新闻号查找评论
    List<Discuss> findDiscussByNid(Integer nid);

    //根据问答号查找评论
    List<Discuss> findDiscussByQid(Integer qid);

    //根据游记号查找问答评论
    List<Discuss> findDiscussByTid(Integer tid);
}

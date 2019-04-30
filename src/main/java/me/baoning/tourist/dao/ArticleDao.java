package me.baoning.tourist.dao;

import me.baoning.tourist.model.Article;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author: zhangbaoning
 * @date: 2019/4/29
 * @since: JDK 1.8
 * @description: TODO
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {
}

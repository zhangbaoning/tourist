package me.baoning.tourist.dao;

import me.baoning.tourist.model.Operator;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * OperatorDao的具体实现类，通过sqlSessionTemplate与mapper方法相互联系
 * @author qyn
 * 
 */

//注入时改名为operatorDao

@Repository("operatorDao")

public class MyBatisOperatorDao implements OperatorDao{
	
	/**注入SqlSessionTemplate用于调用CRUD*/
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 连接OperatorDao接口(活跃)与OperatorMapper接口
	 * 根据管理员名查找管理员
	 * */
	@Override
	public Operator findByOpname(String opname) {
		return sqlSessionTemplate.selectOne("findByOpname",opname);
	}
	
}

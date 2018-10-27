package me.baoning.tourist.dao;

import me.baoning.tourist.model.Operator;

/**
 * Operator管理员类CRUD灵活性接口
 * @author qyn
 * 
 */
public interface OperatorDao {
	//根据管理员名查找管理员
	Operator findByOpname(String opname);
}

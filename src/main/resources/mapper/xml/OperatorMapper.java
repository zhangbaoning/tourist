package com.tarena.entity;

import com.tarena.annotation.Mapper;

/**
 * Operator管理员对象的CRUD
 * @author qyn
 * 
 */
@Mapper
public interface OperatorMapper {
	/**根据管理员姓名查询管理员信息*/
	com.tarena.entity.Operator findByOpname(String opname);
}

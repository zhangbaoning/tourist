package me.baoning.tourist.model;


import org.apache.ibatis.annotations.Mapper;

/**
 * Operator管理员对象的CRUD
 *
 * @author qyn
 */
@Mapper
public interface OperatorMapper {
    /**
     * 根据管理员姓名查询管理员信息
     */
    Operator findByOpname(String opname);
}

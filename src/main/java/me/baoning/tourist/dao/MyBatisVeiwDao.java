package me.baoning.tourist.dao;

import me.baoning.tourist.model.ViewSpot;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 景区信息的CRUD灵活性接口的实现类
 * @author qyn
 * 
 */
@Repository("veiwDao")
public class MyBatisVeiwDao implements ViewSpotDao {
	
	/**注入SqlSessionTemplate用于调用CRUD*/
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	//查询用户数量用于分页查询页面计算
	@Override
	public Integer countVeiwNum() {
		return sqlSessionTemplate.selectOne("countVeiwNum");
	}




	//查询所有用户信息
	public List<ViewSpot> findAllViewSpot() {
		return sqlSessionTemplate.selectList("findAllViewSpot");
	}
	
	//插入新的景点信息
	public Integer insertVeiw(ViewSpot veiwSpot) {
		return sqlSessionTemplate.insert("insertVeiw",veiwSpot);
	}
	
	//根据关键字模糊查找景点信息
	public List<ViewSpot> mfindVeiw(String keywords) {
		return sqlSessionTemplate.selectList("mfindVeiw",keywords);
	}
	
	//根据vid删除景点信息
	public Integer deleteVeiwByVid(Integer vid) {
		return sqlSessionTemplate.delete("deleteVeiwByVid",vid);
	}
	
	//根据vid查找景点信息
	public ViewSpot findVeiwByVid(Integer vid) {
		return sqlSessionTemplate.selectOne("findVeiwByVid",vid);
	}

	public ViewSpot findByVname(String vname) {
		return sqlSessionTemplate.selectOne("findByVname",vname);
	}

	public ViewSpot findByPresent(String present) {
		return sqlSessionTemplate.selectOne("findByPresent",present);
	}

	public ViewSpot findByVeiwPhoto(String veiwphoto) {
		return sqlSessionTemplate.selectOne("findByVeiwPhoto",veiwphoto);
	}

}

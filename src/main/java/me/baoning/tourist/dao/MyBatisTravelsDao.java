package me.baoning.tourist.dao;

import com.tarena.entity.Travels;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 游记CRUD灵活性接口的实现类
 * @author qyn
 *
 */
@Repository("travelsDao")
public class MyBatisTravelsDao implements TravelsDao{

	/**注入SqlSessionTemplate用于调用CRUD*/
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	//根据游记图片路径查询
	public Travels findByTravelsphoto(Travels t) {
		return sqlSessionTemplate.selectOne("findByTravelsphoto",t);
	}
	
	//添加新游记操作
	public Integer insertTravels(Travels travels) {
		return sqlSessionTemplate.insert("insertTravels",travels);
	}
	
	//根据游记内容路径查询
	public Travels findByTpresent(Travels t) {
		return sqlSessionTemplate.selectOne("findByTpresent",t);
	}
	
	//统计游记信息个数
	public Integer countTravelsNum() {
		return sqlSessionTemplate.selectOne("countTravelsNum");
	}
	
	//查找所有游记信息
	public List<Travels> findAlltravels() {
		return sqlSessionTemplate.selectList("findAlltravels");
	}
	
	//根据关键字模糊查找
	public List<Travels> mfindtravels(String keywords) {
		return sqlSessionTemplate.selectList("mfindtravels",keywords);
	}
	
	//根据id删除游记内容
	public Integer deleteTravelsByTid(Integer tid) {
		return sqlSessionTemplate.delete("deleteTravelsByTid",tid);
	}
	
	//根据tid查询游记
	public Travels findByTid(Integer tid) {
		return sqlSessionTemplate.selectOne("findByTid",tid);
	}
	
	//审核通过该游记
	public Integer auditing(Integer tid) {
		return sqlSessionTemplate.update("auditing",tid);
	}
	
	//根据id查询该用户的游记
	public List<Travels> findAllTravelsById(Integer userid) {
		return sqlSessionTemplate.selectList("findAllTravelsById",userid);
	}

}

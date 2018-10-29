package me.baoning.tourist.dao;

import me.baoning.tourist.model.Travels;
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


    /**
     * 根据游记图片路径查询
     *
     * @param t
     * @return
     */
    @Override
	public Travels findByTravelsphoto(Travels t) {
		return sqlSessionTemplate.selectOne("findByTravelsphoto", t);
    }


    /**
     * 添加新游记操作
     * @param travels
     * @return
	 */
	@Override
	public Integer insertTravels(Travels travels) {
		return sqlSessionTemplate.insert("insertTravels", travels);
    }


    /**
     * 根据游记内容路径查询
     * @param t
     * @return
	 */
	@Override
	public Travels findByTpresent(Travels t) {
		return sqlSessionTemplate.selectOne("findByTpresent", t);
    }


    /**
     * 统计游记信息个数
     * @return
	 */
	@Override
	public Integer countTravelsNum() {
		return sqlSessionTemplate.selectOne("countTravelsNum");
    }


    /**
     * 查找所有游记信息
     * @return
	 */
	@Override
	public List<Travels> findAlltravels() {
		return sqlSessionTemplate.selectList("findAlltravels");
    }


    /**
     * 根据关键字模糊查找
     * @param keywords
     * @return
	 */
	@Override
	public List<Travels> mfindtravels(String keywords) {
		return sqlSessionTemplate.selectList("mfindtravels", keywords);
    }


    /**
     * 根据id删除游记内容
     * @param tid
     * @return
	 */
	@Override
	public Integer deleteTravelsByTid(Integer tid) {
		return sqlSessionTemplate.delete("deleteTravelsByTid", tid);
    }


    /**
     * 根据tid查询游记
     * @param tid
     * @return
	 */
	@Override
	public Travels findByTid(Integer tid) {
		return sqlSessionTemplate.selectOne("findByTid", tid);
    }


    /**
     * 审核通过该游记
     * @param tid
     * @return
	 */
	@Override
	public Integer auditing(Integer tid) {
		return sqlSessionTemplate.update("auditing", tid);
    }


    /**
     * 根据id查询该用户的游记
     * @param userid
     * @return
	 */
	@Override
	public List<Travels> findAllTravelsById(Integer userid) {
		return sqlSessionTemplate.selectList("findAllTravelsById",userid);
	}

}

package me.baoning.tourist.dao;

import me.baoning.tourist.model.Travels;

import java.util.List;

/**
 * 游记CRUD灵活性接口
 * @author qyn
 *
 */
public interface TravelsDao {


	/**
	 * 根据游记图片路径查询
	 *
	 * @param t
	 * @return
	 */
	Travels findByTravelsphoto(Travels t);


	/**
	 * 添加新游记操作
	 * @param travels
	 * @return
	 */
	Integer insertTravels(Travels travels);


	/**
	 * 根据游记内容路径查询
	 * @param t
	 * @return
	 */
	Travels findByTpresent(Travels t);


	/**
	 * 统计游记信息个数
	 * @return
	 */
	Integer countTravelsNum();


	/**
	 * 查找所有游记信息
	 * @return
	 */
	List<Travels> findAlltravels();


	/**
	 * 根据关键字查询游记信息
	 * @param keywords
	 * @return
	 */
	List<Travels> mfindtravels(String keywords);


	/**
	 * 根据id删除游记信息
	 * @param tid
	 * @return
	 */
	Integer deleteTravelsByTid(Integer tid);


	/**
	 * 根据tid查询游记
	 * @param tid
	 * @return
	 */
	Travels findByTid(Integer tid);


	/**
	 * 审核通过该游记
	 * @param tid
	 * @return
	 */
	Integer auditing(Integer tid);


	/**
	 * 根据id查询该用户的游记
	 * @param userid
	 * @return
	 */
	List<Travels> findAllTravelsById(Integer userid);
	
}

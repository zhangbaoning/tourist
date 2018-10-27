package me.baoning.tourist.dao;

import me.baoning.tourist.model.ViewSpot;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qyn
 * 
 */
@Repository
public interface ViewSpotDao {
	//查询用户数量用于分页查询页面计算
	Integer countVeiwNum();
	
	//查询所有景点信息
	List<ViewSpot> findAllViewSpot();
	
	//插入新的景点信息
	Integer insertVeiw(ViewSpot veiwSpot);
	
	//模糊查询景点信息
	List<ViewSpot> mfindVeiw(String keywords);
	
	//根据vid删除景点信息
	Integer deleteVeiwByVid(Integer vid);

	//根据vid查询景点信息
	ViewSpot findVeiwByVid(Integer vid);
	
	//根据景区名进行查找，判断是否有存在
	ViewSpot findByVname(String vname);
	
	//根据内容路径进行查找，判断是否有存在
	ViewSpot findByPresent(String present);
	
	//根据图片路径进行查找，判断是否有存在
	ViewSpot findByVeiwPhoto(String veiwphoto);
}

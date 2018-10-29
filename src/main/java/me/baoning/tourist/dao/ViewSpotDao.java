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

    /**
     * 查询用户数量用于分页查询页面计算
     *
     * @return
     */
	Integer countVeiwNum();


    /**
     * 查询所有景点信息
     * @return
	 */
	List<ViewSpot> findAllViewSpot();


    /**
     * 插入新的景点信息
     * @param veiwSpot
     * @return
	 */
	Integer insertVeiw(ViewSpot veiwSpot);


    /**
     * 模糊查询景点信息
     * @param keywords
     * @return
	 */
	List<ViewSpot> mfindVeiw(String keywords);


    /**
     * 根据vid删除景点信息
     * @param vid
     * @return
	 */
	Integer deleteVeiwByVid(Integer vid);


    /**
     * 根据vid查询景点信息
     * @param vid
     * @return
	 */
	ViewSpot findVeiwByVid(Integer vid);


    /**
     * 根据景区名进行查找，判断是否有存在
     * @param vname
     * @return
	 */
	ViewSpot findByVname(String vname);


    /**
     * 根据内容路径进行查找，判断是否有存在
     * @param present
     * @return
	 */
	ViewSpot findByPresent(String present);


    /**
     * 根据图片路径进行查找，判断是否有存在
     * @param veiwphoto
     * @return
	 */
	ViewSpot findByVeiwPhoto(String veiwphoto);
}

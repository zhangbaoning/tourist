package me.baoning.tourist.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 景点信息的CRUD
 *
 * @author qyn
 */
@Mapper
public interface VeiwSpotMapper {
    //查询用户数量用于分页查询页面计算
    Integer countVeiwNum();

    //查询所有用户信息
    List<ViewSpot> findAllViewSpot();

    //插入新的景点信息
    void insertVeiw(ViewSpot ViewSpot);

    //模糊查询景点信息
    List<ViewSpot> mfindVeiw(String keywords);

    //根据vid删除景点信息
    void deleteVeiwByVid(Integer vid);

    //根据vid查询景点信息
    ViewSpot findVeiwByVid(Integer vid);

    //根据景区名进行查找，判断是否有存在
    ViewSpot findByVname(String vname);

    //根据内容路径进行查找，判断是否有存在
    ViewSpot findByPresent(String present);

    //根据图片路径进行查找，判断是否有存在
    ViewSpot findByVeiwPhoto(String veiwphoto);
}

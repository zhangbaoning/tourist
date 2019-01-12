package me.baoning.tourist.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 游记CRUD
 *
 * @author qyn
 */
@Mapper
public interface TravelsMapper {

    //根据游记图片路径查询
    Travels findByTravelsphoto(Travels t);

    //根据游记内容路径查询
    Travels findByTpresent(Travels t);

    //添加新游记操作
    void insertTravels(Travels travels);

    //根据游记内容路径查询
    Travels findByTpresent(String present, Integer uid);

    //统计游记信息个数
    Integer countTravelsNum();

    //查找所有游记信息
    List<Travels> findAlltravels();

    //根据关键字查询游记信息
    List<Travels> mfindtravels(String keywords);

    //根据id删除游记信息
    Integer deleteTravelsByTid(Integer tid);

    //根据tid查询游记
    Travels findByTid(Integer tid);

    //审核通过该游记
    void auditing(Integer tid);

    //根据id查询该用户的游记
    List<Travels> findAllTravelsById(Integer userid);
}

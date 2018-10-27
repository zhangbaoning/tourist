package me.baoning.tourist.service;

import me.baoning.tourist.dao.TravelsDao;
import me.baoning.tourist.model.Travels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 游记业务层
 *
 * @author qyn
 */
@Service
public class TravelsService {

    @Autowired
    private TravelsDao travelsDao;
    private TravelsDao travelsDao1;

    //根据游记图片路径查询
    public Travels findByTravelsphoto(Travels t) {


        Travels travels = travelsDao1.findByTravelsphoto(t);
        return travels;
    }

    //添加新游记操作
    public Integer insertTravels(Integer uid, String title, String present, String travelsphoto) {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date atime = new Date(System.currentTimeMillis());
        Integer i = travelsDao.insertTravels(new Travels(uid, title, atime, present, travelsphoto, "未审核"));
        return i;
    }

    //根据游记内容路径查询
    public Travels findByTpresent(Travels t) {

        Travels travels = travelsDao.findByTpresent(t);
        return travels;
    }

    //统计游记信息个数
    public Integer countTravelsNum() {

        Integer i = travelsDao.countTravelsNum();
        return i;
    }

    //查找所有游记信息
    public List<Travels> findAlltravels() {

        List<Travels> travelsList = travelsDao.findAlltravels();
        return travelsList;
    }

    //根据关键字模糊查找
    public List<Travels> mfindtravels(String keywords) {

        List<Travels> travelsList = travelsDao.mfindtravels(keywords);
        return travelsList;
    }

    //根据id删除游记信息
    public Integer deleteTravelsByTid(Integer tid) {

        Integer i = travelsDao.deleteTravelsByTid(tid);
        return i;
    }

    //根据tid查询游记
    public Travels findByTid(Integer tid) {

        Travels travels = travelsDao.findByTid(tid);
        return travels;
    }

    //审核通过该游记
    public Integer auditing(Integer tid) {

        Integer i = travelsDao.auditing(tid);
        return i;
    }

    //根据id查询该用户的游记
    public List<Travels> findAllTravelsById(Integer userid) {

        List<Travels> travelsList = travelsDao.findAllTravelsById(userid);
        return travelsList;
    }

}

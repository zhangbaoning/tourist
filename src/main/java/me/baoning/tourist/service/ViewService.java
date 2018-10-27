package me.baoning.tourist.service;

import me.baoning.tourist.model.ViewSpot;
import me.baoning.tourist.dao.ViewSpotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * 景点信息业务层
 * @author qyn
 *
 */
@Service
public class ViewService {
    @Autowired private ViewSpotDao viewSpotDao;

    //后台统计总个数，用于分页查询页数计算
    public Integer countViewNum() {
        Integer veiwNum=viewSpotDao.countVeiwNum();
        return veiwNum;
    }

    //查询所有景点信息
    public List<ViewSpot> findAllViewSpot() {
        List<ViewSpot>veiwList=viewSpotDao.findAllViewSpot();
        return veiwList;
    }

    //插入新veiwspot并用输出流输出图片和文字
    public Integer insertVeiw(String vname, String present, String veiwphoto) throws IOException {
        Integer i=viewSpotDao.insertVeiw(new ViewSpot(vname, present, veiwphoto));
        return i;
    }

    //模糊查询景点信息
    public List<ViewSpot> mfindveiw(String keywords) {
        List<ViewSpot>veiwList=viewSpotDao.mfindVeiw(keywords);
        return veiwList;
    }

    //根据vid删除景点信息
    public Integer deleteVeiwByVid(Integer vid) {
        Integer i=viewSpotDao.deleteVeiwByVid(vid);
        return i;
    }

    //根据vid查询景点信息
    public ViewSpot findVeiwByVid(Integer vid) {
        ViewSpot veiwSpot=viewSpotDao.findVeiwByVid(vid);
        return veiwSpot;
    }

    //根据景区名进行查找，判断是否有存在
    public ViewSpot findByVname(String vname) {
        ViewSpot veiwSpot=viewSpotDao.findByVname(vname);
        return veiwSpot;
    }

    //根据内容路径进行查找，判断是否有存在
    public ViewSpot findByPresent(String present) {
        ViewSpot veiwSpot=viewSpotDao.findByPresent(present);
        return veiwSpot;
    }

    //根据图片路径进行查找，判断是否有存在
    public ViewSpot findByVeiwPhoto(String veiwphoto) {
        ViewSpot veiwSpot=viewSpotDao.findByVeiwPhoto(veiwphoto);
        return veiwSpot;
    }

}

package me.baoning.tourist.controller;

import me.baoning.tourist.model.Travels;
import me.baoning.tourist.model.User;
import me.baoning.tourist.service.TravelsService;
import me.baoning.tourist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * 后台用户管理页面控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/designTravels")
public class DesignTravelsController {
	
	//注入TravelsService
	@Resource
	private TravelsService travelsService;
	
	//注入UserService
	@Resource
	private UserService userService;
	
	@RequestMapping("/changeTravelsPage.do")
	//上一页下一页操作
	public String changeRoomPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<Travels> travelsList=(List<Travels>) req.getSession().getAttribute("travelsList");
		Integer travelsNum=(Integer) req.getSession().getAttribute("travelsNum");
		if(travelsNum%7==0){
			req.getSession().setAttribute("travelsPage",travelsNum/7);
		}else {
			req.getSession().setAttribute("travelsPage",travelsNum/7+1);
		}
		int fromindex=(rpage-1)*7;
		int toindex=fromindex+7;
		List<Travels>travelsLists;
		if(toindex>=travelsNum){
			travelsLists=travelsList.subList(fromindex, travelsNum);
		}else {
			travelsLists=travelsList.subList(fromindex, toindex);
		}
		req.setAttribute("travelsLists", travelsLists);
		req.setAttribute("nowPage", rpage);
		return "designTravels";
	}
	
	@RequestMapping("/mfindTravels.do")
	//根据关键字模糊查找
	public String mfindTravels(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		String keywords=req.getParameter("keywords");
		List<Travels> travelsList=travelsService.mfindtravels(keywords);
		Integer travelsNum=travelsList.size();
		req.getSession().setAttribute("travelsNum", travelsNum);
		if(travelsNum%7==0){
			req.getSession().setAttribute("travelsPage",travelsNum/7);
		}else {
			req.getSession().setAttribute("travelsPage",travelsNum/7+1);
		}
		if(travelsNum==0){
			req.setAttribute("nowPage", 0);
		}else {
			req.setAttribute("nowPage", 1);
		}
		req.getSession().setAttribute("travelsList", travelsList);
		int fromindex=0;
		int toindex=7;
		List<Travels>travelsLists;
		if(toindex>=travelsNum){
			travelsLists=travelsList.subList(fromindex, travelsNum);
		}else {
			travelsLists=travelsList.subList(fromindex, toindex);
		}
		req.setAttribute("travelsLists", travelsLists);
		return "designTravels"; 
	}
	
	@RequestMapping("/deleteTravels.do")
	//根据vid删除游记
	public String deleteVeiwById(HttpServletRequest req){
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		Integer uid=Integer.parseInt(req.getParameter("uid"));
		String present=req.getParameter("present");
		String travelsphoto=req.getParameter("travelsphoto");
		Integer i=travelsService.deleteTravelsByTid(tid);
		User user=userService.findByUid(uid);
		String presentPath=req.getSession().getServletContext().getRealPath("/")+"travels/"+user.getNickname()+"/"+present+".txt";
		File presentFile=new File(presentPath);
		if(presentFile.exists()){
			presentFile.delete();
		}
		String veiwphotoPath1=req.getSession().getServletContext().getRealPath("/")+"travels/"+user.getNickname()+"/"+travelsphoto+"1.png";
		String veiwphotoPath2=req.getSession().getServletContext().getRealPath("/")+"travels/"+user.getNickname()+"/"+travelsphoto+"2.png";
		File veiwphotoFile1=new File(veiwphotoPath1);
		File veiwphotoFile2=new File(veiwphotoPath2);
		if(veiwphotoFile1.exists()){
			veiwphotoFile1.delete();
		}
		if(veiwphotoFile2.exists()){
			veiwphotoFile2.delete();
		}
		return "redirect:../hindex/travelsWork.do";
	}
	
	@RequestMapping("/loadTravels.do")
	//加载景点信息详细页面
	public String loadTravels(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("utf-8");
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		Integer uid=Integer.parseInt(req.getParameter("uid"));
		Travels travels=travelsService.findByTid(tid);
		User user=userService.findByUid(uid);
		req.setAttribute("user",user);
		req.setAttribute("travels",travels);
		req.setAttribute("travelsphoto1","../travels/"+user.getNickname()+"/"+travels.getTravelsphoto()+"1.png");
		req.setAttribute("travelsphoto2","../travels/"+user.getNickname()+"/"+travels.getTravelsphoto()+"2.png");
		String presentFlie=req.getSession().getServletContext().getRealPath("/")+"travels/"+user.getNickname()+"/"+travels.getPresent()+".txt";
		File presentFile=new File(presentFlie);
		StringBuffer present1=new StringBuffer();
		if(presentFile.exists()){
			FileInputStream fis=new FileInputStream(presentFile);
			InputStreamReader isr=new InputStreamReader(fis,"utf-8");
			BufferedReader br=new BufferedReader(isr);
			String read="";
			while((read=br.readLine())!=null){
				present1.append("\n"+read);
			}
		}
		req.setAttribute("present1", present1);
		return "auditing";
	}
}

package me.baoning.tourist.controller;

import me.baoning.tourist.model.ViewSpot;
import me.baoning.tourist.service.VeiwService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * 后台景点信息管理页面控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/designVeiw")
public class DesignViewSpotController {
	
	//注入VeiwService
	@Resource
	private VeiwService veiwService;
	
	@RequestMapping("/insertNewViewSpot.do")
	public String insertNewViewSpot(){
		return "insertVeiw";
	}
	
	@RequestMapping("/changeVeiwPage.do")
	//上一页下一页操作
	public String changeRoomPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<ViewSpot> veiwList=(List<ViewSpot>) req.getSession().getAttribute("veiwList");
		Integer veiwNum=(Integer) req.getSession().getAttribute("veiwNum");
		if(veiwNum%7==0){
			req.getSession().setAttribute("veiwPage",veiwNum/7);
		}else {
			req.getSession().setAttribute("veiwPage",veiwNum/7+1);
		}
		int fromindex=(rpage-1)*7;
		int toindex=fromindex+7;
		List<ViewSpot>veiwLists;
		if(toindex>=veiwNum){
			veiwLists=veiwList.subList(fromindex, veiwNum);
		}else {
			veiwLists=veiwList.subList(fromindex, toindex);
		}
		req.setAttribute("veiwLists", veiwLists);
		req.setAttribute("nowPage", rpage);
		return "designVeiw";
	}
	
	@RequestMapping("/mfindVeiw.do")
	//根据关键字模糊查找
	public String mfindVeiw(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		String keywords=req.getParameter("keywords");
		List<ViewSpot> veiwList=veiwService.mfindveiw(keywords);
		Integer veiwNum=veiwList.size();
		req.getSession().setAttribute("veiwNum", veiwNum);
		if(veiwNum%7==0){
			req.getSession().setAttribute("veiwPage",veiwNum/7);
		}else {
			req.getSession().setAttribute("veiwPage",veiwNum/7+1);
		}
		if(veiwNum==0){
			req.setAttribute("nowPage", 0);
		}else {
			req.setAttribute("nowPage", 1);
		}
		req.getSession().setAttribute("veiwList", veiwList);
		int fromindex=0;
		int toindex=7;
		List<ViewSpot>veiwLists;
		if(toindex>=veiwNum){
			veiwLists=veiwList.subList(fromindex, veiwNum);
		}else {
			veiwLists=veiwList.subList(fromindex, toindex);
		}
		req.setAttribute("veiwLists", veiwLists);
		return "designVeiw"; 
	}
	
	@RequestMapping("/deleteVeiw.do")
	//根据vid删除景点信息
	public String deleteVeiwById(HttpServletRequest req){
		Integer vid=Integer.parseInt(req.getParameter("vid"));
		String present=req.getParameter("present");
		String veiwphoto=req.getParameter("veiwphoto");
		Integer i=veiwService.deleteVeiwByVid(vid);
		String presentPath=req.getSession().getServletContext().getRealPath("/")+"veiwspot/"+present+".txt";
		File presentFile=new File(presentPath);
		if(presentFile.exists()){
			presentFile.delete();
		}
		String veiwphotoPath1=req.getSession().getServletContext().getRealPath("/")+"veiwphoto/"+veiwphoto+"1.png";
		String veiwphotoPath2=req.getSession().getServletContext().getRealPath("/")+"veiwphoto/"+veiwphoto+"2.png";
		File veiwphotoFile1=new File(veiwphotoPath1);
		File veiwphotoFile2=new File(veiwphotoPath2);
		if(veiwphotoFile1.exists()){
			veiwphotoFile1.delete();
		}
		if(veiwphotoFile2.exists()){
			veiwphotoFile2.delete();
		}
		return "redirect:../hindex/veiwWork.do";
	}
	
	@RequestMapping("/loadVeiw.do")
	//加载景点信息详细页面
	public String loadVeiw(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("utf-8");
		Integer vid=Integer.parseInt(req.getParameter("vid"));
		ViewSpot veiwSpot=veiwService.findVeiwByVid(vid);
		req.setAttribute("nowveiw",veiwSpot);
		req.setAttribute("veiwphoto1","../veiwphoto/"+veiwSpot.getVeiwphoto()+"1.png");
		req.setAttribute("veiwphoto2","../veiwphoto/"+veiwSpot.getVeiwphoto()+"2.png");
		String presentFlie=req.getSession().getServletContext().getRealPath("/")+"veiwspot/"+veiwSpot.getPresent()+".txt";
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
		return "singleVeiw";
	}
	
}

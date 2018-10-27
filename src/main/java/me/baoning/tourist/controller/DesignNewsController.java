package me.baoning.tourist.controller;

import me.baoning.tourist.model.News;
import me.baoning.tourist.service.NewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * 后台新闻管理页面控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/designNews")
public class DesignNewsController {
	
	//注入NewService
	@Resource
	private NewService newService;
	
	//跳转插入新新闻页面
	@RequestMapping("/insertNews.do")
	public String insertNewVeiwSpot(){
		return "insertNews";
	}
	
	//根据关键字模糊查找新闻
	@RequestMapping("/mfindNews.do")
	public String mfindNews(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		String keywords=req.getParameter("keywords");
		List<News> newList=newService.mfindNews(keywords);
		Integer newNum=newList.size();
		req.getSession().setAttribute("newNum", newNum);
		if(newNum%7==0){
			req.getSession().setAttribute("newPage",newNum/7);
		}else {
			req.getSession().setAttribute("newPage",newNum/7+1);
		}
		if(newNum==0){
			req.setAttribute("nowPage", 0);
		}else {
			req.setAttribute("nowPage", 1);
		}
		req.getSession().setAttribute("newList", newList);
		int fromindex=0;
		int toindex=7;
		List<News>newLists;
		if(toindex>=newNum){
			newLists=newList.subList(fromindex, newNum);
		}else {
			newLists=newList.subList(fromindex, toindex);
		}
		req.setAttribute("newLists", newLists);
		return "designNews";
	}
	
	@RequestMapping("/deleteNew.do")
	//根据vid删除景点信息
	public String deleteVeiwById(HttpServletRequest req){
		Integer nid=Integer.parseInt(req.getParameter("nid"));
		String present=req.getParameter("present");
		String newphoto=req.getParameter("newphoto");
		Integer i=newService.deleteNewByNid(nid);
		String presentPath=req.getSession().getServletContext().getRealPath("/")+"news/"+present+".txt";
		File presentFile=new File(presentPath);
		if(presentFile.exists()){
			presentFile.delete();
		}
		String veiwphotoPath1=req.getSession().getServletContext().getRealPath("/")+"newphoto/"+newphoto+"1.png";
		String veiwphotoPath2=req.getSession().getServletContext().getRealPath("/")+"newphoto/"+newphoto+"2.png";
		String veiwphotoPath3=req.getSession().getServletContext().getRealPath("/")+"newphoto/"+newphoto+"3.png";
		File veiwphotoFile1=new File(veiwphotoPath1);
		File veiwphotoFile2=new File(veiwphotoPath2);
		File veiwphotoFile3=new File(veiwphotoPath3);
		if(veiwphotoFile1.exists()){
			veiwphotoFile1.delete();
		}
		if(veiwphotoFile2.exists()){
			veiwphotoFile2.delete();
		}
		if(veiwphotoFile3.exists()){
			veiwphotoFile3.delete();
		}
		return "redirect:../hindex/newsWork.do";
	}
	
	@RequestMapping("/changeNewPage.do")
	//上一页下一页操作
	public String changeRoomPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<News> newList=(List<News>) req.getSession().getAttribute("newList");
		Integer newNum=(Integer) req.getSession().getAttribute("newNum");
		if(newNum%7==0){
			req.getSession().setAttribute("newPage",newNum/7);
		}else {
			req.getSession().setAttribute("newPage",newNum/7+1);
		}
		int fromindex=(rpage-1)*7;
		int toindex=fromindex+7;
		List<News>newLists;
		if(toindex>=newNum){
			newLists=newList.subList(fromindex, newNum);
		}else {
			newLists=newList.subList(fromindex, toindex);
		}
		req.setAttribute("newLists", newLists);
		req.setAttribute("nowPage", rpage);
		return "designNews";
	}
	
	@RequestMapping("/loadNews.do")
	//加载新闻信息详细页面
	public String loadNews(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("utf-8");
		Integer nid=Integer.parseInt(req.getParameter("nid"));
		News news=newService.findByNid(nid);
		req.setAttribute("nownews",news);
		req.setAttribute("newphoto1","../newphoto/"+news.getNewphoto()+"1.png");
		req.setAttribute("newphoto2","../newphoto/"+news.getNewphoto()+"2.png");
		req.setAttribute("newphoto3","../newphoto/"+news.getNewphoto()+"3.png");
		String presentFlie=req.getSession().getServletContext().getRealPath("/")+"news/"+news.getPresent()+".txt";
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
		return "singleNews";
	}
}

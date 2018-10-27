package me.baoning.tourist.controller;

import me.baoning.tourist.model.Discuss;
import me.baoning.tourist.service.DiscussService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 后台新闻管理页面控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/designDiscuss")
public class DesignDiscussController {
	
	//注入DiscussService
	@Resource
	private DiscussService discussService;
	
	@RequestMapping("/changeDiscussPage.do")
	//上一页下一页操作
	public String changeDiscussPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<Discuss> discussList=(List<Discuss>) req.getSession().getAttribute("discussList");
		Integer discussNum=(Integer) req.getSession().getAttribute("discussNum");
		if(discussNum%7==0){
			req.getSession().setAttribute("discussPage",discussNum/7);
		}else {
			req.getSession().setAttribute("discussPage",discussNum/7+1);
		}
		int fromindex=(rpage-1)*7;
		int toindex=fromindex+7;
		List<Discuss>discussLists;
		if(toindex>=discussNum){
			discussLists=discussList.subList(fromindex, discussNum);
		}else {
			discussLists=discussList.subList(fromindex, toindex);
		}
		req.setAttribute("discussLists", discussLists);
		req.setAttribute("nowPage", rpage);
		return "designDiscuss";
	}
	
	@RequestMapping("/mfindDiscuss.do")
	//根据关键字模糊查找
	public String mfindDiscuss(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		String keywords=req.getParameter("keywords");
		List<Discuss> discussList=discussService.mfindDiscuss(keywords);
		Integer discussNum=discussList.size();
		req.getSession().setAttribute("discussNum", discussNum);
		if(discussNum%7==0){
			req.getSession().setAttribute("discussPage",discussNum/7);
		}else {
			req.getSession().setAttribute("discussPage",discussNum/7+1);
		}
		if(discussNum==0){
			req.setAttribute("nowPage", 0);
		}else {
			req.setAttribute("nowPage", 1);
		}
		req.getSession().setAttribute("discussList", discussList);
		int fromindex=0;
		int toindex=7;
		List<Discuss>discussLists;
		if(toindex>=discussNum){
			discussLists=discussList.subList(fromindex, discussNum);
		}else {
			discussLists=discussList.subList(fromindex, toindex);
		}
		req.setAttribute("discussLists", discussLists);
		return "designDiscuss"; 
	}
	
	@RequestMapping("/deleteDiscuss.do")
	//根据vid删除游记
	public String deleteDiscussById(HttpServletRequest req){
		Integer id=Integer.parseInt(req.getParameter("id"));
		Integer i=discussService.deleteDiscussById(id);
		return "redirect:../hindex/discussWork.do";
	}
}

package me.baoning.tourist.controller;

import me.baoning.tourist.model.News;
import me.baoning.tourist.service.NewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 前台所有新闻信息控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/allNews")
public class AllNewsController {
	
	//注入NewService
	@Resource
	private NewService newService;
	
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
		return "allNews";
	}
}

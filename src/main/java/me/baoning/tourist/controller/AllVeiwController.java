package me.baoning.tourist.controller;

import me.baoning.tourist.model.ViewSpot;
import me.baoning.tourist.service.VeiwService;
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
@RequestMapping("/allVeiw")
public class AllVeiwController {
	
	//注入VeiwService
	@Resource
	private VeiwService veiwService;
	
	@RequestMapping("/changeVeiwPage.do")
	//上一页下一页操作
	public String changeRoomPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<ViewSpot> veiwList=(List<ViewSpot>) req.getSession().getAttribute("veiwList");
		Integer veiwNum=(Integer) req.getSession().getAttribute("veiwNum");
		if(veiwNum%6==0){
			req.getSession().setAttribute("veiwPage",veiwNum/6);
		}else {
			req.getSession().setAttribute("veiwPage",veiwNum/6+1);
		}
		int fromindex=(rpage-1)*6;
		int toindex=fromindex+6;
		List<ViewSpot>veiwLists;
		if(toindex>=veiwNum){
			veiwLists=veiwList.subList(fromindex, veiwNum);
		}else {
			veiwLists=veiwList.subList(fromindex, toindex);
		}
		req.setAttribute("veiwLists", veiwLists);
		req.setAttribute("nowPage", rpage);
		return "allVeiw";
	}
}

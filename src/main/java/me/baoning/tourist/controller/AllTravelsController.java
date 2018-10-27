package me.baoning.tourist.controller;

import com.tarena.entity.TravelsMore;
import me.baoning.tourist.service.TravelsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 所有景点信息列表页面控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/allTravels")
public class AllTravelsController {
	//注入TravelsService
	@Resource
	private TravelsService travelsService;
	
	@RequestMapping("/changeTravelsPage.do")
	//上一页下一页操作
	public String changeTravelsPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<TravelsMore> travelsMoreList=(List<TravelsMore>) req.getSession().getAttribute("travelsMoreList");
		Integer travelsNum=(Integer) req.getSession().getAttribute("travelsNum");
		if(travelsNum%3==0){
			req.getSession().setAttribute("travelsPage",travelsNum/3);
		}else {
			req.getSession().setAttribute("travelsPage",travelsNum/3+1);
		}
		int fromindex=(rpage-1)*3;
		int toindex=fromindex+3;
		List<TravelsMore>travelsMoreLists;
		if(toindex>=travelsNum){
			travelsMoreLists=travelsMoreList.subList(fromindex, travelsNum);
		}else {
			travelsMoreLists=travelsMoreList.subList(fromindex, toindex);
		}
		req.setAttribute("travelsMoreLists", travelsMoreLists);
		req.setAttribute("nowPage", rpage);
		return "allTravels";
	}
}

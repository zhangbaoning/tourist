package me.baoning.tourist.controller;

import me.baoning.tourist.model.*;
import me.baoning.tourist.service.ArticleService;
import me.baoning.tourist.service.DiscussService;
import me.baoning.tourist.service.TravelsService;
import me.baoning.tourist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 游记详细页面控制层
 * @author qyn
 *
 */

@Controller
@RequestMapping("/travelsDetail")
public class TravelsDetailController {
	@Resource
	private DiscussService discussService;
	@Resource
	private TravelsService travelsService;
	@Resource
	private UserService userService;
	@Resource
    private ArticleService articleService;
	/**
	 * 前台跳转景点信息页面
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/travelsDetail.do")
	public String travelsDetail(HttpServletRequest req) throws IOException {
		req.setCharacterEncoding("utf-8");
		Integer tid = Integer.parseInt(req.getParameter("tid"));
		Travels travels = travelsService.findByTid(tid);
		req.getSession().setAttribute("nowtravels", travels);
		User user = userService.findByUid(travels.getUid());
        Article article = articleService.getTravelsById(travels.getTid());
        req.getSession().setAttribute("content", article.getContent());
        req.getSession().setAttribute("title", article.getTitle());
        req.getSession().setAttribute("addTime", article.getAddTime());

		// 加载评论
		List<UserDiscuss> userDiscussList = new ArrayList<UserDiscuss>();
		List<Discuss> discussList = discussService.findDiscussByTid(tid);
		for (int i = 0; i < discussList.size(); i++) {
			userDiscussList
					.add(new UserDiscuss(userService.findByUid(discussList.get(
							i).getUid()), discussList.get(i)));
		}
		req.getSession().setAttribute("userDiscussList", userDiscussList);
		Integer userDiscussNum = userDiscussList.size();
		req.setAttribute("userDiscussNum", userDiscussNum);
		if (userDiscussNum % 2 == 0) {
			req.setAttribute("userDiscussPage", userDiscussNum / 2);
		} else {
			req.setAttribute("userDiscussPage", userDiscussNum / 2 + 1);
		}
		if (userDiscussNum == 0) {
			req.setAttribute("nowPage", 0);
		} else {
			req.setAttribute("nowPage", 1);
		}
		int fromindex = 0;
		int toindex = fromindex + 2;
		List<UserDiscuss> userDiscussLists;
		if (toindex >= userDiscussNum) {
			userDiscussLists = userDiscussList.subList(fromindex,
					userDiscussNum);
		} else {
			userDiscussLists = userDiscussList.subList(fromindex, toindex);
		}
		req.setAttribute("userDiscussLists", userDiscussLists);
		return "travelsDetail";
	}

	/**
	 * 添加评论信息
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/insertDiscuss.do")
	public String insertQuestionDiscuss(HttpServletRequest req) throws IOException{
			Integer type=Integer.parseInt(req.getParameter("type"));
			Integer pid=Integer.parseInt(req.getParameter("pid"));
			Integer uid=Integer.parseInt(req.getParameter("uid"));
			String present=new String(req.getParameter("present").getBytes("ISO-8859-1"),"utf-8");
			Date date=new Date(System.currentTimeMillis());
			Integer i=discussService.insertDiscuss(new Discuss(type, pid, uid, date, present));
			return "redirect:../index/travelsDetail.do?tid="+pid;
	}
	
	@RequestMapping("/changeDiscussPage.do")
	//更新评论页面
	public String changDiscussPage(HttpServletRequest req) throws IOException{
		//分页评论
		Integer page=Integer.parseInt(req.getParameter("page"));
		List<UserDiscuss>userDiscussList=(List<UserDiscuss>)req.getSession().getAttribute("userDiscussList");
		Integer userDiscussNum=userDiscussList.size();
		req.setAttribute("userDiscussNum", userDiscussNum);
		if(userDiscussNum%2==0){
			req.setAttribute("userDiscussPage",userDiscussNum/2);
		}else {
			req.setAttribute("userDiscussPage",userDiscussNum/2+1);
		}
		req.setAttribute("nowPage",page);
		int fromindex=(page-1)*2;
		int toindex=fromindex+2;
		List<UserDiscuss>userDiscussLists;
		if(toindex>=userDiscussNum){
			userDiscussLists=userDiscussList.subList(fromindex, userDiscussNum);
		}else {
			userDiscussLists=userDiscussList.subList(fromindex, toindex);
		}
		req.setAttribute("userDiscussLists", userDiscussLists);
		return "travelsDetail";
	}
	
}

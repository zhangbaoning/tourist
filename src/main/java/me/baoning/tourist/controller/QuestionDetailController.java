package me.baoning.tourist.controller;

import me.baoning.tourist.model.Discuss;
import me.baoning.tourist.model.UserDiscuss;
import me.baoning.tourist.service.DiscussService;
import me.baoning.tourist.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * 问题详细页面
 * @author qyn
 *
 */
@Controller
@RequestMapping("/questionDetail")
public class QuestionDetailController {
	//注入DiscussService
	@Resource
	private DiscussService discussService;
	
	//注入NewServiceeiwService
	@Resource
	private QuestionService questionService;
	
	//添加评论信息
	@RequestMapping("/insertDiscuss.do")
	public String insertQuestionDiscuss(HttpServletRequest req) throws IOException{
			Integer type=Integer.parseInt(req.getParameter("type"));
			Integer pid=Integer.parseInt(req.getParameter("pid"));
			Integer uid=Integer.parseInt(req.getParameter("uid"));
			String present=new String(req.getParameter("present").getBytes("ISO-8859-1"),"utf-8");
			Date date=new Date(System.currentTimeMillis());
			Integer i=discussService.insertDiscuss(new Discuss(type, pid, uid, date, present));
			return "redirect:../index/questionDetail.do?qid="+pid;
	}
	
	@RequestMapping("/changeDiscussPage.do")
	//更新景点信息页面
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
		return "questionDetail";
	}
}

package me.baoning.tourist.controller;

import com.tarena.entity.*;
import com.tarena.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 后台首页控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/hindex")
public class HIndexController {
	//注入用户业务层
	@Resource
	private UserService userService;
	
	//注入景点信息业务层
	@Resource
	private VeiwService veiwService;
	
	//注入新闻信息业务层
	@Resource
	private NewService newService;
	
	//注入游记信息业务层
	@Resource
	private TravelsService travelsService;
	
	//注入问答信息业务层
	@Resource
	private QuestionService questionService;
	
	//注入评论信息业务层
	@Resource
	private DiscussService discussService;
	
	//后台跳转到用户管理界面
	@RequestMapping("/userWork.do")
	public String userWork(HttpServletRequest req){
		Integer userNum=userService.countUserNum();
		req.getSession().setAttribute("userNum", userNum);
		if(userNum%7==0){
			req.getSession().setAttribute("userPage",userNum/7);
		}else {
			req.getSession().setAttribute("userPage",userNum/7+1);
		}
		if(userNum==0){
			req.setAttribute("nowPage", 0);
		}else {
			req.setAttribute("nowPage", 1);
		}
		List<User>userList=userService.findAllUser();
		req.getSession().setAttribute("userList", userList);
		int fromindex=0;
		int toindex=fromindex+7;
		List<User>userLists;
		if(toindex>=userNum){
			userLists=userList.subList(fromindex, userNum);
		}else {
			userLists=userList.subList(fromindex, toindex);
		}
		req.setAttribute("userLists", userLists);
		return "designUser";
	}
	
	
	//后台跳转到景点信息管理界面
	@RequestMapping("/veiwWork.do")
	public String viewWork(HttpServletRequest req){
		Integer veiwNum=veiwService.countViewNum();
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
		List<VeiwSpot>veiwList=veiwService.findAllVeiwSpot();
		req.getSession().setAttribute("veiwList", veiwList);
		int fromindex=0;
		int toindex=fromindex+7;
		List<VeiwSpot>veiwLists;
		if(toindex>=veiwNum){
			veiwLists=veiwList.subList(fromindex, veiwNum);
		}else {
			veiwLists=veiwList.subList(fromindex, toindex);
		}
		req.setAttribute("veiwLists", veiwLists);
		return "designVeiw";
	}
	
	//后台跳转到新闻信息管理界面
	@RequestMapping("/newsWork.do")
	public String newWork(HttpServletRequest req){
		Integer newNum=newService.countNewNum();
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
		List<News>newList=newService.findAllNews();
		req.getSession().setAttribute("newList", newList);
		int fromindex=0;
		int toindex=fromindex+7;
		List<News>newLists;
		if(toindex>=newNum){
			newLists=newList.subList(fromindex,newNum);
		}else {
			newLists=newList.subList(fromindex,toindex);
		}
		req.setAttribute("newLists", newLists);
		return "designNews";
	}
	
	//后台跳转到游记管理界面
	@RequestMapping("/travelsWork.do")
	public String travelsWork(HttpServletRequest req){
		Integer travelsNum=travelsService.countTravelsNum();
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
		List<Travels>travelsList=travelsService.findAlltravels();
		req.getSession().setAttribute("travelsList", travelsList);
		int fromindex=0;
		int toindex=fromindex+7;
		List<Travels>travelsLists;
		if(toindex>=travelsNum){
			travelsLists=travelsList.subList(fromindex, travelsNum);
		}else {
			travelsLists=travelsList.subList(fromindex, toindex);
		}
		req.setAttribute("travelsLists", travelsLists);
		return "designTravels";
	}
	
	//后台跳转到问答管理界面
	@RequestMapping("/questionWork.do")
	public String questionWork(HttpServletRequest req){
		Integer questionNum=questionService.countQuestionNum();
		req.getSession().setAttribute("questionNum", questionNum);
		if(questionNum%7==0){
			req.getSession().setAttribute("questionPage",questionNum/7);
		}else {
			req.getSession().setAttribute("questionPage",questionNum/7+1);
		}
		if(questionNum==0){
			req.setAttribute("nowPage", 0);
		}else {
			req.setAttribute("nowPage", 1);
		}
		List<Question>questionList=questionService.findAllQuestion();
		req.getSession().setAttribute("questionList", questionList);
		int fromindex=0;
		int toindex=fromindex+7;
		List<Question>questionLists;
		if(toindex>=questionNum){
			questionLists=questionList.subList(fromindex, questionNum);
		}else {
			questionLists=questionList.subList(fromindex, toindex);
		}
		req.setAttribute("questionLists", questionLists);
		return "designQuestion";
	}
	
	//后台跳转到评论管理界面
	@RequestMapping("/discussWork.do")
	public String discussWork(HttpServletRequest req){
		Integer discussNum=discussService.countdiscussNum();
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
		List<Discuss>discussList=discussService.findAllDiscuss();
		req.getSession().setAttribute("discussList", discussList);
		int fromindex=0;
		int toindex=fromindex+7;
		List<Discuss>discussLists;
		if(toindex>=discussNum){
			discussLists=discussList.subList(fromindex, discussNum);
		}else {
			discussLists=discussList.subList(fromindex, toindex);
		}
		req.setAttribute("discussLists", discussLists);
		return "designDiscuss";
	}
}

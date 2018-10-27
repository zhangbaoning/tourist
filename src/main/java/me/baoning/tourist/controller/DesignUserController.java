
package me.baoning.tourist.controller;

import me.baoning.tourist.model.User;
import me.baoning.tourist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 后台用户管理页面控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/designUser")
public class DesignUserController {
	//注入UserService
	@Resource
	private UserService userService;
	
	@RequestMapping("/changeUserPage.do")
	//上一页下一页操作
	public String changeRoomPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<User> userList=(List<User>) req.getSession().getAttribute("userList");
		Integer userNum=(Integer) req.getSession().getAttribute("userNum");
		int fromindex=(rpage-1)*7;
		int toindex=fromindex+7;
		List<User>userLists;
		if(toindex>=userNum){
			userLists=userList.subList(fromindex, userNum);
		}else {
			userLists=userList.subList(fromindex, toindex);
		}
		req.setAttribute("userLists", userLists);
		req.setAttribute("nowPage", rpage);
		return "designUser";
	}
	
	@RequestMapping("/mfindUser.do")
	//根据关键字模糊查找
	public String mfindUser(HttpServletRequest req){
		String keywords=req.getParameter("keywords");
		List<User> userList=userService.mfindUser(keywords);
		Integer userNum=userList.size();
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
		req.getSession().setAttribute("userList", userList);
		int fromindex=0;
		int toindex=7;
		List<User>userLists;
		if(toindex>=userNum){
			userLists=userList.subList(fromindex, userNum);
		}else {
			userLists=userList.subList(fromindex, toindex);
		}
		req.setAttribute("userLists", userLists);
		return "designUser";
	}
	
	@RequestMapping("/deleteUser.do")
	//根据userid删除该用户
	public String deleteUserById(HttpServletRequest req){
		Integer userid=Integer.parseInt(req.getParameter("userid"));
		Integer i=userService.deleteUserById(userid);
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
		int toindex=7;
		List<User>userLists;
		if(toindex>=userNum){
			userLists=userList.subList(fromindex, userNum);
		}else {
			userLists=userList.subList(fromindex, toindex);
		}
		req.setAttribute("userLists", userLists);
		return "designUser";
	}
}

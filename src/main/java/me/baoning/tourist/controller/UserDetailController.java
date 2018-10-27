package me.baoning.tourist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录用户详细页管理层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/userDetail")
public class UserDetailController {
	//跳转添加游记界面
	@RequestMapping("/addTravels.do")
	private String addTravels(){
		return "addTravels";
	}
	
	//跳转添加问题界面
	@RequestMapping("/addQuestion.do")
	private String addQuestion(){
		return "addQuestion";
	}
	
	//跳转当前用户信息界面
	@RequestMapping("/loadUser.do")
	private String	loadUser(){
		return "nowUser";
	}
}

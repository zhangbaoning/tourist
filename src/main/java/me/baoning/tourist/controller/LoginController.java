package me.baoning.tourist.controller;

import com.tarena.entity.User;
import com.tarena.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 前台登陆界面控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	//注入User业务层
	@Resource
	private UserService userService;
	
	//前台登陆操作控制
	@RequestMapping("/oklogin.do")
	public String loginAction(HttpServletRequest req) throws IOException{
		String email=req.getParameter("demail");
		String userpwd=req.getParameter("duserpwd");
		User user= userService.login(email,userpwd);
		if(user!=null){
			req.getSession().setAttribute("nowuser", user);
			return "redirect:../index/index.do";
		}else {
			req.setAttribute("dmessage", "邮箱或密码错误");
			return "login";
		}
	}
	
	//添加新用户操作
	@RequestMapping("/addUser.do")
	public String insertUserAction(HttpServletRequest req){
		String email=req.getParameter("memail");
		String userpwd=req.getParameter("userpwd");
		String nickname=req.getParameter("nickname");
		Integer i=userService.addUser(email, userpwd, nickname);
		if(i==1){
			req.setAttribute("dmessage2", "恭喜你注册成功，请登录");
			File file=new File(req.getSession().getServletContext().getRealPath("/")+"travels/"+nickname);
			File file1=new File(req.getSession().getServletContext().getRealPath("/")+"user/"+nickname);
			file.mkdir();
			file1.mkdir();
		}
		//return "login";
		return "redirect:../index/login.do";
	}
}

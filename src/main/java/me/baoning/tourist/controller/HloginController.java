package me.baoning.tourist.controller;

import com.tarena.entity.Operator;
import com.tarena.service.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 后台登陆界面控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/hlogin")
public class HloginController{
	
	//注入管理员业务层
	@Resource
	private OperatorService operatorService;
	
	//显示后台登陆界面
	@RequestMapping("/hlogin.do")
	public String hlogin(){
		return "hlogin";
	}
	
	//前台登陆操作控制
	@RequestMapping("/okhlogin.do")
	public String hloginAction(HttpServletRequest req) throws IOException{
		String opname=req.getParameter("opname");
		String oppwd=req.getParameter("oppwd");
		Operator operator = operatorService.login(opname,oppwd);
		if(operator!=null){
			req.getSession().setAttribute("operator", operator);
			return "hindex";
		}else {
			req.setAttribute("message", "用户名或密码错误");
			return "hlogin";
		}
	}
}

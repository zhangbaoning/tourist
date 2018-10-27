package me.baoning.tourist.controller;

import me.baoning.tourist.model.News;
import me.baoning.tourist.model.Travels;
import me.baoning.tourist.model.User;
import me.baoning.tourist.model.ViewSpot;
import me.baoning.tourist.service.NewService;
import me.baoning.tourist.service.TravelsService;
import me.baoning.tourist.service.UserService;
import me.baoning.tourist.service.VeiwService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 判断用户等操作的ajax请求处理类
 * @author qyn
 *
 */
@Controller
@RequestMapping("/check")
public class CheckController {
	
	//注入UserService
	@Resource
	private UserService userService;
	
	//注入veiwService
	@Resource
	private VeiwService veiwService;
	
	//注入NewService
	@Resource
	private NewService newService;
	
	//注入NewService
	@Resource
	private TravelsService travelsService;
	
	//ajax检测是否已有用户使用该邮箱注册
	@RequestMapping("/checkuser.do")
	public void checkuser(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String email=request.getParameter("email");
		User user=userService.findByEmail(email);
		String str="";
		if(user==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已有用户使用该昵称
	@RequestMapping("/checkusernickname.do")
	public void checkusernickname(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String nickname=request.getParameter("nickname");
		User user=userService.findByNickname(nickname);
		String str="";
		if(user==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已有用户使用该昵称
	@RequestMapping("/checkveiw1.do")
	public void checkveiw1(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String vname=request.getParameter("vname");
		ViewSpot veiwSpot=veiwService.findByVname(vname);
		String str="";
		if(veiwSpot==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已有内容路径
	@RequestMapping("/checkveiw2.do")
	public void checkveiw2(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String present=request.getParameter("present");
		ViewSpot veiwSpot=veiwService.findByPresent(present);
		String str="";
		if(veiwSpot==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已有图片路径
	@RequestMapping("/checkveiw3.do")
	public void checkveiw3(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String veiwphoto=request.getParameter("veiwphoto");
		ViewSpot veiwSpot=veiwService.findByVeiwPhoto(veiwphoto);
		String str="";
		if(veiwSpot==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已给新闻标题存在
	@RequestMapping("/checknew1.do")
	public void checknew1(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String ntitle=request.getParameter("ntitle");
		News news=newService.findByNtitle(ntitle);
		String str="";
		if(news==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已给新闻内容路径存在
	@RequestMapping("/checknew2.do")
	public void checknew2(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String present=request.getParameter("present");
		News news=newService.findByNpresent(present);
		String str="";
		if(news==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已给新闻内容路径存在
	@RequestMapping("/checknew3.do")
	public void checknew3(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String newphoto=request.getParameter("newphoto");
		News news=newService.findByNewphoto(newphoto);
		String str="";
		if(news==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已给游记内容路径存在
	@RequestMapping("/checkTravels.do")
	public void checkTravels(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		User nowuser=(User)request.getSession().getAttribute("nowuser");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String present=request.getParameter("present");
		Travels t=new Travels(nowuser.getUserid(), present);
		Travels travels=travelsService.findByTpresent(t);
		String str="";
		if(travels==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
	//ajax检测是否已给游记内容路径存在
	@RequestMapping("/checkTravels1.do")
	public void travelsphoto(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		User nowuser=(User)request.getSession().getAttribute("nowuser");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String travelsphoto=request.getParameter("travelsphoto");
		Travels t=new Travels(travelsphoto, nowuser.getUserid());
		Travels travels=travelsService.findByTravelsphoto(t);
		String str="";
		if(travels==null){
			str="1";
		}else {
			str="2";
		}
		out.print(str);
		out.flush();
		out.close();
	}
}

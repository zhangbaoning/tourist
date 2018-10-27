package me.baoning.tourist.controller;

import me.baoning.tourist.model.User;
import me.baoning.tourist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 修改用户信息
 * @author qyn
 *
 */
@Controller
@RequestMapping("/updateUser")
public class UpdateUserController {
	
	//注入UserService
	@Resource
	private UserService userService;
	
	@RequestMapping("/updateUserOk.do")
	//更改新闻信息详细页面
	public String loadNew(HttpServletRequest req, @RequestParam("file") MultipartFile file) throws IOException{
		req.setCharacterEncoding("utf-8");
		User nowuser=(User)req.getSession().getAttribute("nowuser");
		String nickname=req.getParameter("nickname");
		String userpwd=req.getParameter("userpwd");
		String resume=new String(req.getParameter("resume").getBytes("ISO-8859-1"), "utf-8");
		String sex=new String(req.getParameter("sex").getBytes("ISO-8859-1"), "utf-8");
		String hobby=new String(req.getParameter("hobby").getBytes("ISO-8859-1"), "utf-8");
		String faceimg=file.getOriginalFilename();
		String presentPath=req.getSession().getServletContext().getRealPath("/")+"user/"+nickname+"/"+faceimg;
		File presentFile=new File(presentPath);
		if (!file.isEmpty()&&file.getOriginalFilename()!=null) {  
			 presentFile.delete();
	         byte[] bytes = file.getBytes();  
	         // 文件保存路径  
             String filePath = req.getSession().getServletContext().getRealPath("/") + "user/"+nickname+"/"
                      + file.getOriginalFilename();  
              // 转存文件  
              file.transferTo(new File(filePath));
	     }
		User user=new User(nowuser.getUserid(), nowuser.getEmail(), userpwd, resume, nickname, faceimg, sex, hobby);
		req.getSession().setAttribute("nowuser",user);
		Integer i=userService.updateUser(user);
		return "redirect:../index/userDetail.do";
	}
}

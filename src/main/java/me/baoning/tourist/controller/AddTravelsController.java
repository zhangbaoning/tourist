package me.baoning.tourist.controller;

import me.baoning.tourist.model.User;
import me.baoning.tourist.service.TravelsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * 添加新新闻信息控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/addTravels")
public class AddTravelsController {
	//注入TravelsService
	@Resource
	private TravelsService travelsService;
	
	//添加新景点信息
	@RequestMapping("/addTravels.do")
	public String insertNewsOk(HttpServletRequest req, @RequestParam("file") MultipartFile file1, @RequestParam("file1") MultipartFile file2) throws IOException{
		String title=new String(req.getParameter("title").getBytes("ISO-8859-1"), "utf-8");
		String present=req.getParameter("present");
		String travelsphoto=req.getParameter("travelsphoto");
		User nowuser=(User)req.getSession().getAttribute("nowuser");
		if (!file1.isEmpty()) {
	         byte[] bytes = file1.getBytes();  
	         // 文件保存路径  
              String filePath = req.getSession().getServletContext().getRealPath("/") + "travels/"+nowuser.getNickname()+"/"+travelsphoto
                       + file1.getOriginalFilename();  
               // 转存文件  
               file1.transferTo(new File(filePath));
	     } 
		if (!file2.isEmpty()) {  
	           byte[] bytes = file2.getBytes();  
	           String filePath = req.getSession().getServletContext().getRealPath("/") + "travels/"+nowuser.getNickname()+"/"+travelsphoto
	                    + file2.getOriginalFilename();  
	            file2.transferTo(new File(filePath));  
	     }
		String present1=new String(req.getParameter("present1").getBytes("ISO-8859-1"), "utf-8");
		String filePath = req.getSession().getServletContext().getRealPath("/") + "travels/"+nowuser.getNickname()+"/"+present+".txt";
		FileOutputStream fos=new FileOutputStream(new File(filePath));
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		PrintWriter pw=new PrintWriter(osw);
		pw.write(present1);
		pw.flush();
		pw.close();
		osw.close();
		fos.close();	
		Integer i=travelsService.insertTravels(nowuser.getUserid(), title, present, travelsphoto);
		return "redirect:../index/userDetail.do";
	}
}

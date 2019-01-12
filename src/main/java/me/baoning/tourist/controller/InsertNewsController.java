package me.baoning.tourist.controller;

import me.baoning.tourist.service.NewService;
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
@RequestMapping("/insertNews")
public class InsertNewsController {
	//注入NewService
	@Resource
	private NewService newService;
	
	//添加新景点信息
	@RequestMapping("/insertNewsOk.do")
	public String insertNewsOk(HttpServletRequest req, @RequestParam("file") MultipartFile file1, @RequestParam("file1") MultipartFile file2, @RequestParam("file2") MultipartFile file3) throws IOException{
		String ntitle=new String(req.getParameter("ntitle").getBytes("ISO-8859-1"), "utf-8");
		String quarry=new String(req.getParameter("quarry").getBytes("ISO-8859-1"), "utf-8");
		String present=req.getParameter("present");
		String newphoto=req.getParameter("newphoto");
		if (!file1.isEmpty()) {  
	         byte[] bytes = file1.getBytes();  
	         // 文件保存路径  
              String filePath = req.getSession().getServletContext().getRealPath("/") + "newphoto/"+newphoto  
                       + file1.getOriginalFilename();  
               // 转存文件  
               file1.transferTo(new File(filePath));
	     } 
		if (!file2.isEmpty()) {  
	           byte[] bytes = file2.getBytes();  
	           String filePath = req.getSession().getServletContext().getRealPath("/") + "newphoto/"+newphoto 
	                    + file2.getOriginalFilename();  
	            file2.transferTo(new File(filePath));  
	     }
		if (!file3.isEmpty()) {  
	           byte[] bytes = file3.getBytes();  
	           String filePath = req.getSession().getServletContext().getRealPath("/") + "newphoto/"+newphoto 
	                    + file3.getOriginalFilename();  
	            file3.transferTo(new File(filePath));  
	     } 
		String present1=new String(req.getParameter("present1").getBytes("ISO-8859-1"), "utf-8");
		String summary=present1.trim().substring(0,30);
		summary=summary+"......";
		String filePath = req.getSession().getServletContext().getRealPath("/") + "news/"+present+".txt";
		FileOutputStream fos=new FileOutputStream(new File(filePath));
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		PrintWriter pw=new PrintWriter(osw);
		pw.write(present1);
		pw.flush();
		pw.close();
		osw.close();
		fos.close();	
		Integer i=newService.insertNew(ntitle,System.currentTimeMillis(),summary,present,quarry,newphoto);
		return "redirect:../hindex/newsWork.do";
	}
}

package me.baoning.tourist.controller;


import me.baoning.tourist.service.ViewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * 添加新景点信息控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/insertVeiwSpot")
public class InsertVeiwSpotController {
	
	//注入VeiwService
	@Resource
    private ViewService veiwService;
	
	//添加新景点信息
	@RequestMapping("/insertNewVeiwSpotOk.do")
	public String insertNewVeiwSpot(HttpServletRequest req, @RequestParam("file") MultipartFile file1, @RequestParam("file1") MultipartFile file2) throws IOException{
		String vname=new String(req.getParameter("vname").getBytes("ISO-8859-1"), "utf-8");
		String present=req.getParameter("present");
		String veiwphoto=req.getParameter("veiwphoto");
		if (!file1.isEmpty()) {  
	         byte[] bytes = file1.getBytes();  
	         // 文件保存路径  
              String filePath = req.getSession().getServletContext().getRealPath("/") + "veiwphoto/"+veiwphoto  
                       + file1.getOriginalFilename();  
               // 转存文件  
               file1.transferTo(new File(filePath));
	     } 
		if (!file2.isEmpty()) {  
	           byte[] bytes = file2.getBytes();  
	           // 文件保存路径  
	           String filePath = req.getSession().getServletContext().getRealPath("/") + "veiwphoto/"+veiwphoto
	                    + file2.getOriginalFilename();  
	            // 转存文件  
	            file2.transferTo(new File(filePath));  
	     } 
		String present1=new String(req.getParameter("present1").getBytes("ISO-8859-1"), "utf-8");
		String filePath = req.getSession().getServletContext().getRealPath("/") + "veiwspot/"+present+".txt";
		FileOutputStream fos=new FileOutputStream(new File(filePath));
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		PrintWriter pw=new PrintWriter(osw);
		pw.write(present1);
		pw.flush();
		pw.close();
		osw.close();
		fos.close();
		Integer i=veiwService.insertVeiw(vname,present,veiwphoto);
		return "redirect:../hindex/veiwWork.do";
	}
}

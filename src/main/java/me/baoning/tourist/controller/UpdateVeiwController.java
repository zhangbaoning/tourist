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
 * 更新景点控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/updateVeiw")
public class UpdateVeiwController {
	
	//注入VeiwService
	@Resource
	private ViewService veiwService;
	
	@RequestMapping("/updateVeiw.do")
	//更改景点信息详细页面
	public String loadVeiw(HttpServletRequest req, @RequestParam("file") MultipartFile file1, @RequestParam("file1") MultipartFile file2) throws IOException{
		String present=req.getParameter("present");
		String veiwphoto=req.getParameter("veiwphoto");
		String presentPath=req.getSession().getServletContext().getRealPath("/")+"veiwspot/"+present+".txt";
		File presentFile=new File(presentPath);
		if(presentFile.exists()){
			presentFile.delete();
		}
		String veiwphotoPath1=req.getSession().getServletContext().getRealPath("/")+"veiwphoto/"+veiwphoto+"1.png";
		String veiwphotoPath2=req.getSession().getServletContext().getRealPath("/")+"veiwphoto/"+veiwphoto+"2.png";
		File veiwphotoFile1=new File(veiwphotoPath1);
		File veiwphotoFile2=new File(veiwphotoPath2);
		if (!file1.isEmpty()&&file1.getOriginalFilename()!=null) {  
			 veiwphotoFile1.delete();
	         byte[] bytes = file1.getBytes();  
	         // 文件保存路径  
             String filePath = req.getSession().getServletContext().getRealPath("/") + "veiwphoto/"+veiwphoto  
                      + file1.getOriginalFilename();  
              // 转存文件  
              file1.transferTo(new File(filePath));
	     } 
		if (!file2.isEmpty()&&file2.getOriginalFilename()!=null) {  
				veiwphotoFile2.delete();
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
		return "redirect:../hindex/veiwWork.do";
	}
}

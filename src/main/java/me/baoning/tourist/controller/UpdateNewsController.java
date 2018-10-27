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
 * 更新新闻控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/updateNews")
public class UpdateNewsController {

	//注入NewService
	@Resource
	private NewService newService;
	
	@RequestMapping("/updateNewsOk.do")
	//更改新闻信息详细页面
	public String loadNew(HttpServletRequest req, @RequestParam("file") MultipartFile file1, @RequestParam("file1") MultipartFile file2, @RequestParam("file2") MultipartFile file3) throws IOException{
		Integer nid=Integer.parseInt(req.getParameter("nid"));
		String present=req.getParameter("present");
		String newphoto=req.getParameter("newphoto");
		String presentPath=req.getSession().getServletContext().getRealPath("/")+"news/"+present+".txt";
		File presentFile=new File(presentPath);
		if(presentFile.exists()){
			presentFile.delete();
		}
		String newphotoPath1=req.getSession().getServletContext().getRealPath("/")+"newphoto/"+newphoto+"1.png";
		String newphotoPath2=req.getSession().getServletContext().getRealPath("/")+"newphoto/"+newphoto+"2.png";
		String newphotoPath3=req.getSession().getServletContext().getRealPath("/")+"newphoto/"+newphoto+"3.png";
		File newphotoFile1=new File(newphotoPath1);
		File newphotoFile2=new File(newphotoPath2);
		File newphotoFile3=new File(newphotoPath3);
		if (!file1.isEmpty()&&file1.getOriginalFilename()!=null) {  
			 newphotoFile1.delete();
	         byte[] bytes = file1.getBytes();  
	         // 文件保存路径  
             String filePath = req.getSession().getServletContext().getRealPath("/") + "newphoto/"+newphoto  
                      + file1.getOriginalFilename();  
              // 转存文件  
              file1.transferTo(new File(filePath));
	     } 
		if (!file2.isEmpty()&&file2.getOriginalFilename()!=null) {  
				newphotoFile2.delete();
	           byte[] bytes = file2.getBytes();  
	           // 文件保存路径  
	           String filePath = req.getSession().getServletContext().getRealPath("/") + "newphoto/"+newphoto
	                    + file2.getOriginalFilename();  
	            // 转存文件  
	           file2.transferTo(new File(filePath));  
	     } 
		if (!file3.isEmpty()&&file3.getOriginalFilename()!=null) {  
			newphotoFile3.delete();
           byte[] bytes = file3.getBytes();  
           // 文件保存路径  
           String filePath = req.getSession().getServletContext().getRealPath("/") + "newphoto/"+newphoto
                    + file3.getOriginalFilename();  
            // 转存文件  
           file3.transferTo(new File(filePath));  
     } 
		String present1=new String(req.getParameter("present1").getBytes("ISO-8859-1"), "utf-8");
		String filePath = req.getSession().getServletContext().getRealPath("/") + "news/"+present+".txt";
		FileOutputStream fos=new FileOutputStream(new File(filePath));
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		PrintWriter pw=new PrintWriter(osw);
		pw.write(present1);
		String summary=present1.trim().substring(0,30);
		summary=summary+"......";
		Integer i=newService.updateSummary(nid,summary);
		pw.flush();
		pw.close();
		osw.close();
		fos.close();
		return "redirect:../hindex/newsWork.do";
	}
}

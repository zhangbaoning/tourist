package me.baoning.tourist.controller;

import me.baoning.tourist.service.TravelsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 审核游记控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/auditing")
public class AuditingController {
	
	//注入TravelsService
	@Resource
	private TravelsService travelsService;
	
	@RequestMapping("/auditing.do")
	//审核通过
	public String auditing(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("utf-8");
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		Integer i=travelsService.auditing(tid);
		return "redirect:../hindex/travelsWork.do";
	}
}

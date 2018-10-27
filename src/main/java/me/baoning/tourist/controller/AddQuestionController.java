package me.baoning.tourist.controller;

import me.baoning.tourist.model.User;
import me.baoning.tourist.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

//import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 添加新问题信息控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/addQuestion")
public class AddQuestionController {
	//注入QuestionService
	@Resource
	private QuestionService questionService;
	
	//添加新景点信息
	@RequestMapping("/addQuestion.do")
	public String addQuestion(HttpServletRequest req) throws IOException{
		String title=new String(req.getParameter("qtitle").getBytes("ISO-8859-1"), "utf-8");
		String present=new String(req.getParameter("qpresent").getBytes("ISO-8859-1"), "utf-8");
		User nowuser=(User)req.getSession().getAttribute("nowuser");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date qtime=new Date(System.currentTimeMillis());
		Integer i=questionService.insertQusetion(nowuser.getUserid(),qtime,present,"未解决",title);
		return "redirect:../index/userDetail.do";
	}
}

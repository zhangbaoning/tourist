package me.baoning.tourist.controller;

import me.baoning.tourist.model.Question;
import me.baoning.tourist.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 后台新闻管理页面控制层
 * @author qyn
 * 
 */
@Controller
@RequestMapping("/designQuestion")
public class DesignQuestionController {
	
	//注入NewService
	@Resource
	private QuestionService questionService;
	
	@RequestMapping("/changeQuestionPage.do")
	//上一页下一页操作
	public String changeQuestionPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<Question> questionList=(List<Question>) req.getSession().getAttribute("questionList");
		Integer questionNum=(Integer) req.getSession().getAttribute("questionNum");
		if(questionNum%7==0){
			req.getSession().setAttribute("questionPage",questionNum/7);
		}else {
			req.getSession().setAttribute("questionPage",questionNum/7+1);
		}
		int fromindex=(rpage-1)*7;
		int toindex=fromindex+7;
		List<Question>questionLists;
		if(toindex>=questionNum){
			questionLists=questionList.subList(fromindex, questionNum);
		}else {
			questionLists=questionList.subList(fromindex, toindex);
		}
		req.setAttribute("questionLists", questionLists);
		req.setAttribute("nowPage", rpage);
		return "designQuestion";
	}
	
	@RequestMapping("/mfindQuestion.do")
	//根据关键字模糊查找
	public String mfindQuestion(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		String keywords=req.getParameter("keywords");
		List<Question> questionList=questionService.mfindQuestion(keywords);
		System.out.println(questionList);
		Integer questionNum=questionList.size();
		req.getSession().setAttribute("questionNum",questionNum);
		if(questionNum%7==0){
			req.getSession().setAttribute("questionPage",questionNum/7);
		}else {
			req.getSession().setAttribute("questionPage",questionNum/7+1);
		}
		if(questionNum==0){
			req.setAttribute("nowPage", 0);
		}else {
			req.setAttribute("nowPage", 1);
		}
		req.getSession().setAttribute("questionList", questionList);
		int fromindex=0;
		int toindex=7;
		List<Question>questionLists;
		if(toindex>=questionNum){
			questionLists=questionList.subList(fromindex, questionNum);
		}else {
			questionLists=questionList.subList(fromindex, toindex);
		}
		req.setAttribute("questionLists", questionLists);
		return "designQuestion"; 
	}
	
	@RequestMapping("/deleteQuestion.do")
	//根据qid问题信息
	public String deleteQuestionByQid(HttpServletRequest req){
		Integer qid=Integer.parseInt(req.getParameter("qid"));
		Integer i=questionService.deleteQuestionByQid(qid);
		return "redirect:../hindex/questionWork.do";
	}
}

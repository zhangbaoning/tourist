package me.baoning.tourist.controller;

import com.tarena.entity.UserQuestion;
import me.baoning.tourist.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 所有问答模块控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/allQuestion")
public class AllQuestionController {
	
	//注入QuestionService
	@Resource
	private QuestionService questionService;
	
	@RequestMapping("/changeQuestionPage.do")
	//上一页下一页操作
	public String changeRoomPage(HttpServletRequest req){
		Integer rpage=Integer.parseInt(req.getParameter("page"));
		List<UserQuestion> userQuestionList=(List<UserQuestion>) req.getSession().getAttribute("userQuestionList");
		Integer userQuestionNum=(Integer) req.getSession().getAttribute("userQuestionNum");
		if(userQuestionNum%6==0){
			req.getSession().setAttribute("userQuestionPage",userQuestionNum/6);
		}else {
			req.getSession().setAttribute("userQuestionPage",userQuestionNum/6+1);
		}
		int fromindex=(rpage-1)*6;
		int toindex=fromindex+6;
		List<UserQuestion>userQuestionLists;
		if(toindex>=userQuestionNum){
			userQuestionLists=userQuestionList.subList(fromindex, userQuestionNum);
		}else {
			userQuestionLists=userQuestionList.subList(fromindex, toindex);
		}
		req.setAttribute("userQuestionLists", userQuestionLists);
		req.setAttribute("nowPage", rpage);
		return "allQuestion";
	}
}

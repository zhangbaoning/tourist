package me.baoning.tourist.controller;

import me.baoning.tourist.model.Article;
import me.baoning.tourist.model.Discuss;
import me.baoning.tourist.model.UserDiscuss;
import me.baoning.tourist.model.ViewSpot;
import me.baoning.tourist.service.ArticleService;
import me.baoning.tourist.service.DiscussService;
import me.baoning.tourist.service.UserService;
import me.baoning.tourist.service.ViewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 前台添加评论控制层
 * @author qyn
 *
 */
@Controller
@RequestMapping("/veiwDetail")
public class VeiwDetailController {

	/**
	 * 注入DiscussService
	 */
	@Resource
	private DiscussService discussService;

	/**
	 * 注入VeiwService
	 */
	@Resource
	private ViewService veiwService;
	@Resource
	private UserService userService;
	@Resource
	private ArticleService articleService;
	/**
	 * 前台跳转景点信息页面
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/veiwDetail.do")
	public String veiwDetail(HttpServletRequest req) throws IOException {
		req.setCharacterEncoding("utf-8");
		Integer vid = Integer.parseInt(req.getParameter("vid"));
		ViewSpot veiwSpot = veiwService.findVeiwByVid(vid);
		req.getSession().setAttribute("nowveiw", veiwSpot);
		/*req.getSession().setAttribute("veiwphoto2",
				"../veiwphoto/" + veiwSpot.getVeiwphoto() + "2.png");
		String presentFlie =
				"static/veiwspot/" + veiwSpot.getPresent() + ".txt";
		File presentFile = new File(MyFileUtils.getClassPath(), presentFlie);
		StringBuffer present1 = new StringBuffer();
		if (presentFile.exists()) {
			present1.append(FileUtils.readFileToString(presentFile));

		}
		req.getSession().setAttribute("present1", present1);*/
		Article article = articleService.getViewById(vid);
		req.getSession().setAttribute("content", article.getContent());
		req.getSession().setAttribute("title", article.getTitle());
		req.getSession().setAttribute("addTime", article.getAddTime());
		// 加载评论
		List<UserDiscuss> userDiscussList = new ArrayList<UserDiscuss>();
		List<Discuss> discussList = discussService.findDiscussByVid(vid);
		for (int i = 0; i < discussList.size(); i++) {
			userDiscussList
					.add(new UserDiscuss(userService.findByUid(discussList.get(
							i).getUid()), discussList.get(i)));
		}
		req.getSession().setAttribute("userDiscussList", userDiscussList);
		Integer userDiscussNum = userDiscussList.size();
		req.setAttribute("userDiscussNum", userDiscussNum);
		if (userDiscussNum % 2 == 0) {
			req.setAttribute("userDiscussPage", userDiscussNum / 2);
		} else {
			req.setAttribute("userDiscussPage", userDiscussNum / 2 + 1);
		}
		if (userDiscussNum == 0) {
			req.setAttribute("nowPage", 0);
		} else {
			req.setAttribute("nowPage", 1);
		}
		int fromindex = 0;
		int toindex = fromindex + 2;
		List<UserDiscuss> userDiscussLists;
		if (toindex >= userDiscussNum) {
			userDiscussLists = userDiscussList.subList(fromindex,
					userDiscussNum);
		} else {
			userDiscussLists = userDiscussList.subList(fromindex, toindex);
		}
		req.setAttribute("userDiscussLists", userDiscussLists);
		return "veiwDetail";
	}
	/**
	 * 添加评论信息
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/insertDiscuss.do")
	public String insertVeiw(HttpServletRequest req) throws IOException{
			Integer type=Integer.parseInt(req.getParameter("type"));
			Integer pid=Integer.parseInt(req.getParameter("pid"));
			Integer uid=Integer.parseInt(req.getParameter("uid"));
		String present = new String(req.getParameter("present").getBytes("utf-8"));
			System.out.println(present);
			Date date=new Date(System.currentTimeMillis());
			Integer i=discussService.insertDiscuss(new Discuss(type, pid, uid, date, present));
			return "redirect:../index/veiwDetail.do?vid="+pid;
	}

	/**
	 * 更新景点信息页面
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/changeDiscussPage.do")
	public String changDiscussPage(HttpServletRequest req) throws IOException{
		//分页评论
		Integer page=Integer.parseInt(req.getParameter("page"));
		System.out.println(page);
		List<UserDiscuss>userDiscussList=(List<UserDiscuss>)req.getSession().getAttribute("userDiscussList");
		Integer userDiscussNum=userDiscussList.size();
		req.setAttribute("userDiscussNum", userDiscussNum);
		if(userDiscussNum%2==0){
			req.setAttribute("userDiscussPage",userDiscussNum/2);
		}else {
			req.setAttribute("userDiscussPage",userDiscussNum/2+1);
		}
		req.setAttribute("nowPage",page);
		int fromindex=(page-1)*2;
		int toindex=fromindex+2;
		List<UserDiscuss>userDiscussLists;
		if(toindex>=userDiscussNum){
			userDiscussLists=userDiscussList.subList(fromindex, userDiscussNum);
		}else {
			userDiscussLists=userDiscussList.subList(fromindex, toindex);
		}
		req.setAttribute("userDiscussLists", userDiscussLists);
		return "veiwDetail";
	}
}

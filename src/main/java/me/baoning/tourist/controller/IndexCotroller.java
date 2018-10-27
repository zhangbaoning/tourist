package me.baoning.tourist.controller;


import me.baoning.tourist.model.*;
import me.baoning.tourist.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/**
 * 前端首页控制层
 * @author qyn
 * 
 */

@Controller
@RequestMapping("/index")
public class IndexCotroller {

	@Resource
	private ViewService veiwService;

	@Resource
	private NewService newService;

	@Resource
	private TravelsService travelsService;

	@Resource
	private QuestionService questionService;

	@Resource
	private UserService userService;

	@Resource
	private DiscussService discussService;


	/**
	 * 跳转首页,随机读取4个景点信息并显示
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/index.do")
	private String index(HttpServletRequest req) throws IOException {
		// 随机读取4个景点信息并显示
		List<ViewSpot> viewSpotList = veiwService.findAllViewSpot();
		req.getSession().setAttribute("veiwList", viewSpotList);
		// 随机选取的四个景点
		List<ViewSpot> randomViewList = new ArrayList<ViewSpot>(4);
		// 生成四个不同的随机数，可以通过set保证不重复
		Set<Integer> treeSet = new TreeSet();
		do {
			treeSet.add(new Random().nextInt(viewSpotList.size()));
		}while (treeSet.size() < 4);

		for (int index : treeSet) {
			randomViewList.add(viewSpotList.get(index));
		}
		req.setAttribute("veiwLists", randomViewList);

		// 根据时间读取最近一天的4条新闻，如今天不满四条，则从上一天取
		List<News> newLists = newService.findByStimeFour();
		req.setAttribute("newLists", newLists);

		// 挑选10条未解决的问题在待回答问题中显示
		List<UserQuestion> userQuestionList = new ArrayList<UserQuestion>();
		List<Question> unsolvedList = questionService.findQuestionByState();
		if (unsolvedList.size()>10){
			unsolvedList.subList(0,10);
		}
		for (Question question : unsolvedList) {
			User user = userService.findByUid(question.getUid());
			UserQuestion userQuestion = new UserQuestion(user,question);
			userQuestionList.add(userQuestion);
		}
		req.getSession().setAttribute("userquestionList", userQuestionList);
		
		//加载最热门游记	
		List<Travels> travelsList = travelsService.findAlltravels();
		List<TravelsMore> travelsMoreList = new ArrayList<>();

		Integer travelsNum = travelsList.size();
		// 游记的篇数
		req.getSession().setAttribute("travelsNum", travelsNum);
		// 一共多少页
		if (travelsNum % 3 == 0) {
			req.getSession().setAttribute("travelsPage", travelsNum / 3);
		} else {
			req.getSession().setAttribute("travelsPage", travelsNum / 3 + 1);
		}
		if (travelsNum == 0) {
			req.setAttribute("nowPage", 0);
		} else {
			req.setAttribute("nowPage", 1);
		}
		for (int a= 0; a < travelsList.size(); a++) {
			User user = userService.findByUid(travelsList.get(a).getUid());
			Integer discussNum=discussService.findDiscussByTid(travelsList.get(a).getTid()).size();
			String presentFlie = req.getSession().getServletContext()
					.getRealPath("/")
					+ "travels/"
					+ user.getNickname()
					+ "/"
					+ travelsList.get(a).getPresent() + ".txt";
			File presentFile = new File(presentFlie);
			StringBuffer tpresent = new StringBuffer();
			if (presentFile.exists()) {
				FileInputStream fis = new FileInputStream(presentFile);
				InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String read = "";
				while ((read = br.readLine()) != null) {
					tpresent.append("\n" + read);
				}
			}
			String present1=tpresent.substring(0, 100)+".........";
			travelsMoreList.add(new TravelsMore(user, travelsList.get(a),
					present1, discussNum));
		}
		Collections.sort(travelsMoreList);
		int fromindex=0;
		int toindex = fromindex + 3;
		List<TravelsMore> travelsMoreLists = new ArrayList<TravelsMore>();
		if (toindex >= travelsNum) {
			travelsMoreLists = travelsMoreList.subList(fromindex, travelsNum);
		} else {
			travelsMoreLists = travelsMoreList.subList(fromindex, toindex);
		}
		req.setAttribute("travelsMoreLists", travelsMoreLists);
		return "index";
	}

	// 跳转登陆界面
	@RequestMapping("/login.do")
	private String login() {
		return "login";
	}
	// 跳转登陆界面
	@RequestMapping("/register.do")
	private String register() {
		return "register";
	}

	@RequestMapping("/veiwDetail.do")
	// 前台跳转景点信息页面
	public String veiwDetail(HttpServletRequest req) throws IOException {
		req.setCharacterEncoding("utf-8");
		Integer vid = Integer.parseInt(req.getParameter("vid"));
		ViewSpot veiwSpot = veiwService.findVeiwByVid(vid);
		req.getSession().setAttribute("nowveiw", veiwSpot);
		req.getSession().setAttribute("veiwphoto2",
				"../veiwphoto/" + veiwSpot.getVeiwphoto() + "2.png");
		String presentFlie = req.getSession().getServletContext().getRealPath(
				"/")
				+ "veiwspot/" + veiwSpot.getPresent() + ".txt";
		File presentFile = new File(presentFlie);
		StringBuffer present1 = new StringBuffer();
		if (presentFile.exists()) {
			FileInputStream fis = new FileInputStream(presentFile);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String read = "";
			while ((read = br.readLine()) != null) {
				present1.append("\n" + read);
			}
		}
		req.getSession().setAttribute("present1", present1);
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

	@RequestMapping("/newsDetail.do")
	// 前台跳转新闻详情页面
	public String newsDetail(HttpServletRequest req) throws IOException {
		req.setCharacterEncoding("utf-8");
		Integer nid = Integer.parseInt(req.getParameter("nid"));
		News news = newService.findByNid(nid);
		req.getSession().setAttribute("nownews", news);
		req.getSession().setAttribute("newphoto1",
				"../newphoto/" + news.getNewphoto() + "1.png");
		String presentFlie = req.getSession().getServletContext().getRealPath(
				"/")
				+ "news/" + news.getPresent() + ".txt";
		File presentFile = new File(presentFlie);
		StringBuffer present1 = new StringBuffer();
		if (presentFile.exists()) {
			FileInputStream fis = new FileInputStream(presentFile);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String read = "";
			while ((read = br.readLine()) != null) {
				present1.append("\n" + read);
			}
		}
		req.getSession().setAttribute("present1", present1);
		// 加载评论
		List<UserDiscuss> userDiscussList = new ArrayList<UserDiscuss>();
		List<Discuss> discussList = discussService.findDiscussByNid(nid);
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
		return "newsDetail";
	}

	// 前台跳转所有新闻页面
	@RequestMapping("/allNews.do")
	public String allNews(HttpServletRequest req) {
		Integer newNum = newService.countNewNum();
		req.getSession().setAttribute("newNum", newNum);
		if (newNum % 7 == 0) {
			req.getSession().setAttribute("newPage", newNum / 7);
		} else {
			req.getSession().setAttribute("newPage", newNum / 7 + 1);
		}
		if (newNum == 0) {
			req.setAttribute("nowPage", 0);
		} else {
			req.setAttribute("nowPage", 1);
		}
		List<News> newList = newService.findAllNewsByStime();
		req.getSession().setAttribute("newList", newList);
		int fromindex = 0;
		int toindex = fromindex + 7;
		List<News> newLists;
		if (toindex >= newNum) {
			newLists = newList.subList(fromindex, newNum);
		} else {
			newLists = newList.subList(fromindex, toindex);
		}
		req.setAttribute("newLists", newLists);
		return "allNews";
	}

	// 前台跳转所有景点信息页面
	@RequestMapping("/allVeiw.do")
	public String allVeiw(HttpServletRequest req) {
		Integer veiwNum = veiwService.countViewNum();
		req.getSession().setAttribute("veiwNum", veiwNum);
		if (veiwNum % 6 == 0) {
			req.getSession().setAttribute("veiwPage", veiwNum / 6);
		} else {
			req.getSession().setAttribute("veiwPage", veiwNum / 6 + 1);
		}
		if (veiwNum == 0) {
			req.setAttribute("nowPage", 0);
		} else {
			req.setAttribute("nowPage", 1);
		}
		List<ViewSpot> veiwList = veiwService.findAllViewSpot();
		req.getSession().setAttribute("veiwList", veiwList);
		int fromindex = 0;
		int toindex = fromindex + 6;
		List<ViewSpot> veiwLists;
		if (toindex >= veiwNum) {
			veiwLists = veiwList.subList(fromindex, veiwNum);
		} else {
			veiwLists = veiwList.subList(fromindex, toindex);
		}
		req.setAttribute("veiwLists", veiwLists);
		return "allVeiw";
	}

	// 跳转用户具体界面
	@RequestMapping("/userDetail.do")
	public String userDetail(HttpServletRequest req) throws IOException {
		User user = (User) req.getSession().getAttribute("nowuser");
		List<Travels> travelsList = travelsService.findAllTravelsById(user
				.getUserid());
		List<TravelsMore> travelsMoreList=new ArrayList<TravelsMore>();
		Integer travelsNum = travelsList.size();
		req.getSession().setAttribute("travelsNum", travelsNum);
		if (travelsNum % 7 == 0) {
			req.getSession().setAttribute("travelsPage", travelsNum / 7);
		} else {
			req.getSession().setAttribute("travelsPage", travelsNum / 7 + 1);
		}
		if (travelsNum == 0) {
			req.setAttribute("nowPage", 0);
		} else {
			req.setAttribute("nowPage", 1);
		}
		for (int a= 0; a < travelsList.size(); a++) {
			Integer discussNum=discussService.findDiscussByTid(travelsList.get(a).getTid()).size();
			String presentFlie = req.getSession().getServletContext()
					.getRealPath("/")
					+ "travels/"
					+ user.getNickname()
					+ "/"
					+ travelsList.get(a).getPresent() + ".txt";
			File presentFile = new File(presentFlie);
			StringBuffer tpresent = new StringBuffer();
			if (presentFile.exists()) {
				FileInputStream fis = new FileInputStream(presentFile);
				InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String read = "";
				while ((read = br.readLine()) != null) {
					tpresent.append("\n" + read);
				}
			}
			String present1=tpresent.substring(0, 100)+".........";
			travelsMoreList.add(new TravelsMore(user, travelsList.get(a),
					present1, discussNum));
		}
		int fromindex = 0;
		int toindex = fromindex + 7;
		List<TravelsMore> travelsMoreLists;
		if (toindex >= travelsNum) {
			travelsMoreLists = travelsMoreList.subList(fromindex, travelsNum);
		} else {
			travelsMoreLists = travelsMoreList.subList(fromindex, toindex);
		}
		req.setAttribute("travelsMoreLists", travelsMoreLists);
		return "userDetail";
	}

	// 前台跳转所有游记界面
	@RequestMapping("/allTravels.do")
	public String allTravels(HttpServletRequest req) throws IOException {
		List<Travels> travelsList = travelsService.findAlltravels();
		List<TravelsMore> travelsMoreList = new ArrayList<TravelsMore>();
		Integer travelsNum = travelsList.size();
		req.getSession().setAttribute("travelsNum", travelsNum);
		if (travelsNum % 3 == 0) {
			req.getSession().setAttribute("travelsPage", travelsNum / 3);
		} else {
			req.getSession().setAttribute("travelsPage", travelsNum / 3 + 1);
		}
		if (travelsNum == 0) {
			req.setAttribute("nowPage", 0);
		} else {
			req.setAttribute("nowPage", 1);
		}
		for (int i = 0; i < travelsList.size(); i++) {
			User user = userService.findByUid(travelsList.get(i).getUid());
			Integer discussNum=discussService.findDiscussByTid(travelsList.get(i).getTid()).size();
			String presentFlie = req.getSession().getServletContext()
					.getRealPath("/")
					+ "travels/"
					+ user.getNickname()
					+ "/"
					+ travelsList.get(i).getPresent() + ".txt";
			File presentFile = new File(presentFlie);
			StringBuffer tpresent = new StringBuffer();
			if (presentFile.exists()) {
				FileInputStream fis = new FileInputStream(presentFile);
				InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String read = "";
				while ((read = br.readLine()) != null) {
					tpresent.append("\n" + read);
				}
			}
			String present1=tpresent.substring(0, 100)+".........";
			travelsMoreList.add(new TravelsMore(user, travelsList.get(i),
					present1, discussNum));
		}
		req.getSession().setAttribute("travelsMoreList", travelsMoreList);
		int fromindex = 0;
		int toindex = fromindex + 3;
		List<TravelsMore> travelsMoreLists = new ArrayList<TravelsMore>();
		if (toindex >= travelsNum) {
			travelsMoreLists = travelsMoreList.subList(fromindex, travelsNum);
		} else {
			travelsMoreLists = travelsMoreList.subList(fromindex, toindex);
		}
		req.setAttribute("travelsMoreLists", travelsMoreLists);
		return "allTravels";
	}

	@RequestMapping("/questionDetail.do")
	// 前台跳转新闻详情页面
	public String questionDetail(HttpServletRequest req) throws IOException {
		req.setCharacterEncoding("utf-8");
		Integer qid = Integer.parseInt(req.getParameter("qid"));
		Question question = questionService.findByQid(qid);
		// System.out.println(question);
		req.getSession().setAttribute("nowquestion", question);
		// 加载评论
		List<UserDiscuss> userDiscussList = new ArrayList<UserDiscuss>();
		List<Discuss> discussList = discussService.findDiscussByQid(qid);
		for (int i = 0; i < discussList.size(); i++) {
			userDiscussList
					.add(new UserDiscuss(userService.findByUid(discussList.get(
							i).getUid()), discussList.get(i)));
		}
		// System.out.println(userDiscussList);
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
		return "questionDetail";
	}

	// 前台跳转所有新闻页面
	@RequestMapping("/allQuestion.do")
	public String allQuestion(HttpServletRequest req) {
		Integer questionNum = questionService.countQuestionNum();
		req.getSession().setAttribute("questionNum", questionNum);
		if (questionNum % 7 == 0) {
			req.getSession().setAttribute("questionPage", questionNum / 7);
		} else {
			req.getSession().setAttribute("questionPage", questionNum / 7 + 1);
		}
		if (questionNum == 0) {
			req.setAttribute("nowPage", 0);
		} else {
			req.setAttribute("nowPage", 1);
		}
		List<Question> questionList = questionService.findAllQuestion();
		List<UserQuestion> userQuestionList = new ArrayList<UserQuestion>();
		for (int i = 0; i < questionList.size(); i++) {
			userQuestionList.add(new UserQuestion(userService
					.findByUid(questionList.get(i).getUid()), questionList
					.get(i)));
		}
		req.getSession().setAttribute("userQuestionList", userQuestionList);
		int fromindex = 0;
		int toindex = fromindex + 7;
		List<UserQuestion> userQuestionLists;
		if (toindex >= questionNum) {
			userQuestionLists = userQuestionList
					.subList(fromindex, questionNum);
		} else {
			userQuestionLists = userQuestionList.subList(fromindex, toindex);
		}
		req.setAttribute("userQuestionLists", userQuestionLists);
		return "allQuestion";
	}

	@RequestMapping("/travelsDetail.do")
	// 前台跳转景点信息页面
	public String travelsDetail(HttpServletRequest req) throws IOException {
		req.setCharacterEncoding("utf-8");
		Integer tid = Integer.parseInt(req.getParameter("tid"));
		Travels travels = travelsService.findByTid(tid);
		req.getSession().setAttribute("nowtravels", travels);
		User user = userService.findByUid(travels.getUid());
		req.getSession().setAttribute(
				"travelsphoto",
				"../travels/" + user.getNickname() + "/"
						+ travels.getTravelsphoto() + "1.png");
		String presentFlie = req.getSession().getServletContext().getRealPath(
				"/")
				+ "travels/"
				+ user.getNickname()
				+ "/"
				+ travels.getPresent()
				+ ".txt";
		File presentFile = new File(presentFlie);
		StringBuffer present1 = new StringBuffer();
		if (presentFile.exists()) {
			FileInputStream fis = new FileInputStream(presentFile);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String read = "";
			while ((read = br.readLine()) != null) {
				present1.append("\n" + read);
			}
		}
		req.getSession().setAttribute("present1", present1);
		// 加载评论
		List<UserDiscuss> userDiscussList = new ArrayList<UserDiscuss>();
		List<Discuss> discussList = discussService.findDiscussByTid(tid);
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
		return "travelsDetail";
	}
}

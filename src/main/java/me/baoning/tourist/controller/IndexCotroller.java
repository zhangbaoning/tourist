package me.baoning.tourist.controller;


import me.baoning.tourist.model.*;
import me.baoning.tourist.service.*;
import me.baoning.tourist.utils.MyFileUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author: zhangbaoning
 * @date: 2019/2/14
 * @since: JDK 1.8
 * @description: 前端首页控制层
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
    @Resource
    private ArticleService articleService;

    /**
     * 跳转首页,随机读取4个景点信息并显示
     *
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
        Set<Integer> treeSet = new TreeSet<>();
        do {
            treeSet.add(new Random().nextInt(viewSpotList.size()));
        } while (treeSet.size() < 4);

        for (int index : treeSet) {
            randomViewList.add(viewSpotList.get(index));
        }
        req.setAttribute("veiwLists", randomViewList);

        // 根据时间读取最近一天的4条新闻，如今天不满四条，则从上一天取
        List<News> newLists = newService.findByStimeFour();
        for (int i = 0; i < newLists.size(); i++) {
            News news = newLists.get(i);
            String summary = news.getSummary();
            news.setSummary(summary.substring(0, 10) + "……");
        }
        req.setAttribute("newLists", newLists);

        // 挑选10条未解决的问题在待回答问题中显示
        List<UserQuestion> userQuestionList = new ArrayList<UserQuestion>();
        List<Question> unsolvedList = questionService.findQuestionByState();
        if (unsolvedList.size() > 10) {
            unsolvedList.subList(0, 10);
        }
        for (Question question : unsolvedList) {
            User user = userService.findByUid(question.getUid());
            UserQuestion userQuestion = new UserQuestion(user, question);
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
        for (int a = 0; a < travelsList.size(); a++) {
            User user = userService.findByUid(travelsList.get(a).getUid());
            Integer discussNum = discussService.findDiscussByTid(travelsList.get(a).getTid()).size();
            String path = new File(MyFileUtils.getClassPath(), "static\\"
                    + "travels/"
                    + user.getNickname()
                    + "/"
                    + travelsList.get(a).getPresent() + ".txt").getPath();
            File presentFile = new File(path);
            StringBuffer tpresent = new StringBuffer();
            if (presentFile.exists()) {
                tpresent.append(FileUtils.readFileToString(presentFile));
            }
            String present1 = tpresent.substring(0, 100) + ".........";
            travelsMoreList.add(new TravelsMore(user, travelsList.get(a),
                    present1, discussNum));
        }
        Collections.sort(travelsMoreList);
        int fromindex = 0;
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



    /**
     * 前台跳转新闻详情页面
     *
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping("/newsDetail.do")
    public String newsDetail(HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("utf-8");
        Integer nid = Integer.parseInt(req.getParameter("nid"));
        News news = newService.findByNid(nid);

        Article article = articleService.getNewsByUser(nid);
        req.getSession().setAttribute("content", article.getContent());
        req.getSession().setAttribute("title", article.getTitle());
        req.getSession().setAttribute("addTime", article.getAddTime());
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

    /**
     * 前台跳转所有新闻页面
     *
     * @param req
     * @return
     */
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

    /**
     * 前台跳转所有景点信息页面
     *
     * @param req
     * @return
     */
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

    /**
     * 跳转用户具体界面
     *
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping("/userDetail.do")
    public String userDetail(HttpServletRequest req) throws IOException {
        User user = (User) req.getSession().getAttribute("nowuser");
        List<Travels> travelsList = travelsService.findAllTravelsById(user
                .getUserid());
        List<TravelsMore> travelsMoreList = new ArrayList<TravelsMore>();
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
        for (int a = 0; a < travelsList.size(); a++) {
            Integer discussNum = discussService.findDiscussByTid(travelsList.get(a).getTid()).size();
            String presentFlie = req.getSession().getServletContext()
                    .getRealPath("/")
                    + "travels/"
                    + user.getNickname()
                    + "/"
                    + travelsList.get(a).getPresent() + ".txt";
            File presentFile = new File(presentFlie);
            StringBuffer tpresent = new StringBuffer();
            if (presentFile.exists()) {
                tpresent.append(FileUtils.readFileToString(presentFile));
            }
            String present1 = tpresent.substring(0, 100) + ".........";
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

    /**
     * 前台跳转所有游记界面
     *
     * @param req
     * @return
     * @throws IOException
     */
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
            Integer discussNum = discussService.findDiscussByTid(travelsList.get(i).getTid()).size();
            File presentFile = new File(MyFileUtils.getClassPath(), "static/"
                    + "travels/"
                    + user.getNickname()
                    + "/"
                    + travelsList.get(i).getPresent() + ".txt");
            StringBuffer tpresent = new StringBuffer();
            if (presentFile.exists()) {
                tpresent.append(FileUtils.readFileToString(presentFile));
            }
            if (StringUtils.isNoneBlank(tpresent)) {
                String present1 = tpresent.substring(0, 100) + ".........";
                travelsMoreList.add(new TravelsMore(user, travelsList.get(i),
                        present1, discussNum));
            }

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

    /**
     * 前台跳转新闻详情页面
     *
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping("/questionDetail.do")
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

    /**
     * 前台跳转所有新闻页面
     *
     * @param req
     * @return
     */
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


}

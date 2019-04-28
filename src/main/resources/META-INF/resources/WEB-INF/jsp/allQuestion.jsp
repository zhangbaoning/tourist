<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta>
    <title>allQuestion</title>

    <link rel="stylesheet" href="../css/reset.css" type="text/css"
          media="screen"/>

    <!--[if ! lte IE 6]><!-->
    <link rel="stylesheet" href="../css/style.css" type="text/css"
          media="screen"/>
    <!--<![endif]-->

    <!--[if gt IE 6]>
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>
    <![endif]-->

    <!--[if IE 7]>
    <link rel="stylesheet" href="css/ie7.css" type="text/css" media="screen"/>
    <![endif]-->

    <!--[if lte IE 6]>
    <link rel="stylesheet" href="http://universal-ie6-css.googlecode.com/files/ie6.1.1.css" media="screen, projection">
    <![endif]-->

    <link rel="stylesheet" href="../css/fancybox.css" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.min.css" type="text/css"
          media="screen"/>
</head>
<body>
<div>
    <%@include file="nav.jsp"%>

</div>

</div>

<div id="nav-shadow"></div>

<div id="content">

    <div class="container">

        <div id="main">
            <h1>
                问题信息：
            </h1>
            <div data-am-widget="list_news" class="am-list-news am-list-news-default">
                <div class="am-list-news-bd">
                    <ul class="am-list">
                        <c:forEach var="userQuestion" items="${userQuestionLists}">


                            <li class="am-g am-list-item-dated">
                                <a href="../index/questionDetail.do?qid=${userQuestion.question.qid}"
                                   class="am-list-item-hd ">${userQuestion.question.qtitle}</a>

                                <span class="am-list-date">发布时间:${userQuestion.question.qtime}
									来自：${userQuestion.user.nickname}</span>


                            </li>

                        </c:forEach>
                    </ul>
                </div>

            </div>
            <ul class="pagination">
                <c:if test="${nowPage eq 1||nowPage eq 0}" var="n1"
                      scope="request"></c:if>
                <c:if test="${!n1}">
                    <li class="prev">
                        <a href="../allQuestion/changeQuestionPage.do?page=${nowPage-1}">上一页</a>
                    </li>
                </c:if>
                <li>
                    第 ${nowPage} 页 /共 ${questionPage} 页
                </li>
                <c:if test="${nowPage eq questionPage}" var="n2" scope="request"></c:if>
                <c:if test="${!n2}">
                    <li class="next">
                        <a
                                href="../allQuestions/changeQuestionPage.do?page=${nowPage+1}">下一页</a>
                    </li>
                </c:if>
            </ul>

        </div>
        <!-- end #main -->

        <div id="sidebar">

            <div class="ads box">

                <ul>
                    <li>
                        <a href="../userDetail/addTravels.do"><img width="125"
                                                                   height="125" src="../img/youji.png"
                                                                   alt="Themeforest">
                        </a>
                    </li>
                    <li class="even">
                        <a href="../userDetail/addQuestion.do"><img width="125"
                                                                    height="125" src="../img/tiwen.png"
                                                                    alt="Graphicriver">
                        </a>
                    </li>
                </ul>

            </div>
            <!-- end .ads -->

            <div id="recent-tabs" class="box">

                <div class="box-header">

                    <ul class="nav">
                        <li>
                            <a class="current" href="#recent-tabs-posts">待回答问题</a>
                        </li>
                    </ul>

                </div>
                <!-- end .box-header -->

                <div class="list-wrap">

                    <ul id="recent-tabs-posts">
                        <c:forEach var="userquestion" items="${userquestionList}">

                            <li>
                                <a
                                        href="../index/questionDetail.do?qid=${userquestion.question.qid}"
                                        class="title"> <img
                                        src="../user/${userquestion.user.nickname}/${userquestion.user.faceimg}"
                                        width="60" height="60" alt=""/>
                                        ${userquestion.question.qtitle} </a>
                                <p class="meta">
                                    提问时间：${userquestion.question.qtime}
                                    提问者：${userquestion.user.nickname}
                                </p>
                            </li>

                        </c:forEach>

                    </ul>
                    <!-- end #recent-tabs-posts-->

                    <!-- end #recent-tabs-comments -->

                </div>
                <!-- end .list-wrap -->

            </div>
            <!-- end #recent-tabs -->
            <!-- end .flickr-feed -->
            <!-- end .tags -->

        </div>
        <!-- end #sidebar -->

        <div class="clear"></div>

    </div>
    <!-- end .container -->

</div>
<%@include file="footer.jsp"%>

</body>
</html>
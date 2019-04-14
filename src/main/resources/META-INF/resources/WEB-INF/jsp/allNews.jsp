<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta>
    <title>allNews</title>

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
<!-- end #nav -->

<div id="nav-shadow"></div>

<div id="content">

    <div class="container">

        <div id="main" style="width: 100%">
            <div data-am-widget="list_news" class="am-list-news am-list-news-default">
                <!--列表标题-->
                <div class="am-list-news-hd am-cf">
                    <!--带更多链接-->
                    <a href="###" class="">
                        <h2>新闻信息</h2>
                        <span class="am-list-news-more am-fr">更多 &raquo;</span>
                    </a>
                </div>

                <div class="am-list-news-bd">
                    <ul class="am-list">


                        <c:forEach var="news" items="${newLists}">
                            <!--缩略图在标题左边-->
                            <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                                <div class="am-u-sm-4 am-list-thumb">
                                    <a href="../index/newsDetail.do?nid=${news.nid}" class="">
                                        <img width="60"
                                             height="60" src="../newphoto/${news.newphoto}3.png"
                                             alt="我很囧，你保重....晒晒旅行中的那些囧！"/>
                                    </a>
                                </div>

                                <div class=" am-u-sm-8 am-list-main">
                                    <h3 class="am-list-item-hd"><a href="../index/newsDetail.do?nid=${news.nid}"
                                                                   class="">${news.ntitle}</a></h3>

                                    <div class="am-list-item-text">发布时间:${news.stime} 来自：${news.quarry}</div>

                                </div>
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
                        <a href="../allNews/changeNewPage.do?page=${nowPage-1}">上一页</a>
                    </li>
                </c:if>
                <li>
                    第 ${nowPage} 页 /共 ${newPage} 页
                </li>
                <c:if test="${nowPage eq newPage}" var="n2" scope="request"></c:if>
                <c:if test="${!n2}">
                    <li class="next">
                        <a href="../allNews/changeNewPage.do?page=${nowPage+1}">下一页</a>
                    </li>
                </c:if>
            </ul>

        </div>
        <!-- end #main -->

        </div>
        <!-- end #sidebar -->

        <div class="clear"></div>

    </div>
    <!-- end .container -->

</div>
<%@include file="footer.jsp"%>

</body>
</html>
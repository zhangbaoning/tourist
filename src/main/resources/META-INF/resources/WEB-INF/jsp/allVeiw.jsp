<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta>
    <title>veiwDetail</title>

    <link rel="stylesheet" href="../css/reset.css" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="../element/index.css" type="text/css"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"
          media="screen"/>

    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>

    <link rel="stylesheet" href="css/ie7.css" type="text/css" media="screen"/>

    <link rel="stylesheet" href="http://universal-ie6-css.googlecode.com/files/ie6.1.1.css" media="screen, projection">

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

        <div id="main">
            <h1>
                景点介绍：
            </h1>
            <ul class="gallery-list clearfix">

                <c:forEach var="veiw" items="${veiwLists}">

                    <li class="box">

                        <div class="entry-header">

                            <div class="zoom">
                                <a href="../veiwphoto/${veiw.veiwphoto}2.png"
                                   class="multi_images" rel="gallery-images"
                                   title="${veiw.vname}"> <img
                                        src="../veiwphoto/${veiw.veiwphoto}2.png"
                                        alt="Abroad Trip: Australian Rocks" class="gallery-image">
                                </a>
                            </div>

                            <h6>
                                    ${veiw.vname}
                            </h6>

                            <a href="../index/veiwDetail.do?vid=${veiw.vid}">景点详情...</a>

                        </div>
                        <!-- end .entry-header -->

                    </li>

                </c:forEach>

            </ul>

            <ul class="pagination">
                <c:if test="${nowPage eq 1||nowPage eq 0}" var="n1"
                      scope="request"></c:if>
                <c:if test="${!n1}">
                    <li class="prev">
                        <a href="../allVeiw/changeVeiwPage.do?page=${nowPage-1}">上一页</a>
                    </li>
                </c:if>
                <li>
                    第 ${nowPage} 页 /共 ${veiwPage} 页
                </li>
                <c:if test="${nowPage eq veiwPage}" var="n2" scope="request"></c:if>
                <c:if test="${!n2}">
                    <li class="next">
                        <a href="../allVeiw/changeVeiwPage.do?page=${nowPage+1}">下一页</a>
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
                                <a href="../index/questionDetail.do?qid=${userquestion.question.qid}" class="title">
                                    <img
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
                </div>

            </div>

        </div>
        <!-- end #sidebar -->

        <div class="clear"></div>

    </div>
    <!-- end .container -->

</div>
<%@include file="footer.jsp"%>

</body>
</html>
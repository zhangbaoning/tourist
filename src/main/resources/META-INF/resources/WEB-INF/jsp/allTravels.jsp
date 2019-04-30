<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta>
    <title>allTravels</title>

    <link rel="stylesheet" href="../css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../css/fancybox.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../css/amazeui.min.css" type="text/css"/>

</head>
<body>

<div>

    <%@include file="nav.jsp" %>


</div>

<div id="nav-shadow"></div>

<div id="content">

    <div class="container">

        <div id="main">

            <h2>
                游记信息：
            </h2>

            <c:forEach var="travelsMore" items="${travelsMoreLists}">
            <div data-am-widget="intro"
                 class="am-intro am-cf am-intro-default">
                <div class="am-intro-hd">
                    <h2 class="am-intro-title">${travelsMore.travels.title}</h2>
                </div>

                <div class="am-g am-intro-bd">
                    <div
                            class="am-intro-left am-u-sm-5"><img
                            src="../travels/${travelsMore.user.nickname}/${travelsMore.travels.present}2.png"
                            alt="小娜"/></div>
                    <div
                            class="am-intro-right am-u-sm-7"><p>${travelsMore.present1}</p>
                    </div>
                    <div class="am-intro-more-bottom">
                        <a class="am-btn am-btn-default "
                           href="../travelsDetail/travelsDetail.do?tid=${travelsMore.travels.tid}">更多细节</a>
                    </div>
                </div>
                </c:forEach>

                <ul class="pagination">
                    <c:if test="${nowPage eq 1||nowPage eq 0}" var="n1"
                          scope="request"></c:if>
                    <c:if test="${!n1}">
                        <li class="prev">
                            <a href="../allTravels/changeTravelsPage.do?page=${nowPage-1}">上一页</a>
                        </li>
                    </c:if>
                    <li>
                        第 ${nowPage} 页 /共 ${travelsPage} 页
                    </li>
                    <c:if test="${nowPage eq travelsPage}" var="n2" scope="request"></c:if>
                    <c:if test="${!n2}">
                        <li class="next">
                            <a href="../allTravels/changeTravelsPage.do?page=${nowPage+1}">下一页</a>
                        </li>
                    </c:if>
                </ul>

            </div>


        </div>
    </div>
</div>

<%--<%@include file="footer.jsp" %>--%>


</body>
</html>
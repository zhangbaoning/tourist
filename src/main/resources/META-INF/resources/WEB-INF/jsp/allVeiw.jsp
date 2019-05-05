<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta>
    <title>veiwDetail</title>
    <link rel="stylesheet" href="../css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../element/index.css" type="text/css"/>
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
            <h1>
                景点介绍：
            </h1>
            <ul class="gallery-list clearfix">
                <c:forEach var="veiw" items="${veiwLists}">
                    <div class="am-g">
                        <div class="col-sm-6">
                            <div class="am-thumbnail">
                                <img src="../veiwphoto/${veiw.veiwphoto}2.png" alt=""/>
                                <div class="am-thumbnail-caption">
                                    <h3>${veiw.vname}</h3>
                                    <p><a href="../veiwDetail/veiwDetail.do?vid=${veiw.vid}">景点详情...</a></p>
                                        <%--<p>
                                            <button class="am-btn am-btn-primary">按钮</button>
                                            <button class="am-btn am-btn-default">按钮</button>
                                        </p>--%>
                                </div>
                            </div>
                        </div>
                            <%--<li class="box">

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

                                </div>--%>
                        <!-- end .entry-header -->

                    </div>

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
        <div class="clear"></div>
    </div>
</div>
<%@include file="footer.jsp" %>

</body>
</html>
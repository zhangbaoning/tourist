<%@ page contentType="text/html;charset=utf-8" 
		 pageEncoding="utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <script type="text/javascript" src="../js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                           	   <a><i class="icon-font">&#xe003;</i>常用操作</a>
						<li><a href="../hindex/userWork.do"><i class="icon-font">&#xe008;</i>用户管理</a></li>
						<li><a href="../hindex/veiwWork.do"><i class="icon-font">&#xe008;</i>景点信息管理</a></li>
						<li><a href="../hindex/newsWork.do"><i class="icon-font">&#xe008;</i>新闻管理</a></li>
						<li><a href="../hindex/travelsWork.do"><i class="icon-font">&#xe008;</i>游记管理</a></li>
						<li><a href="../hindex/questionWork.do"><i class="icon-font">&#xe008;</i>问答管理</a></li>
						<li><a href="../hindex/discussWork.do"><i class="icon-font">&#xe008;</i>评论管理</a></li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
            <a>首页</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">用户管理</span>
        </div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="../designUser/mfindUser.do" method="post">
                    <table class="search-tab3">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" name="keywords" id="keywords" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-content">
                	<div class="result-list">
						<a><i class="icon-font">&#xe001;</i></a>
                    </div>
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>编号</th>
                            <th>邮箱</th>
                            <th>密码</th>
                            <th>简介</th>
                            <th>昵称</th>
                            <th>头像路径</th>
                            <th>性别</th>
                            <th>爱好</th>
                            <th>其他操作</th>
                        </tr>
                        <c:forEach var="user"  items="${userLists}">
                       	 	<tr>
                   			<td>${user.userid}</td>
                        	<td>${user.email}</td>
                        	<td>${user.userpwd}</td>
                        	<td>${user.resume}</td>
                        	<td>${user.nickname}</td>
                        	<td>${user.faceimg}</td>
                        	<td>${user.sex}</td>
                        	<td>${user.hobby}</td>
                            <td>
                                <a class="link-del"  href="../designUser/deleteUser.do?userid=${user.userid}">删除</a>
                            </td>
                        	</tr>
                        </c:forEach>
                    </table>
                   <div class="list-page">
                    	<c:if test="${nowPage eq 1||nowPage eq 0}"  var="n1" scope="request"></c:if>
						<c:if test="${!n1}">	
								<a href="../designUser/changeUserPage.do?page=${nowPage-1}">上一页</a>
						</c:if>
                    			第 ${nowPage} 页 /共 ${userPage} 页
                    	<c:if test="${nowPage eq userPage}"  var="n2" scope="request"></c:if>
                    	<c:if test="${!n2}">	
                    	<a href="../designUser/changeUserPage.do?page=${nowPage+1}">下一页</a>
                    	</c:if>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html>
<head>
    <meta>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <script type="text/javascript" src="../js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="../js/myjs.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="hindex.jsp" class="navbar-brand">后台管理</a></h1>            
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
                <li>
                    <a><i class="icon-font">&#xe003;</i>常用操作</a>
						<li><a href="../hindex/userWork.do"><i class="icon-font">&#xe008;</i>用户管理</a></li>
						<li><a href="../hindex/veiwWork.do"><i class="icon-font">&#xe008;</i>景点信息管理</a></li>
						<li><a href="../hindex/newsWork.do"><i class="icon-font">&#xe008;</i>新闻管理</a></li>
						<li><a href="../hindex/travelsWork.do"><i class="icon-font">&#xe008;</i>游记管理</a></li>
						<li><a href="../hindex/questionWork.do"><i class="icon-font">&#xe008;</i>问答管理</a></li>
						<li><a href="../hindex/discussWork.do"><i class="icon-font">&#xe008;</i>评论管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
            <a href="../hindex/hindex.do">首页</a>
            <span class="crumb-step">&gt;</span>
            <span href="../hindex/travelsWork.do" class="crumb-name">游记管理</span>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">审核游记</span>
       		 </div>
        </div>
        <form enctype="multipart/form-data" action="../auditing/auditing.do?tid=${travels.tid}"  method="post">
         	<ul>
         		<p>该游记信息如下：</p>
				<li>
					 <label >发布时间：</label>
                     <input disabled="disabled" class="common-text required" id="veiwphoto" name="veiwphoto" size="18" value="${travels.atime}" type="text" >
                     <label >发布者：</label>
                     <input disabled="disabled" class="common-text required" id="veiwphoto" name="veiwphoto" size="18" value="${user.nickname}" type="text" >
                      <br>
                     <label >游记标题：</label>	
                     <input disabled="disabled" class="common-text required" id="vname" name="vname" size="18" value="${travels.title}" type="text" >
                	  <label >内容路径：</label>
                     <input disabled="disabled" class="common-text required" id="present" name="present" size="18" value="${travels.present}" type="text" >
                     <label >图片根目录：</label>
                     <input disabled="disabled" class="common-text required" id="veiwphoto" name="veiwphoto" size="18" value="${travels.travelsphoto}" type="text" >
                     <br>
                </li>
				<li>
					<br>
					<label color="red">该游记图片(png格式)：</label><br>
					<br>
					<label>1.	第一张</label><br>
            		<div id="divPreview">
                       <img id="imgHeadPhoto"   name="imgHeadPhoto"  width="1010"  height="330" src="${travelsphoto1}">
            		</div>
            		<br>
            		<label>2.	第二张</label><br>
            		<div id="divPreview1">
                       <img id="imgHeadPhoto1" name="imgHeadPhoto1"  width="650"  height="210" src="${travelsphoto2}">
            		</div>
            		<br>
				</li>
				<li>
					<label>3.	该游记内容</label><br>	
					<textarea disabled="disabled" id="present1" name="present1"  style="width:1010px;height:300px;text-align:left;writing-mode:tb-rl;
											SCROLLBAR-FACE-COLOR: #d8fcfc;
											SCRLLBAR-HIGHLIGHT-COLOR: #d8fcfc;
											SCROLLBAR-SHADOW-COLOR: #d8fcfc;
											SCROLLBAR-3DLIGHT-COLOR: #d8fcfc;
											SCROLLBAR-ARROW-COLOR: #fc2400;
											SCROLLBAR-TRACK-COLOR: #00b490;
											SCROLLBAR-DARKSHADOW-COLOR: #d8fcfc;
											SCROLLBAR-BASE-COLOR: #d8fcfc">
								${present1}			
					</textarea>
				</li>
                <li>
                     <input class="btn btn-primary btn6 mr10" value="审核通过"  type="submit">
                </li>              
         	</ul>
        </form>
    </div>
    <!--/main-->
</div>
</body>
</html>
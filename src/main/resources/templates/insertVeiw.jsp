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
            <span class="crumb-name">景点信息管理</span>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">添加景点信息</span>
       		 </div>
        </div>
        <form enctype="multipart/form-data" onsubmit="return valiVeiwSpotNull();" action="../insertVeiwSpot/insertNewVeiwSpotOk.do"  method="post">
         	<ul>
         		<p>填写下列信息：</p>
				<li>
                     <label >景点名称：</label>	
                     <input class="common-text required" id="vname" name="vname" size="18" value="" type="text" onblur="valiVname();">
                	  <label >内容路径：</label>
                     <input class="common-text required" id="present" name="present" size="18" value="" type="text" onblur="valiPresent();">
                     <label >图片根目录：</label>
                     <input class="common-text required" id="veiwphoto" name="veiwphoto" size="18" value="" type="text" onblur="valiViewphoto();">
                     <br>
                     <span style="color:#F00"  id="verror1"></span>
                </li>
				<li>
					<br>
					<label color="red">请上传两张与景点相关的图片(png格式)：</label><br>
					<br>
					<label>1.	请先上传第一张背景大图</label><br>
					<input type="file" name="file"  id="file"   onchange="PreviewImage(this,'imgHeadPhoto','divPreview')"  />  <font color="red"> 图片大小为1010＊330</font> <br/>
            		<div id="divPreview">
                       <img id="imgHeadPhoto"   name="imgHeadPhoto"  width="1010"  height="330" src="">
            		</div>
            		<br>
            		<label>2.	请再上传第二张背景小图</label><br>
					<input type="file" name="file1"   id="file1"  onchange="PreviewImage(this,'imgHeadPhoto1','divPreview')"  />  <font color="red"> 图片大小为650＊210</font> <br/>
            		<div id="divPreview1">
                       <img id="imgHeadPhoto1" name="imgHeadPhoto1"  width="650"  height="210" src="" >
            		</div>
            		<br>
				</li>
				<li>
					<label>3.	请书写该景点介绍内容</label><br>	
					<textarea id="present1" name="present1"  style="width:1010px;height:300px;text-align:left;writing-mode:tb-rl;
											SCROLLBAR-FACE-COLOR: #d8fcfc;
											SCRLLBAR-HIGHLIGHT-COLOR: #d8fcfc;
											SCROLLBAR-SHADOW-COLOR: #d8fcfc;
											SCROLLBAR-3DLIGHT-COLOR: #d8fcfc;
											SCROLLBAR-ARROW-COLOR: #fc2400;
											SCROLLBAR-TRACK-COLOR: #00b490;
											SCROLLBAR-DARKSHADOW-COLOR: #d8fcfc;
											SCROLLBAR-BASE-COLOR: #d8fcfc">
					</textarea>
				</li>
                <li>
                     <input class="btn btn-primary btn6 mr10" value="确认添加"  type="submit">
                </li>              
         	</ul>
        </form>
    </div>
    <!--/main-->
</div>
</body>
</html>
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
            <span class="crumb-name">新闻管理</span>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">更新新闻信息</span>
       		 </div>
        </div>
        <form enctype="multipart/form-data" onsubmit="return valiNewNull();" action="../updateNews/updateNewsOk.do?present=${nownews.present}&&newphoto=${nownews.newphoto}&&nid=${nownews.nid}"  method="post">
         	<ul>
         		<p>填写下列信息：</p>
				<li>
                     <label >新闻标题：</label>	
                     <input disabled="disabled"  class="common-text required" id="ntitle" name="ntitle" size="22" value="${nownews.ntitle}" type="text" onblur="valiNtilte();">
                	  <label >新闻来源：</label>	
                     <input disabled="disabled"  class="common-text required" id="quarry" name="quarry" size="22" value="${nownews.quarry}" type="text" onblur="valiQuarry();">
                	  <br>
                	  <label >内容路径：</label>
                     <input disabled="disabled"  class="common-text required" id="present" name="present" size="18" value="${nownews.present}" type="text" onblur="valiNpresent();">
                     <label >图片根目录：</label>
                     <input disabled="disabled"  class="common-text required" id="newphoto" name="newphoto" size="18" value="${nownews.newphoto}" type="text" onblur="valiNewphoto();">
                     <br>
                     <span style="color:#F00"  id="verror1"></span>
                </li>
				<li>
					<br>
					<label color="red">如要修改请重新上传：</label><br>
					<br>
					<label>1.	请先上传一张大图</label><br>
					<input type="file" name="file"  id="file"   onchange="PreviewImage(this,'imgHeadPhoto','divPreview')"  />  <font color="red"> 图片大小为650＊210</font> <br/>
            		<div id="divPreview">
                       <img id="imgHeadPhoto"   name="imgHeadPhoto"  width="650"  height="210" src="${newphoto1}">
            		</div>
            		<br>
            		<label>2.	请再上传一张小图</label><br>
					<input type="file" name="file1"   id="file1"  onchange="PreviewImage(this,'imgHeadPhoto1','divPreview')"  />  <font color="red"> 图片大小为242＊88</font> <br/>
            		<div id="divPreview1">
                       <img id="imgHeadPhoto1" name="imgHeadPhoto1"  width="242"  height="88" src="${newphoto2}" >
            		</div>
            		<br>
            		<label>3.	请再上传一张来源媒体图</label><br>
					<input type="file" name="file2"   id="file2"  onchange="PreviewImage(this,'imgHeadPhoto2','divPreview')"  />  <font color="red"> 图片大小为60＊60</font> <br/>
            		<div id="divPreview2">
                       <img id="imgHeadPhoto2" name="imgHeadPhoto2"  width="60"  height="60" src="${newphoto3}" >
            		</div>
            		<br>
				</li>
				<li>
					<label>4.	请输入新闻内容</label><br>	
					<textarea id="present1" name="present1"  style="width:1010px;height:300px;text-align:left;writing-mode:tb-rl;
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
                     <input class="btn btn-primary btn6 mr10" value="确认修改"  type="submit">
                </li>              
         	</ul>
        </form>
    </div>
    <!--/main-->
</div>
</body>
</html>
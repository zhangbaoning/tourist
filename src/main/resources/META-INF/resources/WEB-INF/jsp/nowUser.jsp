<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
	<meta>
	<title>nowUser</title>

	<link rel="stylesheet" href="../css/reset.css" type="text/css" media="screen" />

	<!--[if ! lte IE 6]><!-->
	<link rel="stylesheet" href="../css/style.css" type="text/css" media="screen" />
	<!--<![endif]-->

	<!--[if gt IE 6]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<![endif]-->

	<!--[if IE 7]>
	<link rel="stylesheet" href="css/ie7.css" type="text/css" media="screen" />
	<![endif]-->

	<!--[if lte IE 6]>
	<link rel="stylesheet" href="http://universal-ie6-css.googlecode.com/files/ie6.1.1.css" media="screen, projection">
	<![endif]-->

	<link rel="stylesheet" href="../css/fancybox.css" type="text/css" media="screen" />
</head>
<body>

<div id="header-top">

	<div class="container">

		<p class="left">南通旅游攻略网欢迎你！ | 
			<c:if test="${nowuser.nickname==null}"><a href="../index/login.do">登陆</a></c:if>
			<c:if test="${nowuser.nickname!=null}"><a href="../index/userDetail.do">${nowuser.nickname}</a> |<a href="../userDetail/loadUser.do">修改资料</a> |<a href="../index/login.do">切换用户</a> </c:if>
		</p>

		<p class="right">本网站是个人作品  | <strong>   无任何商业用途 </strong></p>

	</div><!-- end .container -->

</div><!-- end #header-top -->

<div id="header">

	<div class="container">

		<h1 id="logo">
			<a href="../index/index.do">
				<img src="../img/logo.png" alt="Travel Guide">
			</a>
		</h1>

		<div id="header-ads">


		</div><!-- end #header-ads -->

	</div><!-- end .container -->

</div><!-- end #header -->

<div id="nav">

	<div class="container">

		<ul>
				<li><a href="../index/index.do">主页</a></li>
			<li><a href="../index/allVeiw.do">景点介绍</a></li>
			<li><a href="../index/allNews.do">新闻通告</a></li>
			<li><a href="../index/allTravels.do ">游记一览</a></li>
			<li><a href="../index/allQuestion.do">问答模块</a></li>
		</ul>

		<div id="search">
<!-- 			<form> -->
<!-- 				<input type="text"  value="" > -->
<!-- 				<input type="submit" class="submit" value="搜索"> -->
<!-- 			</form> -->
		</div><!-- end #search -->

	</div><!-- end .container -->

</div><!-- end #nav -->

<div id="nav-shadow"></div>

<div id="content">

	<div class="container">

		<div id="main">

			<!-- end #archives -->
			<!-- end .search-result -->
			<h1>我的个人信息：</h1>
			 <form  enctype="multipart/form-data" onsubmit="return valiNowUserNull();" action="../updateUser/updateUserOk.do"  method="post">
				<div style="float:left">
						<ul>
				<li>
					<label>1.	头像：</label><br>
					<input type="file" name="file"  id="file"   onchange="PreviewImage(this,'imgHeadPhoto','divPreview')"  />   <br/>
            		<div id="divPreview">
                       <img id="imgHeadPhoto"   name="imgHeadPhoto"  width="210"  height="210" src="../user/${nowuser.nickname}/${nowuser.faceimg}">
            		</div>
                </li>
			
				<li>
					 <br>
					 <label >邮箱：</label>	
                     <input disabled="disabled"   class="common-text required" id="email" name="email" size="22" value="${nowuser.email}" type="text" onblur="valiEmail();">
                	 <br>
                	 <br>
                	 <label >昵称：</label>	
                     <input class="common-text required" id="nickname" name="nickname" size="22" value="${nowuser.nickname}" type="text" onblur="valiNickname();">
                	 <br>
                	 <br>
                	 <label >密码：</label>
                     <input class="common-text required" id="userpwd" name="userpwd" size="22" value="${nowuser.userpwd}" type="text" onblur="valiUserpwd();">
                 	  <span style="color:#F00"  id="userpwd1"></span><br>
                 	  <br>
                 	  <br><span style="color:#F00"  id="nerror"></span><br>
                 </li>
                 <li>
					 <br>
					 <label >简介：</label>	
                     <input class="common-text required" id="resume" name="resume" size="22" value="${nowuser.resume}" type="text" onblur="valiResume();">
                	 <br>
                	 <br>
                	 <label >性别：</label>	
                     <input class="common-text required" id="sex" name="sex" size="22" value="${nowuser.sex}" type="text" onblur="valiSex();">
                	 <br>
                	 <br>
                	 <label >爱好：</label>
                     <input class="common-text required" id="hobby" name="hobby" size="22" value="${nowuser.hobby}" type="text" onblur="valiHobby();">
                 	  <br>
                 	  <br>
                 </li>
                 
                 <li>
                 	<input type="submit" value="确认修改">
                 </li>
				
         	</ul>
				</div>         	
        	</form>
        
		</div><!-- end #main -->

		<div class="clear"></div>

	</div><!-- end .container -->

</div><!-- end #content -->

<div id="footer">

	<div class="container clearfix">

		<a href="../index/index.do"><img src="../img/footer-logo.png" alt="footer-logo" class="footer-logo" /></a>

		<div class="one-third">

			<h4>关于我们的网站</h4>

			<p>本网站名为南通旅游攻略网,是分享南通旅游行程的一个平台。本网站是个人作品网站，不涉及任何商业操作。</p>

			<strong>作者 qyn</strong>

		</div><!-- end .one-third -->

		<div class="one-fourth">

			<h4>导航</h4>

			<ul id="categories">
				<li><a href="#">景点介绍</a></li>
				<li><a href="#">新闻通告</a></li>
				<li><a href="#">游记一览</a></li>
				<li><a href="#">问答模块</a></li>
			</ul>

		</div><!-- end .one-fourth -->

		<div class="two-fifth last">

			<h4><span>其他</span> 事项</h4>

			<ul id="latest-tweets">

				<li>
					<h4>1.关于网站建设</h4>
					<p class="tweet">如果合理提议请联系管理员！</p>
				</li>
				<li>
					<h4>2.关于发帖内容</h4>
					<p class="tweet">请发布符合实际，和谐的内容，管理员会对发帖内容进行审核！</p>
				</li>

			</ul><!-- end #latest-tweets -->

		</div><!-- end .one-misc -->

	</div><!-- end .container -->

</div><!-- end #footer -->

<div id="footer-bottom">

	<div class="container">

		<p class="align-left">感谢你的使用！ </p>

		<ul class="align-right">
			<p>如果有BUG请联系管理员！ </p>
		</ul>

	</div><!-- end .container -->

</div><!-- end #footer-bottom -->

<!-- start scripts -->
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.cycle.all.min.js"></script>
<script src="../js/jquery.easing.1.3.js"></script>
<script src="../js/organictabs.jquery.js"></script>
<script src="../js/jquery.fancybox-1.3.4.pack.js"></script>
<script src="../js/css3-mediaqueries.js"></script>
<script src="../js/custom.js"></script>
<script src="../js/myjs.js"></script>
<!--[if IE]> <script src="js/selectivizr.js"></script> <![endif]-->
<!-- end scripts -->
</body>
</html>
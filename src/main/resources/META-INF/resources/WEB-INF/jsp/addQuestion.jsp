<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
	<meta>
	<title>addQuestion</title>

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
	<link href="../css/vendor/bootstrap.min.css" rel="stylesheet">
	<link href="../css/flat-ui.css" rel="stylesheet">

</head>
<body>

<div id="header-top">

	<div class="container">

		<p class="left">西安乡村旅游网欢迎你！ |
			<c:if test="${nowuser.nickname==null}"><a href="../index/login.do">登陆</a></c:if>
			<c:if test="${nowuser.nickname!=null}"><a href="../index/userDetail.do">${nowuser.nickname}</a> |<a href="../index/login.do">切换用户</a> </c:if>
		</p>

		<p class="right">本网站是个人作品  | <strong>   无任何商业用途 </strong></p>

	</div><!-- end .container -->

</div><!-- end #header-top -->

	<nav class="navbar navbar-default navbar-expand-lg" role="navigation">

		<ul class="nav navbar-nav mr-auto">
			<li><a href="../index/index.do">主页</a></li>
			<li><a href="../index/allVeiw.do">景点介绍</a></li>
			<li><a href="../index/allNews.do">新闻通告</a></li>
			<li><a href="../index/allTravels.do ">游记一览</a></li>
			<li class="active"><a href="../index/allQuestion.do">问答模块</a></li>
		</ul>
	</nav>


<div id="content">

	<div class="container">

		<div id="main" style="width: 100%">

			<!-- end #archives -->
			<!-- end .search-result -->
			<h1 style="font-size: 28px">我要提问 ：</h1>
			
			<div id="respond" class="box" style="padding: 10px;">
				<form enctype="multipart/form-data" onsubmit="return valiQuestionNull();" action="../addQuestion/addQuestion.do"  method="post">

						<p>
							<label>问题标题<span>(*必填)</span></label>
							<input  class="form-control" name="qtitle"  id="qtitle"  onblur="valiQtitle();">
						</p>
	
						
						<label>问题内容：(*必填，不超过一百个字)</label>	
						<p>
							<textarea id="qpresent" name="qpresent" rows="10" cols="85" onblur="valiQpresent();"></textarea>
						</p>
						<p>
							<input type="submit" name="submit" value="发布问题" class="btn btn-primary" />
						</p>
						<span style="color:#F00"  id="qerror"></span><br>
				</form>
				
			</div><!-- end #respond -->

		</div>
		</div><!-- end #sidebar -->

		<div class="clear"></div>

	</div><!-- end .container -->

</div><!-- end #content -->

<div id="footer">

	<div class="container clearfix">

		<a href="../index/index.do"><img src="../img/footer-logo.png" alt="footer-logo" class="footer-logo" /></a>

		<div class="one-third">

			<h4>关于我们的网站</h4>

			<p>本网站名为西安乡村旅游网,是分享南通旅游行程的一个平台。本网站是个人作品网站，不涉及任何商业操作。</p>

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
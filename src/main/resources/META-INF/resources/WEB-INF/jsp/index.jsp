,,
<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>

	<meta charset="utf-8">

	<title>NTYL</title>

	<link rel="stylesheet" href="../css/reset.css" type="text/css" media="screen" />

	<link rel="stylesheet" href="../css/style.css" type="text/css" media="screen" />

	<link rel="stylesheet" href="../css/fancybox.css" type="text/css" media="screen" />

</head>

<body>

<div id="header-top">

	<div class="container">

		<p class="left">南通旅游攻略网欢迎你！ | 
			<c:if test="${nowuser.nickname==null}"><a href="../index/login.do">登陆</a></c:if>
			<c:if test="${nowuser.nickname!=null}"><a href="../index/userDetail.do">${nowuser.nickname}</a> |<a href="../index/login.do">切换用户</a> </c:if>
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
		
			<a href="#?ref=smuliii"></a>
			
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
		</div>
		<!-- end #search -->

	</div><!-- end .container -->

</div><!-- end #nav -->

<div id="nav-shadow"></div>

<div id="slider">

	<div class="container">
	
		<ul>
			 <c:forEach var="veiw"  items="${veiwLists}">
			 
			<li>

				<img src="../veiwphoto/${veiw.veiwphoto}1.png" width="1010" height="330" alt="" />

				<div class="slide-info">

					<h2><a href="../index/veiwDetail.do?vid=${veiw.vid}">${veiw.vname}</a></h2>

					<a href="../index/veiwDetail.do?vid=${veiw.vid}" class="slider-button">详情...</a>

				</div><!-- end .slide-info -->

			</li>
			
			</c:forEach>
		</ul>

	</div><!-- 热门景点介绍模块 -->
	
</div><!-- end #slider -->

<div id="content">

	<div class="container">

		<div id="main">
			
			<div id="trips-viewer" class="box">

				<div class="box-header">

					<ul class="tabs-nav">
						<li><a href="#featured-trips">新闻速递</a></li>
					</ul>

			</div><!-- end .box-header -->

				<div id="featured-trips" class="tab-content">

					<div class="trips-container">

						<ul>
							
							<c:forEach var="news"  items="${newLists}">
							
							<li id="featured-slide-one" class="trip-content">

								<a href="../index/newsDetail.do?nid=${news.nid}">
									<img src="../newphoto/${news.newphoto}2.png" width="242" height="88" alt="" />
									<h4 class="title"  href="../index/newsDetail.do?nid=${news.nid}">${news.ntitle}</h4>
								</a>
								<p class="meta">发布时间:${news.stime}   来自：${news.quarry}</p>

								<p>${news.summary}</p>

								<a class="button" href="../index/newsDetail.do?nid=${news.nid}">详情...</a>

							</li><!-- end #slide-one -->
							
							</c:forEach>

						</ul>

					</div><!-- end .trips-container -->

					<ul class="trips-nav">
					
						<c:forEach var="news"  items="${newLists}">
						
						<li class="nav-button">
							<div class="content">
								<a href="#featured-slide-one" class="title">
									<img src="../newphoto/${news.newphoto}3.png" width="60" height="60" alt="" />
									<h6>${news.summary }</h6>
								</a>
								<p class="meta">发布时间:${news.stime}   来自：${news.quarry}</p>
								<ul class="links">
									<li><a href="../index/newDetail.do?nid=${news.nid}">详情...</a></li>
								</ul>
							</div><!-- end .content -->
						</li>
						
						</c:forEach>
						
					</ul><!-- end .trips-nav -->

				</div><!-- end #featured-trips -->

				<div id="popular-trips" class="tab-content">

					<div class="trips-container">

					</div><!-- end .trips-container -->

				</div><!-- end #popular-trips -->

				<div id="most-viewed-trips" class="tab-content">

					<div class="trips-container">

					</div><!-- end .trips-container -->

				</div><!-- end #most-viewed-trips -->

			</div><!-- end #trips-viewer -->

			<h2 class="title">最热游记排行</a></h2>

			<c:forEach var="travelsMore"  items="${travelsMoreLists}">
			
			<div class="entry">
				
				<div class="entry-header">

					<h2 class="title"><a href="../index/travelsDetail.do?tid=${travelsMore.travels.tid}">${travelsMore.travels.title}</a></h2>

					<p class="meta">创建时间：${travelsMore.travels.atime}          发布者：${travelsMore.user.nickname}</p>

					<a href="../index/travelsDetail.do?tid=${travelsMore.travels.tid}" class="button">详情...</a>

				</div><!-- end .entry-header -->

				<div class="entry-content">

					<a href="../index/travelsDetail.do?tid=${travelsMore.travels.tid}"><img src="../travels/${travelsMore.user.nickname}/${travelsMore.travels.present}2.png" width="240" height="140" alt="" class="entry-image" /></a>

					<p>${travelsMore.present1}</p>

					<hr />

					<ul class="entry-links">
						<li>${travelsMore.discussNum} 条评论 <span class="separator">|</span></li>
					</ul>

				</div><!-- end .entry-content -->

			</div><!-- end .entry -->
			
			</c:forEach>

		</div><!-- end #main -->

		<div id="sidebar">
		
			<div class="ads box">

				
						<ul>
							<li>
								<a href="../userDetail/addTravels.do"><img width="125"
										height="125" src="../img/youji.png" alt="Themeforest">
								</a>
							</li>
							<li class="even">
								<a href="../userDetail/addQuestion.do"><img width="125"
										height="125" src="../img/tiwen.png" alt="Graphicriver">
								</a>
							</li>
						</ul>

			</div><!-- end .ads -->
			
			<div id="recent-tabs" class="box">
			
				<div class="box-header">

					<ul class="nav">
						<li><a class="current" href="#recent-tabs-posts">待回答问题</a></li>
					</ul>

				</div><!-- end .box-header -->

				<div class="list-wrap">

					<ul id="recent-tabs-posts">
						<c:forEach var="userquestion"  items="${userquestionList}">
						
						<li>
							<a href="../index/questionDetail.do?qid=${userquestion.question.qid}" class="title">
								<img src="../user/${userquestion.user.nickname}/${userquestion.user.faceimg}" width="60" height="60" alt="" />
								${userquestion.question.qtitle}
							</a>
							<p class="meta">
							提问时间：${userquestion.question.qtime}      提问者：${userquestion.user.nickname}</p>
						</li>
						
						</c:forEach>

					</ul> <!-- end #recent-tabs-comments -->

				</div><!-- end .list-wrap -->
				
			</div><!-- end #recent-tabs -->

			<div class="tags box">

				<div class="box-header">

					<h6>关键标签查询</h6>

				</div><!-- end .box-header -->

			</div><!-- end .tags -->

		</div><!-- end #sidebar -->

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
<!--[if IE]> <script src="js/selectivizr.js"></script> <![endif]-->
<!-- end scripts -->
</body>
</html>
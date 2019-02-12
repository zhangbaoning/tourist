<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta>
		<title>addTravels</title>

		<link rel="stylesheet" href="../css/reset.css" type="text/css"
			media="screen" />

		<!--[if ! lte IE 6]><!-->
		<link rel="stylesheet" href="../css/style.css" type="text/css"
			media="screen" />
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

		<link rel="stylesheet" href="../css/fancybox.css" type="text/css"
			media="screen" />

	</head>
	<body>

		<div id="header-top">

			<div class="container">

				<p class="left">
                    西安乡村旅游网欢迎你！ |
					<c:if test="${nowuser.nickname==null}">
						<a href="../index/login.do">登陆</a>
					</c:if>
					<c:if test="${nowuser.nickname!=null}">
						<a href="#">${nowuser.nickname}</a> |<a href="../index/login.do">切换用户</a>
					</c:if>
				</p>

				<p class="right">
					本网站是个人作品 |
					<strong> 无任何商业用途 </strong>
				</p>

			</div>
			<!-- end .container -->

		</div>
		<!-- end #header-top -->

		<div id="header">

			<div class="container">

				<h1 id="logo">
					<a href="../index/index.do"> <img src="../img/logo.png"
							alt="Travel Guide"> </a>
				</h1>

				<div id="header-ads">


				</div>
				<!-- end #header-ads -->

			</div>
			<!-- end .container -->

		</div>
		<!-- end #header -->

		<div id="nav">

			<div class="container">

				<ul>
					<li>
						<a href="../index/index.do">主页</a>
					</li>
					<li>
						<a href="../index/allVeiw.do">景点介绍</a>
					</li>
					<li>
						<a href="../index/allNews.do">新闻通告</a>
					</li>
					<li>
						<a href="../index/allTravels.do ">游记一览</a>
					</li>
					<li>
						<a href="../index/allQuestion.do">问答模块</a>
					</li>
				</ul>

				<div id="search">
<!-- 					<form> -->
<!-- 						<input type="text" value=""> -->
<!-- 						<input type="submit" class="submit" value="搜索"> -->
<!-- 					</form> -->
				</div>
				<!-- end #search -->

			</div>
			<!-- end .container -->

		</div>
		<!-- end #nav -->

		<div id="nav-shadow"></div>

		<div id="content">

			<div class="container">

				<div id="main">

					<!-- end #archives -->
					<!-- end .search-result -->
					<h1>
						发布游记：
					</h1>

					<div id="respond" class="box">

						<div class="box-header">

							<h6 class="align-left">
								请填写完整：
							</h6>

							<p class="align-right">
								<strong>以下内容上传至服务器审核</strong>
							</p>

						</div>

						<form enctype="multipart/form-data"
							onsubmit="return valiTravelsNull();"
							action="../addTravels/addTravels.do" method="post">

							<p>
								<label>
									游记标题
									<span>(*必填)</span>
								</label>
								<input name="title" id="title" onblur="valiTtitle();">
							</p>

							<p>
								<label>
									内容路径
									<span>(*必填)</span>
								</label>
								<input type="text" name="present" id="present"
									onblur="valiTpresent();">
							</p>

							<p>
								<label>
									图片路径
									<span>(*必填)</span>
								</label>
								<input type="text" name="travelsphoto" id="travelsphoto"
									onblur="valiTravelsphoto();">
							</p>
							<span style="color: #F00" id="terror"></span>
							<br>
							<label color="red">
								请上传两张符合规定的与新闻相关的图片(png格式)：
							</label>
							<br>
							<br>
							<label>
								1. 请先上传一张大图
							</label>
							<br>
							<input type="file" name="file" id="file"
								onchange="PreviewImage(this,'imgHeadPhoto','divPreview')" />
							<font color="red"> 图片大小为650＊210</font>
							<br />
							<div id="divPreview">
								<img id="imgHeadPhoto" name="imgHeadPhoto" width="650"
									height="210" src="">
							</div>
							<br>
							<label>
								2. 请再上传一张小图
							</label>
							<br>
							<input type="file" name="file1" id="file1"
								onchange="PreviewImage(this,'imgHeadPhoto1','divPreview')" />
							<font color="red"> 图片大小为242＊140</font>
							<br />
							<div id="divPreview1">
								<img id="imgHeadPhoto1" name="imgHeadPhoto1" width="242"
									height="140" src="">
							</div>
							<label>
								游记内容：(*必填)
							</label>
							<p>
								<textarea id="present1" name="present1" rows="20" cols="85"></textarea>
							</p>
							<p>
								<input type="submit" name="submit" value="上传游记" class="submit" />
							</p>

						</form>

					</div>
					<!-- end #respond -->

				</div>
				<!-- end .entry -->

				<div id="sidebar">

					<div class="ads box">

						<ul>
							<li>
								<a href="../userDetail/addTravels.do"><img width="125"
										height="125" src="../img/youji.png" alt="Themeforest"> </a>
							</li>
							<li class="even">
								<a href="../userDetail/addQuestion.do"><img width="125"
										height="125" src="../img/tiwen.png" alt="Graphicriver">
								</a>
							</li>
						</ul>

					</div>
					<!-- end .ads -->

					<div class="tags box">

						<div class="box-header">

							<h6>
								关注
							</h6>

						</div>
						<!-- end .box-header -->

					</div>

					<div class="tags box">

						<div class="box-header">

							<h6>
								粉丝
							</h6>

						</div>
						<!-- end .box-header -->

					</div>

					<!-- end #recent-tabs -->

					<div class="flickr-feed box">

						<div class="box-header">

							<h6 class="align-left">
								<img src="../img/icon-flickr-feed.png" alt="icon-flickr-feed"
									class="flickr-icon" />
								最近访客
							</h6>


						</div>
						<!-- end .box-header -->

					</div>
					<!-- end .flickr-feed -->

					<!-- end .tags -->


				</div>
				<!-- end #sidebar -->

				<div class="clear"></div>

			</div>
			<!-- end .container -->

		</div>
		<!-- end #content -->

		<div id="footer">

			<div class="container clearfix">

				<a href="../index/index.do"><img src="../img/footer-logo.png"
						alt="footer-logo" class="footer-logo" />
				</a>

				<div class="one-third">

					<h4>
						关于我们的网站
					</h4>

					<p>
                        本网站名为西安乡村旅游网,是分享南通旅游行程的一个平台。本网站是个人作品网站，不涉及任何商业操作。
					</p>

					<strong>作者 qyn</strong>

				</div>
				<!-- end .one-third -->

				<div class="one-fourth">

					<h4>
						导航
					</h4>

					<ul id="categories">
						<li>
							<a href="#">景点介绍</a>
						</li>
						<li>
							<a href="#">新闻通告</a>
						</li>
						<li>
							<a href="#">游记一览</a>
						</li>
						<li>
							<a href="#">问答模块</a>
						</li>
					</ul>

				</div>
				<!-- end .one-fourth -->

				<div class="two-fifth last">

					<h4>
						<span>其他</span> 事项
					</h4>

					<ul id="latest-tweets">

						<li>
							<h4>
								1.关于网站建设
							</h4>
							<p class="tweet">
								如果合理提议请联系管理员！
							</p>
						</li>
						<li>
							<h4>
								2.关于发帖内容
							</h4>
							<p class="tweet">
								请发布符合实际，和谐的内容，管理员会对发帖内容进行审核！
							</p>
						</li>

					</ul>
					<!-- end #latest-tweets -->

				</div>
				<!-- end .one-misc -->

			</div>
			<!-- end .container -->

		</div>
		<!-- end #footer -->

		<div id="footer-bottom">

			<div class="container">

				<p class="align-left">
					感谢你的使用！
				</p>

				<ul class="align-right">
					<p>
						如果有BUG请联系管理员！
					</p>
				</ul>

			</div>
			<!-- end .container -->

		</div>
		<!-- end #footer-bottom -->

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
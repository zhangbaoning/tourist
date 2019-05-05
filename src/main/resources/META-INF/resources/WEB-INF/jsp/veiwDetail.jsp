<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c"
          uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta>
    <title>veiwDetail</title>
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

<div id="content" style="width: 90%">

    <div class="container">

        <div id="main" style="width: 100%">
            <div class="entry single">
                <div class="entry-content">
                    <article class="am-article">
                        <div class="am-article-hd">
                            <h1 class="am-article-title">${title}</h1>
                            <p class="am-article-meta">发布时间:${addTime} <%--来自：${nownews.quarry}--%></p>
                        </div>
                        <%--<div class="zoom">
                            <a class="single_image" href="img/sample-images/800x600.jpg">
                                <img src="${newphoto1}" width="650" height="210"
                                     alt="Texas Trip 2010: Abandoned ranch" class="entry-image"/>
                            </a>
                        </div>--%>
                        <div class="am-article-bd">
                            <p class="am-article-lead">${content}</p>
                        </div>
                    </article>
                </div>
            </div>
        </div>
        <div id="comments">

            <div class="box-header">

                <div class="align-left">
                    <span class="comments-count"><em></em></span> <h6>评论</h6>&emsp;
                </div>

                <div class="align-right">
                    <!--						<strong><a href="#respond">+ADD NEW COMMENT</a></strong>-->
                </div>

            </div>

            <ol class="comments-list">

                <c:forEach var="userDiscuss" items="${userDiscussLists}">

                    <li class="comment first">

                        <div class="comment-avatar">

                            <img src="../user/${userDiscuss.user.nickname}/${userDiscuss.user.faceimg}" width="60"
                                 height="60" alt="Gravatar"
                                 class="avatar"/>

                        </div>
                        <!-- .comment-avatar -->

                        <div class="comment-body">

                            <div class="comment-meta">

                                <a>${userDiscuss.user.nickname}</a>,
                                <span class="date">${userDiscuss.discuss.ptime}</span>

                            </div>
                            <!-- .comment-meta -->

                            <p>
                                    ${userDiscuss.discuss.present}
                            </p>


                        </div>
                        <!-- .comment-body -->

                    </li>
                    <!-- .comment -->
                </c:forEach>
            </ol>


        </div><!-- #comments -->
        <div class="list-page">
            <c:if test="${nowPage eq 1||nowPage eq 0}" var="n1" scope="request"></c:if>
            <c:if test="${!n1}">
                <li class="prev"><a href="../veiwDetail/changeDiscussPage.do?page=${nowPage-1}">上一页</a></li>
            </c:if>
            第 ${nowPage} 页 /共 ${userDiscussPage} 页
            <c:if test="${nowPage eq userDiscussPage}" var="n2" scope="request"></c:if>
            <c:if test="${!n2}">
                <li><a class="next" href="../veiwDetail/changeDiscussPage.do?page=${nowPage+1}">下一页</a></li>
            </c:if>
        </div>

        <div id="respond" class="box">

            <div class="box-header">

                <h6 class="align-left">我要评论</h6>

            </div>

            <form method="post"
                  action="../veiwDetail/insertDiscuss.do?type=2&&pid=${nowveiw.vid}&&uid=${nowuser.userid}"
                  id="comment-form" class="form clearfix">

                <div class="textarea_block">

                    <p>
                        <label for="comment">评论内容 </label>
                        <textarea id="present" name="present" rows="10" cols="60" class="input"></textarea>
                    </p>

                    <p>
                        <input type="submit" name="submit" value="提交" class="submit"/>
                    </p>

                </div>

            </form>

        </div><!-- end #respond -->
        <div class="clear"></div>

    </div><!-- end .container -->

</div><!-- end #content -->


<div id="footer">

    <div class="container clearfix">

        <a href="../index/index.do"><img src="../img/footer-logo.png" alt="footer-logo" class="footer-logo"/></a>

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
<!--[if IE]>
<script src="js/selectivizr.js"></script> <![endif]-->
<!-- end scripts -->
</body>
</html>
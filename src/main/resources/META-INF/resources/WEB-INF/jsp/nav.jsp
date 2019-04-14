<%@ page language="java" pageEncoding="utf-8" %>
<div id="header-top">

    <div class="container">

        <p class="left">
            西安乡村旅游网欢迎你！ |
            <c:if test="${nowuser.nickname==null}">
                <a href="../index/login.do">登陆</a>
            </c:if>
            <c:if test="${nowuser.nickname!=null}">
                <a href="../index/userDetail.do">${nowuser.nickname}</a> |<a
                href="../index/login.do">切换用户</a>
            </c:if>
        </p>


    </div>
</div>
<header class="am-topbar">
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav">
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
    </div>
</header>
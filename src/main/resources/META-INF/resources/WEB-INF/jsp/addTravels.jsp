<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta>
    <title>addTravels</title>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/jquery.cycle.all.min.js"></script>
    <script src="../js/jquery.easing.1.3.js"></script>
    <script src="../js/organictabs.jquery.js"></script>
    <script src="../js/jquery.fancybox-1.3.4.pack.js"></script>
    <script src="../js/css3-mediaqueries.js"></script>
    <script src="../js/custom.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/ueditor.all.min.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="../js/lang/zh-cn/zh-cn.js"></script>
    <script src="../js/myjs.js"></script>

    <!--[if IE]>
    <script src="js/selectivizr.js"></script> <![endif]-->
    <link rel="stylesheet" href="../css/reset.css" type="text/css"
          media="screen"/>

    <!--[if ! lte IE 6]><!-->
    <link rel="stylesheet" href="../css/style.css" type="text/css"
          media="screen"/>
    <!--<![endif]-->

    <!--[if gt IE 6]>
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>
    <![endif]-->

    <!--[if IE 7]>
    <link rel="stylesheet" href="css/ie7.css" type="text/css" media="screen"/>
    <![endif]-->

    <!--[if lte IE 6]>
    <link rel="stylesheet" href="http://universal-ie6-css.googlecode.com/files/ie6.1.1.css" media="screen, projection">
    <![endif]-->

    <link rel="stylesheet" href="../css/fancybox.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../js/element/index.css" type="text/css"/>
    <script src="../js/vue.js"></script>
    <script src="../js/element/index.js"></script>
    <style>
        .el-input {
            width: 50% !important;
        }
        .el-form-item {
            margin: 5%;
        }
    </style>
    <script type="text/javascript">

        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue = UE.getEditor('editor');
        console.log(ue);

        function isFocus(e) {
            alert(UE.getEditor('editor').isFocus());
            UE.dom.domUtils.preventDefault(e)
        }

        function setblur(e) {
            UE.getEditor('editor').blur();
            UE.dom.domUtils.preventDefault(e)
        }

        function insertHtml() {
            var value = prompt('插入html代码', '');
            UE.getEditor('editor').execCommand('insertHtml', value)
        }

        function createEditor() {
            enableBtn();
            UE.getEditor('editor');
        }

        function getAllHtml() {
            alert(UE.getEditor('editor').getAllHtml())
        }

        function getContent() {
            var arr = [];
            arr.push("使用editor.getContent()方法可以获得编辑器的内容");
            arr.push("内容为：");
            arr.push(UE.getEditor('editor').getContent());
            alert(arr.join("\n"));
        }

        function getPlainTxt() {
            var arr = [];
            arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
            arr.push("内容为：");
            arr.push(UE.getEditor('editor').getPlainTxt());
            alert(arr.join('\n'))
        }

        function setContent(isAppendTo) {
            var arr = [];
            arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
            UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
            alert(arr.join("\n"));
        }

        function setDisabled() {
            UE.getEditor('editor').setDisabled('fullscreen');
            disableBtn("enable");
        }

        function setEnabled() {
            UE.getEditor('editor').setEnabled();
            enableBtn();
        }

        function getText() {
            //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
            var range = UE.getEditor('editor').selection.getRange();
            range.select();
            var txt = UE.getEditor('editor').selection.getText();
            alert(txt)
        }

        function getContentTxt() {
            var arr = [];
            arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
            arr.push("编辑器的纯文本内容为：");
            arr.push(UE.getEditor('editor').getContentTxt());
            alert(arr.join("\n"));
        }

        function hasContent() {
            var arr = [];
            arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
            arr.push("判断结果为：");
            arr.push(UE.getEditor('editor').hasContents());
            alert(arr.join("\n"));
        }

        function setFocus() {
            UE.getEditor('editor').focus();
        }

        function deleteEditor() {
            disableBtn();
            UE.getEditor('editor').destroy();
        }

        function disableBtn(str) {
            var div = document.getElementById('btns');
            var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
            for (var i = 0, btn; btn = btns[i++];) {
                if (btn.id == str) {
                    UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
                } else {
                    btn.setAttribute("disabled", "true");
                }
            }
        }

        function enableBtn() {
            var div = document.getElementById('btns');
            var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
            for (var i = 0, btn; btn = btns[i++];) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            }
        }

        function getLocalData() {
            alert(UE.getEditor('editor').execCommand("getlocaldata"));
        }

        function clearLocalData() {
            UE.getEditor('editor').execCommand("clearlocaldata");
            alert("已清空草稿箱")
        }
    </script>
</head>
<body>
<div id="app">
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

        <div id="main" style="width: 100%">

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

                <el-form  enctype="multipart/form-data"
                      onsubmit="return valiTravelsNull();"
                      action="../addTravels/addTravels.do" method="post">
                        <el-form-item  label="游记标题">
                        <el-input name="title" id="title" v-model="title" onblur="valiTtitle();" ></el-input>
                    </el-form-item>
                        <el-form-item  label="内容路径">
                        <el-input type="text" name="present" v-model="present" id="present"
                                  onblur="valiTpresent();" ></el-input>
                    </el-form-item>
                        <el-form-item  label="图片路径">
                            <el-input type="text" name="travelsphoto" v-model="travelsphoto" id="travelsphoto"
                                      onblur="valiTravelsphoto();" ></el-input>
                        </el-form-item>

                    <span style="color: #F00" id="terror"></span>
                    <br>
                    <%--<label color="red">
                        请上传两张符合规定的与新闻相关的图片(png格式)：
                    </label>
                    <br>
                    <br>
                    <label>
                        1. 请先上传一张大图
                    </label>
                    <br>
                    <input type="file" name="file" id="file"
                           onchange="PreviewImage(this,'imgHeadPhoto','divPreview')"/>
                    <font color="red"> 图片大小为650＊210</font>
                    <br/>
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
                           onchange="PreviewImage(this,'imgHeadPhoto1','divPreview')"/>
                    <font color="red"> 图片大小为242＊140</font>
                    <br/>
                    <div id="divPreview1">
                        <img id="imgHeadPhoto1" name="imgHeadPhoto1" width="242"
                             height="140" src="">
                    </div>--%>
                    <label>
                        游记内容：(*必填)
                    </label>
                    <p>
                        <%--<textarea id="present1" name="present1" rows="20" cols="85"></textarea>--%>
                    <div>
                        <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script></div>
                    </p>
                    <p>
                        <input type="submit" name="submit" value="上传游记" class="submit">
                        <el-button>默认按钮</el-button>
                    </p>

                </el-form >

            </div>
            <!-- end #respond -->

        </div>
        <!-- end .entry -->

        <%--<div id="sidebar">

            <div class="ads box">

                <ul>
                    <li>
                        <a href="../userDetail/addTravels.do"><img width="125"
                                                                   height="125" src="../img/youji.png"
                                                                   alt="Themeforest"> </a>
                    </li>
                    <li class="even">
                        <a href="../userDetail/addQuestion.do"><img width="125"
                                                                    height="125" src="../img/tiwen.png"
                                                                    alt="Graphicriver">
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
                             class="flickr-icon"/>
                        最近访客
                    </h6>


                </div>
                <!-- end .box-header -->

            </div>
            <!-- end .flickr-feed -->

            <!-- end .tags -->


        </div>--%>
        <!-- end #sidebar -->

        <div class="clear"></div>

    </div>
    <!-- end .container -->

</div>
<!-- end #content -->

<div id="footer">

    <div class="container clearfix">

        <a href="../index/index.do"><img src="../img/footer-logo.png"
                                         alt="footer-logo" class="footer-logo"/>
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
</div>
</body>
<script>
    new Vue({
    el: '#app',
    data: function() {
    return { visible: false
    ,title:''
    ,present:'',
    ,travelsphoto:''
    }
    }
    })
</script></html>
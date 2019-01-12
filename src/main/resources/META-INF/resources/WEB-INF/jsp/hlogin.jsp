<%@ page contentType="text/html;charset=utf-8" 
		 pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
    <title>后台管理</title>
    <link href="../css/admin_login.css" rel="stylesheet" type="text/css" />
    <script language="javascript" type="text/javascript" src="../js/myjs.js"></script>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="okhlogin.do" method="post">
            <h2 style="color: red;text-align: center">${message}</h2>
                <ul class="admin_items">
                    <li>
                        <label for="opname">用户名：</label>
                        <input type="text" name="opname" value="" id="opname" size="40" class="admin_input_style" onblur="valiOpname();"/>
                        <span style="color:#F00" id="opname1"></span>
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="oppwd" value="" id="oppwd" size="40" class="admin_input_style"  onblur="valiOppwd();"/>
                    	<span style="color:#F00" id="oppwd1"></span>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="登陆" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
  	</div>
  </div>
</body>
</html>
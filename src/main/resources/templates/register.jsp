<%@ page contentType="text/html;charset=utf-8" 
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>注册</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		
		<link rel="stylesheet" href="../css/demo.css">
		<link rel="stylesheet" href="../css/sky-forms.css">
		<!--[if lt IE 9]>
			<link rel="stylesheet" href="css/sky-forms-ie8.css">
		<![endif]-->
		
		<script src="../js/jquery-1.9.1.min.js"></script>
		<script src="../js/jquery.validate.min.js"></script>
		 <script language="javascript" type="text/javascript" src="../js/myjs.js"></script>
		<!--[if lt IE 10]>
			<script src="js/jquery.placeholder.min.js"></script>
		<![endif]-->		
		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/sky-forms-ie8.js"></script>
		<![endif]-->
	</head>
	
<body class="bg-cyan">
		<div  class="body body-s" style="margin:0 auto">		
			<form action="../login/addUser.do" id="sky-form" class="sky-form" method="post">
				<header>注册新用户</header>
				<h2 style="color: red;text-align: center">${dmessage2}</h2>	
				<fieldset>					
					<section>
						<label class="input">
							<i class="icon-append icon-user"></i>
							<input type="text" name="memail" id="memail" placeholder="邮箱" onblur="valiEmail();">
							<span style="color:#F00" id="memail1"></span>
							<b class="tooltip tooltip-bottom-right">进入网站时使用</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append icon-envelope-alt"></i>
							<input type="text" name="nickname" id="nickname" placeholder="昵称" onblur="valiNickname();">
							<span style="color:#F00" id="nickname1"></span>
							<b class="tooltip tooltip-bottom-right">用于网站称呼</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append icon-lock"></i>
							<input type="password" name="userpwd" id="userpwd" placeholder="密码" id="password" onblur="valiUserpwd();">
							<span style="color:#F00" id="userpwd1"></span>
							<b class="tooltip tooltip-bottom-right">登陆时使用的密码！</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append icon-lock"></i>
							<input type="password" name="userpwdok"  id="userpwdok" placeholder="重复密码" onblur="valiUserpwdok();">
							<span style="color:#F00" id="userpwdok1"></span>
							<b class="tooltip tooltip-bottom-right">必须与密码一致！</b>
						</label>
					</section>
				</fieldset>
					
				<footer>
					<button type="submit" class="button">完成</button>
				</footer>
			</form>			
		</div>


		
		
		<script type="text/javascript">
			$(function()
			{
				// Validation		
				$("#sky-form").validate(
				{					
					// Rules for form validation
					rules:
					{
						username:
						{
							required: true
						},
						email:
						{
							required: true,
							email: true
						},
						password:
						{
							required: true,
							minlength: 3,
							maxlength: 20
						},
						passwordConfirm:
						{
							required: true,
							minlength: 3,
							maxlength: 20,
							equalTo: '#password'
						},
						firstname:
						{
							required: true
						},
						lastname:
						{
							required: true
						},
						gender:
						{
							required: true
						},
						terms:
						{
							required: true
						}
					},
					
					// Messages for form validation
					messages:
					{
						login:
						{
							required: 'Please enter your login'
						},
						email:
						{
							required: 'Please enter your email address',
							email: 'Please enter a VALID email address'
						},
						password:
						{
							required: 'Please enter your password'
						},
						passwordConfirm:
						{
							required: 'Please enter your password one more time',
							equalTo: 'Please enter the same password as above'
						},
						firstname:
						{
							required: 'Please select your first name'
						},
						lastname:
						{
							required: 'Please select your last name'
						},
						gender:
						{
							required: 'Please select your gender'
						},
						terms:
						{
							required: 'You must agree with Terms and Conditions'
						}
					},					
					
					// Do not change code below
					errorPlacement: function(error, element)
					{
						error.insertAfter(element.parent());
					}
				});
			});			
		</script>
	</body>
</html>
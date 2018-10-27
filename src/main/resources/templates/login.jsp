<%@ page contentType="text/html;charset=utf-8" 
		 pageEncoding="utf-8"%>
<!--<!DOCTYPE html>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 5.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>登陆</title>
		
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
		<div class="body1 body-s">		
			<form action="../login/oklogin.do" id="sky-form" class="sky-form" method="post">
				<header>登录</header>
				<h2 style="color: red;text-align: center">${dmessage}</h2>
				<fieldset>					
					<section>
						<label class="input">
							<i class="icon-append icon-user"></i>	
							<input type="text" name="demail" placeholder="邮箱"  id="demail"  onblur="valiEmail2();">
							<span style="color:#F00" id="memail2"></span>
							<b class="tooltip tooltip-bottom-right">请输入有效账号</b>
						</label>
					</section> 
					
					<section>
						<label class="input">
							<i class="icon-append icon-lock"></i>
							<input type="password" name="duserpwd" placeholder="密码" id="duserpwd" onblur="valiUserpwd2();">
							<span style="color:#F00" id="userpwd2"></span>
							<b class="tooltip tooltip-bottom-right">密码正确才能登陆</b>
						</label>
					</section>
					
				</fieldset>
					
				<footer>
					<button type="submit" class="button">登录</button>
					没有账号，点击<a href="../index/register.do">注册</a>
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
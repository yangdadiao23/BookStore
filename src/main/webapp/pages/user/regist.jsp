<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(function (){

			$("#sub_btn").click(function (){

				var name = $("#username").val();
				var namepatt=/^\w{5,12}$/;
				if(!namepatt.test(name)){
					$("span.errorMsg").text("error username!");
					return false;
				}

				var psw = $("#password").val();
				var pswpatt=/^\w{5,12}$/;
				if(!pswpatt.test(psw)){
					$("span.errorMsg").text("error password!");
					return false;
				}

				var repsw = $("#repwd").val();
				if(repsw!=psw){
					$("span.errorMsg").text("different password!")
					return false;
				}

				var email = $("#email").val();
				var emailpatt=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
				if(!emailpatt.test(email)){
					$("span.errorMsg").text("error email!")
					return false;
				}

				var code= $("#code").val();
				var newcode = code.trim();
				if(newcode==null||newcode==""){
					$("span.errorMsg").text("error email!")
					return false;
				}

			})


			$("span.errorMsg").text("");

		})

	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="registServlet" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="../../static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
     <%@include file="/pages/common/tail.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影院登录</title>
<link rel="stylesheet" href="/ttms_ssm/css/login.css">
</head>
<body>

	<h1>永乐票务</h1>

	<div class="login" style="margin-top: 50px;">

		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">售票员登录</a> <a
					class="switch_btn" id="switch_login" href="javascript:void(0);"
					tabindex="8">系统管理员登录</a>
				<div class="switch_bottom" id="switch_bottom"
					style="position: absolute; width: 64px; left: 0px;"></div>
			</div>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">
			<!--登录-->
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<form action="/ttms_ssm/user/login" name="loginform"
							accept-charset="utf-8" id="login_form" class="loginForm"
							method="post">
							<input type="hidden" name="did" value="0" /> <input
								type="hidden" name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">用户名：</label>
								<div class="inputOuter" id="uArea">
									<input type="text" id="u" name="account" class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="p" name="pwd" class="inputstyle" />
								</div>
							</div>

							<div>
								<input type="submit" value="登录" class="button_blue" />
								<!-- <a href="./ticket.html" class="button_blue">登录</a> -->
							</div>
						</form>
					</div>

				</div>

			</div>
			<!--登录end-->
		</div>

		<!--注册-->
		<div class="qlogin" id="qlogin" style="display: none;">

			<div class="web_login">
				<form name="form2" action="/ttms_ssm/user/login" id="regUser"
					accept-charset="utf-8" method="post">
					<input type="hidden" name="to" value="reg" /> <input type="hidden"
						name="did" value="0" />
					<ul class="reg_form" id="reg-ul">
						<br>
						<br>
						<li><label for="user" class="input-tips2">用户名：</label>
							<div class="inputOuter2">
								<input type="text" id="user" name="account" maxlength="16"
									class="inputstyle2" />
							</div></li>

						<li><label for="passwd" class="input-tips2">密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd" name="pwd" maxlength="16"
									class="inputstyle2" />
							</div></li>

						<li>
							<div class="inputArea">
								<input type="submit" id="reg" class="button_blue" value="登录" />
								<!-- <a href="./mIndex.html" class="button_blue">登录</a> -->
							</div>

						</li>
					</ul>
				</form>
			</div>
		</div>
		${msg}
		<!--注册end-->
	</div>
	<script src="/ttms_ssm/dist/jquery-3.1.1.min.js"></script>
	<script src="/ttms_ssm/js/login.js"></script>
</body>
</html>
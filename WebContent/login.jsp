<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var username = document.getElementById("username");
		var password = document.getElementById("password");
		if (username.value == "" || password.value == "") {
			alert("用户名或密码不能为空!");
			return false;
		} else if (password.value.length<6 || password.value.length>10) {
			alert("密码应在6~10 位!");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="LoginServlet" method="post" onsubmit="return validate();">
		<h3 align="center">请使用已有账号登录</h3>
		<table align="center" width="60%" height="200px" border="1">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" id="username"></td>
				<td rowspan="4" background="images/8.jpg">
					<p>还没有账号?</p>
					<p>
						<a href="regist1.jsp">点我去注册</a>
					</p>
				</td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" id="password"></td>
			<tr>
			<tr>
				<td colspan="2" align="center"><div style="float: left;">
						<a href="shop.jsp">游客登录</a>
					</div>
					<div>
						<input type="submit" value="登录">
					</div></td>
			<tr>
		</table>
	</form>
</body>
</html>
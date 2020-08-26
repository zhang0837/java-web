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
	<table width="60%" align="center">
		<tr>
			<td align="center">
				<h4>开始注册</h4>
			</td>
		</tr>
	</table>
	<p>
	<form action="RegistServlet" method="post"
		onsubmit=" return validate();">
		<table width="60%" height="200px" align="center" border="1">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="注册"></td>
			</tr>
		</table>
	</form>
</body>
</html>
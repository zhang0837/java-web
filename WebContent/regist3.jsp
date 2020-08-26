<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	%>
	<jsp:useBean id="user" class="com.qst.bean.UserBean" scope="session" />
	<jsp:setProperty property="*" name="user" />
	<%
		session.setAttribute("user", user);
	%>
	<form action="RegistDataSetvlet" method="post">
		<table width="60%" height="200px" align="center" border="1">
			<tr>
				<td colspan="2" align="center"><font color="blue">用户信息确认</font></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><jsp:getProperty property="username" name="user" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><jsp:getProperty property="password" name="user" /></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><jsp:getProperty property="age" name="user" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><jsp:getProperty property="sex" name="user" /></td>
			</tr>
			<tr>
				<td>提示信息</td>
				<td><jsp:getProperty property="tooltip" name="user" /></td>

			</tr>
			<tr>
				<td>提示答案</td>
				<td><jsp:getProperty property="answer" name="user" /></td>
			</tr>
			<tr>
				<td>愿意接受的信息</td>
				<td><jsp:getProperty property="chooseinfor" name="user" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="确认提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
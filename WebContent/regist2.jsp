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
	%>
	<!--重定向过来的页面中的request和session域中的内容都不能被javaBean 捕获,只能是请求转发过来的才可以 -->
	<jsp:useBean id="user" class="com.qst.bean.UserBean" scope="session" />
	<jsp:setProperty property="username" name="user" />
	<jsp:setProperty property="password" name="user" />

	<form action="regist3.jsp" method="post">
		<table width="60%" height="200px" align="center" border="1">
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="sex" value="男" checked="checked">男
					<input type="radio" name="sex" value="女">女</td>
			</tr>
			<tr>
				<td>提示信息</td>
				<td><select name="tooltip">
						<option>我父亲的名字</option>
						<option>我母亲的名字</option>
				</select></td>
			</tr>
			<tr>
				<td>提示答案</td>
				<td><input type="text" name="answer"></td>
			</tr>
			<tr>
				<td>愿意接受的信息</td>
				<td><input type="checkbox" name="infor" value="新闻">新闻 <input
					type="checkbox" name="infor" value="报纸">报纸 <input
					type="checkbox" name="infor" value="亲友">亲友</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
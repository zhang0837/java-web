<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var goodname = document.getElementById("goodname");
		var number = document.getElementById("number");
		if (username.value == "" || password.value == "") {
			alert("商品名和修改的商品数量不能为空!");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="UpdateMyBookServlet" method="post" onsubmit="return validate();">
		<h3 align="center">请输入你要修改的商品信息</h3>
		<table align="center" width="60%" height="200px" border="1">
			<tr>
				<td>商品名:</td>
				<td><input type="text" name="goodname" id="goodname"></td>
			</tr>
			<tr>
				<td>修改后的数量:</td>
				<td><input type="text" name="number" id="number"></td>
			<tr>
			<tr>
				<td align="right"><input type="submit" value="确定修改"></td>
				<td align="right"><a href="LookMyBooksServlet">放弃修改</a></td>
			<tr>
		</table>
	</form>
</body>
</html>
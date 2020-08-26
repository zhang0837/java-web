<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.qst.bean.BookBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fu() {
		var hobbyNum = document.getElementsByName("book"); //  获取checkbox对象,是一个数组对象
		var hobby = ""; //用于存储已选择的选项值
		for (i = 0; i < hobbyNum.length; ++i) { //遍历数组中的对象，查看有没有被选择的值
			if (hobbyNum[i].checked) { //checked代表被选择
				hobby += hobbyNum[i]; //把被选择的数据复制给hobby变量
			}
		}
		if (hobby == "") { //hobby为空代表没有选择
			alert("请至少选者一种您要购买的书籍!!");
			return false;
		}
	}
</script>
</head>
<body>
<a href="LookMyBooksServlet">查看我的购买记录</a>
	<form action="ShopServlet" method="post" onsubmit="return fu();">
		<table width="100%" height="500px">
			<tr>
				<td colspan="3" align="center"><h2>请选择你要购买的商品</h2></td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td><img src="images/1.jpg" width="300px" height="400px" /></td>
						</tr>
						<tr>
							<td>java 基础入门 <input type="checkbox" name="book" id="book"
								value="java 基础入门">
							</td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td><img src="images/3.jpg" width="300px" height="400px" /></td>
						</tr>
						<tr>
							<td>java 从入门到精通<input type="checkbox" name="book" id="book"
								value="java 从入门到精通"></td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td><img src="images/4.jpg" width="300px" height="400px" /></td>
						</tr>
						<tr>
							<td>java web开发详解<input type="checkbox" name="book" id="book"
								value="java web开发详解"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td><img src="images/2.jpg" width="300px" height="400px" /></td>
						</tr>
						<tr>
							<td>深入理解Java虚拟机<input type="checkbox" name="book" id="book"
								value="深入理解Java虚拟机"></td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td><img src="images/6.jpg" width="300px" height="400px" /></td>
						</tr>
						<tr>
							<td>计算机编程<input type="checkbox" name="book" id="book"
								value="计算机编程"></td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td><img src="images/7.jpg" width="300px" height="400px" /></td>
						</tr>
						<tr>
							<td>NET WORK<input type="checkbox" name="book" id="book"
								value="NET WORK"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="购买"></td>
			</tr>
		</table>
	</form>
</body>
</html>
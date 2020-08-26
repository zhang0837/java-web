package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.qst.bean.BookBean;
import com.qst.bean.UserBean;
import com.qst.dao.BookDao;
import com.qst.dao.UserDao;
import java.util.ArrayList;
import java.util.Map;

/**
 * Servlet implementation class ShopDateServlet
 */
@WebServlet("/ShopDateServlet")
public class ShopDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopDateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String username = (String) session.getAttribute("userName");
		String password = (String) session.getAttribute("passWord");
		Map<String, Integer> car = (Map<String, Integer>) session.getAttribute("shoppingCar");
		UserDao userDao = new UserDao();
		int id = userDao.getIdByUsername(username);
		BookDao bookDao = new BookDao();
		int unitprice = 100;
		boolean b = false;
		ArrayList<BookBean> allMyBooks = bookDao.getAllBooksById(id);

		if (username == null && password == null) {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('请登录后购买');");
			out.print("window.location = 'login.jsp';");
			out.print("</script>");
		} else {
			if (allMyBooks.size() == 0) {
				for (String bookName : car.keySet()) {
					int bookNumber = car.get(bookName);
					b = bookDao.insertByBook(bookName, unitprice, bookNumber, id);
				}
			} else {
				// 这里要注意，第一次写的时候出现过循环嵌套的逻辑出现错误（现已更正），应该先遍历car.keySet()，再遍历用户数据库中allMyBooks！！！！！！！！！！
				for (String bookName : car.keySet()) {
					boolean c = false;
					for (BookBean book : allMyBooks) {
						if (book.getBookname().equals(bookName)) {
							int bookNumber = car.get(bookName) + book.getBooknumber();
							b = bookDao.updateByBook(bookName, bookNumber,id);
							c = true;
							break;
						}
					}
					if (c == false) {
						int bookNumber = car.get(bookName);
						b = bookDao.insertByBook(bookName, unitprice, bookNumber, id);
					}
				}
				/*
				 * for (String bookName : car.keySet()) { int bookNumber = 0;
				 * for (BookBean book : allMyBooks) { b=false; int dbBookNumber
				 * = book.getBooknumber(); String dbBookName =
				 * book.getBookname(); if (bookName.equals(dbBookName)) {
				 * bookNumber = car.get(bookName) + dbBookNumber; b =
				 * bookDao.updateByBook(bookName, bookNumber); } } if (b ==
				 * false) bookNumber = car.get(bookName); b =
				 * bookDao.insertByBook(bookName, unitprice, bookNumber, id); }
				 */
			}
			if (b == true) {
				out.print("<script type = 'text/javascript'>");
				out.print("window.location = 'end.jsp';");
				out.print("</script>");
			} else {
				out.print("<script type = 'text/javascript'>");
				out.print("alert('购买失败!!');");
				out.print("window.location = 'shop.jsp';");
				out.print("</script>");
			}
		}
	}
}

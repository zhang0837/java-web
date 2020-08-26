package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.dao.BookDao;
import com.qst.dao.UserDao;

/**
 * Servlet implementation class UpdateMyBookServlet
 */
@WebServlet("/UpdateMyBookServlet")
public class UpdateMyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMyBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserDao userDao = new UserDao();
		BookDao bookDao = new BookDao();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String goodname = request.getParameter("goodname");
		String unumber = request.getParameter("number");
		// 要将String型的数据number转换成int型
		int number = Integer.parseInt(unumber);
		String username = (String) session.getAttribute("userName");
		String bookname = (String) session.getAttribute("delbnamebid");
		int id = userDao.getIdByUsername(username);
		boolean b = bookDao.updateByBook(goodname, number,id);
		if (b == true) {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('修改成功!');");
			out.print("window.location = 'LookMyBooksServlet';");
			out.print("</script>");
		} else {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('修改失败!');");
			out.print("window.location = 'LookMyBooksServlet';");
			out.print("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

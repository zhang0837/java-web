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
 * Servlet implementation class DeleteMyBooksServlet
 */
@WebServlet("/DeleteMyBooksServlet")
public class DeleteMyBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMyBooksServlet() {
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
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String username = (String) session.getAttribute("userName");
		String bookname = (String) session.getAttribute("delbnamebid");
		UserDao userDao = new UserDao();
		int id = userDao.getIdByUsername(username);
		BookDao bookDao = new BookDao();
		boolean b = bookDao.deleteByBook(bookname, id);
		if (b == true) {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('É¾³ý³É¹¦!');");
			out.print("window.location = 'LookMyBooksServlet';");
			out.print("</script>");
		} else {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('É¾³ýÊ§°Ü!');");
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

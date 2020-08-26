package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.qst.bean.BookBean;
import com.qst.dao.BookDao;
import com.qst.dao.UserDao;

/**
 * Servlet implementation class LookMyBooksServlet
 */
@WebServlet("/LookMyBooksServlet")
public class LookMyBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LookMyBooksServlet() {
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
		UserDao userDao = new UserDao();
		int id = userDao.getIdByUsername(username);
		BookDao bookDao = new BookDao();
		ArrayList<BookBean> allMyBooks = bookDao.getAllBooksById(id);
		if (allMyBooks.size() == 0) {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('您还未购买任何产品!');");
			out.print("window.location = 'shop.jsp';");
			out.print("</script>");
		} else {
			// servlet中的换行操作是连接+"<br>"
			out.print("<a href='shop.jsp'>返回商城</a>" + "<br>");
			out.print("<a href='InvalidateServlet'>退出商城</a>" + "<br>");
			out.println(username + "的所有购买记录：" + "<br>");
			int bid = 0;
			int dbid = 0;
			for (BookBean book : allMyBooks) {
				String delbname = ++dbid + "";
				session.setAttribute("delbnamebid", book.getBookname());
				out.println("第" + ++bid + "件商品:");
				out.println(book.toString() + "<a href='update.jsp'>修改购买数量</a>" + "&nbsp" + "&nbsp"
						+ "<a href='DeleteMyBooksServlet'>删除</a>" + "<br>");
			}
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

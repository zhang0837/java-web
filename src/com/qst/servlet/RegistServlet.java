package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.cj.Session;
import com.qst.dao.UserDao;
import com.qst.util.DBUtil;
import sun.security.util.Password;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		UserDao userdao = new UserDao();
		/*
		 * PreparedStatement pstmt = null; Connection conn = null; ResultSet rs
		 * = null;
		 * 
		 * try { conn = DBUtil.getConnection(); } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } String sql =
		 * "SELECT * FROM register where username = ?"; try { pstmt =
		 * conn.prepareStatement(sql); pstmt.setString(1, username); rs =
		 * pstmt.executeQuery();
		 */
		int id = userdao.getIdByUsername(username);
		if (id == 0) {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			RequestDispatcher dispatcher = request.getRequestDispatcher("regist2.jsp");
			dispatcher.forward(request, response);
		} else {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('用户名已存在!!');");
			out.print("window.location = 'regist1.jsp';");
			out.print("</script>");
		}

	}
}

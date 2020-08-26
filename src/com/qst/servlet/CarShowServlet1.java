package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarShowServlet1
 */
@WebServlet("/CarShowServlet1")
public class CarShowServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarShowServlet1() {
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
		String bName;
		int num;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Map<String, Integer> car = (Map<String, Integer>) session.getAttribute("shoppingCar");
		out.print("您的购物车如下:" + "<p>");
		for (String bookName : car.keySet()) {
			num = car.get(bookName);
			bName = bookName;
			out.print(bookName + "选了" + num + "本" + "<p>");
		}

		out.print("<a href='ShopDateServlet'>确认购买</a>" + "<p>");
		out.print("<a href='shop.jsp'>继续购买</a>" + "<p>");
		out.print("<a href='CleaCarServlet'>清空购物车</a>" + "<p>");
	}
}
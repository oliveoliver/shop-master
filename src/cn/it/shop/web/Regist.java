package cn.it.shop.web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Regist() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String money = request.getParameter("money");

		User user = new User(login, pass, sex, phone, email, money);
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		session.setAttribute("pass", pass);
		session.setAttribute("sex", sex);
		session.setAttribute("phone", phone);
		session.setAttribute("email", email);
		session.setAttribute("uuser", user);
		session.setAttribute("money", money);

		System.out.println("登陆名为：" + login + "密码为：" + pass + "性别是：" + sex + "电话号码：" + phone + "邮箱是：" + email + "uuser:"
				+ user + "money:" + money);

		if (login != "" && pass != "" && phone != "" && email != "" && sex != null) {
			request.getRequestDispatcher("/registsuccess.jsp").forward(request, response);
		} else {
			response.sendRedirect("/shop/regist.jsp");
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

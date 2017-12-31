package cn.it.shop.web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.it.shop.model.Forder;

/**
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String money = (String) session.getAttribute("money");
		Forder forder = (Forder) session.getAttribute("oldForder");
		
		BigDecimal money1 = new BigDecimal(money);
		System.out.println("total:"+forder.getTotal()+"money:"+money1);
		
		if((money1.compareTo(forder.getTotal()) == 1)||(money1.compareTo(forder.getTotal()) == 0)) { //余额大于等于总金额
			response.sendRedirect("/shop/pay1.jsp");
		}else {
			response.sendRedirect("/shop/pay2.jsp");
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

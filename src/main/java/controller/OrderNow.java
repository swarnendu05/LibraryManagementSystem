package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Cart;
import model.Order;
import model.Student;

/**
 * Servlet implementation class OrderNow
 */
@WebServlet("/OrderNow")
public class OrderNow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderNow() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

		try (PrintWriter out = response.getWriter()) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			Student auth = (Student) request.getSession().getAttribute("auth");

			System.out.println("from student " + auth);
			if (auth != null) {
				String productId = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				if (productQuantity <= 0) {
					productQuantity = 1;
				}
				Order orderModel = new Order();
				orderModel.setId(Integer.parseInt(productId));
				System.out.println("studentid" + auth.getId());
				orderModel.setUid(auth.getUid());
				orderModel.setQunatity(productQuantity);
				orderModel.setDate(formatter.format(date));
				OrderDAO orderDao = new OrderDAO();
				boolean result = orderDao.insertOrder(orderModel);
				//System.out.println(result);

				if (result) {
					@SuppressWarnings("unchecked")
					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					if (cart_list != null) {
						for (Cart c : cart_list) {
							if (c.getId() == Integer.parseInt(productId)) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
						}
					}
					// response.sendRedirect("orders.jsp");
					response.sendRedirect(request.getContextPath() + "/Orders.jsp");
				} else {
					out.println("order failed");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

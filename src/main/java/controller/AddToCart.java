package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import model.Cart;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//. TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		 try (PrintWriter out = response.getWriter()) {
		
		 ArrayList<Cart> cartList = new ArrayList<>();
         int id = Integer.parseInt(request.getParameter("id"));
         Cart cm = new Cart();
         cm.setId(id);
         cm.setQuantity(1);
        // System.out.println("id....."+id);
         HttpSession session = request.getSession();
         @SuppressWarnings("unchecked")
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		
        if (cart_list == null) {
             cartList.add(cm);
           session.setAttribute("cart-list", cartList);
          // out.println("section ....");
            response.sendRedirect(request.getContextPath() +"/index.jsp");
         } 
        else {
             cartList = cart_list;

             boolean exist = false;
             for (Cart c : cart_list) {
                 if (c.getId() == id) {
                     exist = true;
                   //  out.println("project exites ....");
                     out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='index.jsp'>GO to Index Page</a></h3>");
                }
             }

            if (!exist) {
            	//System.out.println("desnot exites");
                cartList.add(cm);
//                 response.sendRedirect(request.getContextPath() +"index.jsp");
                 response.sendRedirect(request.getContextPath() + "/index.jsp");
             }
       }
		
		
		 }
	}

}

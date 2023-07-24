package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.Student;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		

//		st.setEmail(request.getParameter("username"));
//		st.setPassword(request.getParameter("password"));
//		try {
//			if (LoginDAO.adminLogin(st) == "Success") {
//				System.out.println("from serveletss");
//				HttpSession session = request.getSession();
//				session.setAttribute("userName", st.getEmail());
//				response.sendRedirect(request.getContextPath() + "/index.jsp");
//			} else {
//				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//				request.setAttribute("error", "Login Failed");
//				rd.forward(request, response);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(email);

			LoginDAO udao = new LoginDAO();
			Student user = udao.adminLogin(email, password);
			if (user != null) {
				request.getSession().setAttribute("auth", user);

				response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				out.println("there is no user");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

}

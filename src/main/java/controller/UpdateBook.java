package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		Book book = new Book();
		
         book.setTitle(request.getParameter("title"));
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String publisher = request.getParameter("publisher");
		
		
//		
//		if (BookDAO.updateDoctor(d)) {
//			//session.setAttribute("succMsg", "Doctor Update Sucessfully..");
//			resp.sendRedirect("admin/view_doctor.jsp");
//		} else {
//			((ServletRequest) response).setAttribute("errorMsg", "something wrong on server");
//			response.sendRedirect("admin/view_doctor.jsp");
//		}
		
		
		
		
		
		
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentRegistrationDAO;
import model.Student;

@WebServlet("/StudentReg")
public class StudentReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Acttion called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println(request.getContextPath());

		Student student = new Student();
//		System.out.println(new Date());

		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone_no = request.getParameter("phone-number");
		String gender = request.getParameter("gender");
		String course = request.getParameter("course");
		String roll_no = request.getParameter("roll-number");
		String password = request.getParameter("password");

		student.setFirstName(first_name);
		student.setLastName(last_name);
		student.setEmail(email);
		student.setPhone_no(phone_no);
		student.setGender(gender);
		student.setCourse(course);
		student.setRoll_no(roll_no);
		student.setPassword(password);

		

		StudentRegistrationDAO srd = new StudentRegistrationDAO();

		try {
			String result = srd.registerDao(student);

			if (result == "Success") {
//				out.print(student.getFirstName() + " inserted succesfully into the database!");
				response.sendRedirect(request.getContextPath()+"/Login.jsp");
			} else if (result == "Duplicate") {
				out.print("Email- " + student.getEmail() + " is allready used!");
			}

			else {
				out.print("Somthing went wrong!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

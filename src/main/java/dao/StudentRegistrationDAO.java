package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Student;
import utils.DbConnection;
import utils.DuplicateCheck;

public class StudentRegistrationDAO {

	public String registerDao(Student st) throws SQLException {
		Connection con = DbConnection.createConnection();
		DuplicateCheck dc = new DuplicateCheck();
		Boolean isDuplicateEmail = dc.isDulicate("email", st.getEmail(), "student");
		Boolean isDuplicateRoll = dc.isDulicate("roll_no", st.getRoll_no(), "student");
		if (isDuplicateEmail || isDuplicateRoll) {

			return "Duplicate";
		}
		String sql_query = "insert into student (first_name,last_name,email,phone_no,gender,course,roll_no,password) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql_query);

		ps.setString(1, st.getFirstName());
		ps.setString(2, st.getLastName());
		ps.setString(3, st.getEmail());
		ps.setString(4, st.getPhone_no());
		ps.setString(5, st.getGender());
		ps.setString(6, st.getCourse());
		ps.setString(7, st.getRoll_no());
		ps.setString(8, st.getPassword());

		int res = ps.executeUpdate();
		System.out.println("Printing Db response: " + res);
		if (res > 0) {
			con.close();
			return "Success";
		}
		con.close();
		return "Faild";
	}

}

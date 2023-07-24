package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import utils.DbConnection;

public class AminLoginDAO {
	public static String adminLoginDao (Student st) throws SQLException{
		Connection con = DbConnection.createConnection();
		String sql_query = "select email, password from admin where email=?";
		PreparedStatement ps = con.prepareStatement(sql_query);
		
		ps.setString(1, st.getEmail());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String userName=rs.getString(1);
			String password = rs.getString(2);
			if(userName.equals(st.getEmail()) && password.equals(st.getPassword())) {
				System.out.println("Sucess");
				return "Success";
			}
		}
		
		return "Faild";
	}
	
	
	public static Student adminLogin (String email,String password) throws SQLException{
		Connection con = DbConnection.createConnection();
		Student st=null;
		try {
		String sql_query = "select* from student where email=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql_query);
		
		ps.setString(1,email );
		ps.setString(2,password );
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			 st = new Student();
			
			
			st.setEmail(rs.getString("email"));
			st.setPassword(rs.getString("password"));
			
			//st.setEmail(rs.getString("email"));
			 //st.getEmail()
			 System.out.println(st.getEmail());
        	
		}
        	
//			String userName=rs.getString(1);
//			String password = rs.getString(2);
//			if(userName.equals(st.getEmail()) && password.equals(st.getPassword())) {
//				System.out.println("Sucess");
//				return "Success";
//			}
		}
			
			
		catch (SQLException e) {
            System.out.print(e.getMessage());
        }
		
		
		return st;
	}

	
}

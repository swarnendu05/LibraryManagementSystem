package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DuplicateCheck {

	public boolean isDulicate(String checkParamKey, String checkParamValue, String tableName) throws SQLException

	{
		String query;
		Connection con = DbConnection.createConnection();

		switch (tableName) {
		case "student":
			query = "select count(*) from " + tableName + " where " + checkParamKey + " = ?;";
			break;
		default:
			query = "nothing";
		}

		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, checkParamValue);
		ResultSet rs = ps.executeQuery();

		System.out.println("Printing resultSet: " + rs);
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			if (rs.getInt(1) > 0) {
				return true;
			}
		}
		

		return false;

	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Cart;
import utils.DbConnection;

public class BookDAO {

	public static String save(Book bk) throws SQLException {

		Connection con = DbConnection.createConnection();

		String sql_query = "insert into books (title,name,author,publisher,description,quantity,price) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql_query);

		ps.setString(1, bk.getTitle());
		ps.setString(2, bk.getName());
		ps.setString(3, bk.getPublisher());
		ps.setString(4, bk.getDescription());
		ps.setString(5, bk.getPublisher());
		ps.setInt(6, bk.getQuantity());
		ps.setString(7, bk.getPrice());

		int res = ps.executeUpdate();
		if (res > 0) {
			con.close();
			return "Success";
		}

		return "Faild";

	}

	public boolean updatBook(Book bk) throws SQLException {
		boolean f = false;

		try {
		Connection con = DbConnection.createConnection();

		String sql_query = "update books set title = ?,name= ?, author =? publisher = ?,description= ?,quantity=?,price=?;";

		PreparedStatement ps = con.prepareStatement(sql_query);

		ps.setString(1, bk.getTitle());
		ps.setString(2, bk.getName());
		ps.setString(3, bk.getPublisher());
		ps.setString(4, bk.getDescription());
		ps.setString(5, bk.getPublisher());
		ps.setInt(6, bk.getQuantity());
		ps.setString(7, bk.getPrice());

		int i = ps.executeUpdate();

		if (i == 1) {
			f = true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	return f;

	}
	
	

	public static List<Book> view() {
		List<Book> list = new ArrayList<Book>();
		try {
			Connection con = DbConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from mylibrary.books");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book bk = new Book();
				bk.setId(rs.getInt("book_id"));
				bk.setTitle(rs.getString("title"));
				// bk.setName(rs.getString("name"));
				bk.setAuthor(rs.getString("author"));
				bk.setPublisher(rs.getString("publisher"));
				bk.setQuantity(rs.getInt("quantity"));
				bk.setDescription(rs.getString("description"));

				// bean.setIssued(rs.getInt("issued"));
				
				list.add(bk);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static List<Book> search(String ch) {

		List<Book> list = new ArrayList<Book>();
		try {
			Connection con = DbConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from books where title like ? or  author like ?");
			ps.setString(1, "%" + ch + "%");
			ps.setString(2, "%" + ch + "%");
			// ps.setString(3, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book bk = new Book();
				bk.setId(rs.getInt("book_id"));
				bk.setTitle(rs.getString("title"));
				// bk.setName(rs.getString("name"));
				bk.setAuthor(rs.getString("author"));
				bk.setPublisher(rs.getString("publisher"));
				bk.setQuantity(rs.getInt("quantity"));

				//System.out.println("from book dao" + bk.getAuthor());
				list.add(bk);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static int delete(String callno) {
		int status = 0;
		try {
			Connection con = DbConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("delete from books where book_id=?");
			ps.setString(1, callno);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		List<Cart> books = new ArrayList<>();
		try {
			Connection con = DbConnection.createConnection();
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					String query = "select * from books where book_id=?";
					PreparedStatement ps = con.prepareStatement(query);

					ps.setInt(1, item.getId());
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Cart row = new Cart();
						row.setId(rs.getInt("book_id"));
						row.setTitle(rs.getString("title"));
						row.setAuthor(rs.getString("author"));
						// row.set(rs.getDouble("price")*item.getQuantity());
						row.setQuantity(item.getQuantity());
						books.add(row);
					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return books;
	}
	
	public static List<Book>getSingleBook(int id) {
		List<Book> list = new ArrayList<Book>();
		Book row = null;
	        try {
	        	Connection con = DbConnection.createConnection();
	           String query = "select * from books where book_id=? ";
	           PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	row = new Book();
	                row.setId(rs.getInt("book_id"));
	                row.setTitle(rs.getString("title"));
	                row.setAuthor(rs.getString("author"));
	                row.setQuantity(rs.getInt("quantity"));
	                row.setPublisher(rs.getString("publisher"));
	                list.add(row);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return list;
	    }

}
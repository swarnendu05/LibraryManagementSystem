package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*
;
import model.Order;
import utils.DbConnection;

public class OrderDAO {
	static Connection con = DbConnection.createConnection();
	
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
	
	
	public boolean insertOrder(Order model) {
        boolean result = false;
        try {
           String query = "insert into orders (book_id,user_id, order_quantity, order_date) values(?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getUid());
            pst.setInt(3, model.getQunatity());
            pst.setString(4, model.getDate());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	

    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
           String query = "select * from orders where order_id=? order by orders.order_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                BookDAO productDao = new BookDAO();
                int pId = rs.getInt("book_id");
                Book book =BookDAO.getSingleProduct(pId);
             
                order.setOrderId(rs.getInt("order_id"));
                order.setId(pId);
                order.setName(book.getName());
//                order.setCategory(book.getCategory());
//                order.setPrice());
                order.setQunatity(rs.getInt("o_quantity"));
                order.setDate(rs.getString("o_date"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return list;
    }

    public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from orders where o_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
    
    
    
    
    public static List<Order> viewIssuedBooks(){
		List<Order> list=new ArrayList<Order>();
		try{
			//Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_issuebook order by issueddate desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Book bean=new Book();
//				bean.setCallno(rs.getString("callno"));
//				bean.setStudentid(rs.getString("studentid"));
//				bean.setStudentname(rs.getString("studentname"));
//				bean.setStudentmobile(rs.getLong("studentmobile"));
//				bean.setIssueddate(rs.getDate("issueddate"));
//				bean.setReturnstatus(rs.getString("returnstatus"));
				
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}

}

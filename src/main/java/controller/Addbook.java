package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import dao.BookDAO;
import model.Book;

@WebServlet("/Addbook")
public class Addbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		System.out.println("add book in post");
		response.setContentType("text/html");
		Book book = new Book();
		
//		Part filePart = request.getPart("files");
//		String fileName =  Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		book.setTitle(request.getParameter("title"));
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String publisher = request.getParameter("publisher");
//		String squantity = request.getParameter("quantity");
//		int quantity = Integer.parseInt(squantity);
		
		book.setAuthor(author);
		book.setPrice(price);
		book.setDescription(description);
		book.setDescription(description);
		book.setPublisher(publisher);
		//book.setQuantity(quantity);
		
		
		
   System.out.println(author);
         InputStream inputStream = null;
	Part file = request.getPart("image");
//		
//		
	//String image = Paths.get( file.getSubmittedFileName().getFileName().toString() );
//		
//
//	String image= extractFileName(file);
//	System.out.println("image"+image);
//
//	book.setImage(image);
//		System.out.println("Selected Image File Name : " + image);
//
//		String uploadPath = "C:/Users/SWARNENDU MONDAL/Documents/LibraryManagementSystem/LibraryManagementSystem/src/main/webapp/img"
//				+ image;
//
//		try {
//
//			FileOutputStream fos = new FileOutputStream(uploadPath);
//			InputStream is = file.getInputStream();
//
//			byte[] data = new byte[is.available()];
//			is.read(data);
//			fos.write(data);
//			fos.close();
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	        Part filePart = request.getPart("image");
//	        if (filePart != null) {
//	            // prints out some information for debugging
//	            System.out.println(filePart.getName());
//	            System.out.println(filePart.getSize());
//	            System.out.println(filePart.getContentType());
//
//	            //obtains input stream of the upload file
//	            //the InputStream will point to a stream that contains
//	            //the contents of the file
//	            inputStream = filePart.getInputStream();
//	        }
//	        book.setFileBytes(IOUtils.toByteArray(inputStream);
//	        
//	        
//	        
//
////	        Connection conn = null; // connection to the database
////	        String message = null; // message will be sent back to client
////	        try {
////	            // connects to the database
////	            conn = getConnection();
////	            // constructs SQL statement
////	            String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
////	            //Using a PreparedStatement to save the file
////	            PreparedStatement pstmtSave = conn.prepareStatement(sql);
////	            pstmtSave.setString(1, firstName);
////	            pstmtSave.setString(2, lastName);
////
////	            if (inputStream != null) {
////	                
////	                pstmtSave.setBlob(3, inputStream);
////	            }
////	            //sends the statement to the database server
////	            int row = pstmtSave.executeUpdate();
////	            if (row > 0) {
////	                message = "File uploaded and saved into database";
////	            }
//	            
//	            
//	            
//	            
//
//	            String filepath = "D:/Dev/JavaWorkSpaceNew/FileUploadDatabase/WebContent/FromDb.jpg";
//	            //Obtaining the file from database
//	            //Using a second statement
//	            String sql1 = "SELECT photo FROM contacts WHERE first_name=? AND last_name=?";
//	            PreparedStatement pstmtSelect = conn.prepareStatement(sql1);
//	            pstmtSelect.setString(1, firstName);
//	            pstmtSelect.setString(2, lastName);
//	            ResultSet result = pstmtSelect.executeQuery();
//	            if (result.next()) {
//	                Blob blob = result.getBlob("photo");
//	                InputStream inputStream1 = blob.getBinaryStream();
//	                OutputStream outputStream = new FileOutputStream(filepath);
//	                int bytesRead = -1;
//	                byte[] buffer = new byte[BUFFER_SIZE];
//	                while ((bytesRead = inputStream1.read(buffer)) != -1) {
//	                    outputStream.write(buffer, 0, bytesRead);
//	                }
//	                inputStream1.close();
//	                outputStream.close();
//	                System.out.println("File saved");
//	            }
//	        } catch (SQLException ex) {
//	            message = "ERROR: " + ex.getMessage();
//	            ex.printStackTrace();
//	        } finally {
//	            if (conn != null) {
//	                // closes the database connection
//	                try {
//	                    conn.close();
//	                } catch (SQLException ex) {
//	                    //silent
//	                }
//	            }
//	            // sets the message in request scope
//	            request.setAttribute("message", message);
//
//	            // forwards to the message page
//	            getServletContext().getRequestDispatcher("/Message.jsp")
//	                .include(request, response);
//	        }
//	    }
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//         book.set
		// BookDAO srd = new BookDAO();
//		String result = null;
//		try {
//			result = BookDAO.save(book);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (result == "Success") {
////					out.print(student.getFirstName() + " inserted succesfully into the database!");
//			// response.sendRedirect(request.getContextPath()+"/Login.jsp");
//			// out.println("<h3>Book saved successfully</h3>");
//		}
//
//		else {
//			// out.print("Somthing went wrong!!");
//		}
//
//		request.getRequestDispatcher("addBookAdmin.jsp").include(request, response);
//
//	}

}
}
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.BookDAO"%>
<%@page import="model.Book"%>
<%@page import="model.Cart"%>

<%@page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/includes/head.jsp"%>
</head>
<%


%>

<body>
	<jsp:include page="nevber.jsp" />

	<div class="container">
		<div class="card-header my-3">All Books</div>
		
		<div class="row">
			<%
			BookDAO bk = new BookDAO();
			String ch=request.getParameter("ch");
			//System.out.println(ch);
			List<Book> books = bk.search(ch);
			System.out.println(books);
			if (!books.isEmpty()) 
			{
				for (Book b : books) {
            //System.out.println("from jsp page: "+b.getName());
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
				<img class="card-img-top" src="img/men-suits.jpg"
				alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Author -<%=b.getAuthor()%></h5>
						<h6 class="price">
							Title - <%=b.getTitle()%></h6>
						<h6 class="category">
							Publisher
							<%=b.getPublisher()%></h6>
							<h6 class="category">
							Description -
							<%=b.getDescription()%></h6>
						<div class="mt-3 d-flex justify-content-between">
						
						<!--<form action="AddToCart"  method="post">
						
            
                         <input type="hidden"   name="book_id" value=<%=b.getId()%>>
                                   
							<button  type="submit" class="btn btn-dark" >Add to Cart</button>
						</form>
						-->
						
						<a class="btn btn-dark" href="AddToCart?id=<%=b.getId()%>">Add to Cart</a> 
							 <a
								class="btn btn-primary" >Read More</a>
						</div>
						
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no Book");
			}
			%>

		</div>
	</div>


</body>
</html>
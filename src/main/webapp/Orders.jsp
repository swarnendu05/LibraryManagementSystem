<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.BookDAO"%>
<%@page import="dao.*"%>
<%@page import="model.Book"%>
<%@page import="model.Order"%>
<%@page import="model.*"%>

<%@page import="java.util.*"%>

<%
Student auth = (Student) session.getAttribute("auth");


if (auth != null) {
	
	
	
}
else{
	response.sendRedirect("login.jsp");
}



ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
	<jsp:include page="nevber.jsp" />
	<br>
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">BookId</th>
					<th scope="col">Title</th>
					<th scope="col">Author</th>
					<th scope="col">Buy</th>
					<th scope="col">Remove</th>
				</tr>
			</thead>
			<tbody>

				
				<tr>
					
					
					
					
					
					
				</tr>
				

			</tbody>
		</table>
	</div>
	
</body>
</html>
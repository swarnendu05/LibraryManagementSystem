<%@page import="javax.imageio.plugins.tiff.GeoTIFFTagSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.BookDAO"%>
<%@page import="model.*"%>
<%@page import="model.Cart"%>


<%@page import="java.util.*"%>

<%@page import="java.text.DecimalFormat"%>
<%

%>
<%
						
DecimalFormat dcf = new DecimalFormat("#.##");
//request.setAttribute("dcf", dcf);

Student auth = (Student) session.getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
    
}
else{
	response.sendRedirect("login.jsp");
}



ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	BookDAO pDao = new BookDAO();
	cartProduct = pDao.getCartProducts(cart_list);
     request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>

<title>E-Commerce Cart</title>
<style type="text/css">
.table tbody td {
	vertical-align: middle;
}

.btn-incre, .btn-decre {
	box-shadow: none;
	font-size: 25px;
}
</style>
</head>
<body>
	<jsp:include page="nevber.jsp" />
 <br>

	<div class="container my-3">
		<div class="d-flex py-3"></div>
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
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getId()%></td>
					<td><%=c.getAuthor()%></td>
					<td><%=c.getTitle()%></td>
					<td>
						<form action="OrderNow" method="post" class="form-inline">
						  <input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
						  <input type="hidden" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="RemoveFromCart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>


</body>
</html>
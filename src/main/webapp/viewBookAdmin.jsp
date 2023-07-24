<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.BookDAO"%>
<%@page import="model.Book"%>
<%@page import="model.Cart"%>

<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='bootstrap.min.css' />
</head>
<%
BookDAO bk = new BookDAO();
List<Book> books = bk.view();
//System.out.println("from jsp page1: " + books);
%>

<body>

	<div class="container my-3">
		<div class="d-flex py-3"></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">BookName</th>
					<th scope="col">Title</th>
					<th scope="col">Author</th>
					<th scope="col">Delete</th>
					<th scope="col">Update</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (!books.isEmpty()) {
					for (Book b : books) {
						//System.out.println("from jsp page.....: " + b.getAuthor());
				%>
				<tr>
					<td><%=b.getId()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getTitle()%></td>
					<td><a href="DeleteBook?id=<%=b.getId()%>"
						class="btn btn-sm btn-danger">Delete</a></td>
					<td><a href=""=<%=b.getId()%>"
						class="btn btn-sm btn-danger">Edit</a></td>
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
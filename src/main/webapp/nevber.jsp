<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Student"%>
    <%@page import="java.util.*"%>
    <%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Library Management System</title>
  <link rel="stylesheet" href="homStyle.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
</head>

<body>
<%
String userName = (String) session.getAttribute("userName");
Student auth = (Student) session.getAttribute("auth");

%>
  <nav class="navbar navbar-expand-lg fixed-top bg-body-primary bg-dark-subtle">
    <div class="container-fluid">
      <a class="navbar-brand" href="index.jsp">
        <img src="./img/logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top" />
        Books Bank
      </a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse text-dec" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          
          <li class="nav-item">
            <a class="nav-link active" href="/">About us</a>
          </li>
          <%
				if (auth != null) {
				%>
         
          <li class="nav-item">
            <a class="nav-link active" href="Orders.jsp">Borrowed Book</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="cart.jsp">Cart <span class="badge badge-danger">${cart_list.size()}</span></a>
          </li>
          
          <%
				}
				%>
          
          
        </ul>
        <div class="d-flex flex-row" >
        
        <div >
        <form  role="search" class=" d-flex flex-row"  method="post"  action="search.jsp">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="ch" />
          <button class="btn btn-outline-success" type="submit">
            Search
          </button>
        </form>
        </div>
        <div class="mx-3">

		<%
		if(auth != null) {
			%>
			<div class="d-flex flex-row space justify-content-between" style="width: 200px;">
		
		<form>
		<button class="btn btn-secondary" >
		<a href ="Logout">Logout</a>
		</button>
		</form>
		</div>
		<%
		}
		else {
			%>
			

        <div class="dropdown d-flex flex-row">
        <div>
            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
              Login
            </button>
            <ul class="dropdown-menu">
             
                 <li><a href="login.jsp"> <button class="dropdown-item" type="button" >Login</button></a></li>
             
                <li><a href ="adminLogin.jsp"><button class="dropdown-item" type="button" >Admin Login</button></a></li>
             
             
            </ul>
          </div>
        
        <a href="Reg.jsp"> <button class="btn btn-danger mx-1">SignUp</button></a>
        <%
			}
		%>
		</div>
      </div>
      </div>
    </div>

  </nav>
  
  <style>
    nav .text-dec{
   font-size: large;
   font-weight:600;
   font-stretch: condensed;
 }
  </style>


      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>

</html>
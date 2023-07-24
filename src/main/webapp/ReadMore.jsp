<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="dao.BookDAO"%>
<%@page import="model.Book"%>
<%@page import="model.Cart"%>

<%@page import="java.util.*"%>  
    
    <%
BookDAO bk = new BookDAO();
List<Book> books = bk.view();
//System.out.println("from jsp page1: " + books);
%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./css/readMore.css" />
    <title>readMore</title>
  </head>
  <body>
    <div class="main-div">
      <div class="f-div">
        <img src="./1.png" alt="c++ book" srcset="" />
      </div>

      <div class="col-md-4 details">
        <h2>Heading</h2>
        <p>
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Pariatur
          ducimus laborum eos at vero vel voluptates? Enim non eos atque magni
          quibusdam quod iure, pariatur optio, officia similique ex deleniti.
          Provident amet repellat voluptatem blanditiis earum voluptatibus nam
          metus. Fusce dapibus,
          tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
          massa justo sit amet risus. Etiam porta sem malesuada magna mollis
          euismod. Donec sed odio dui.
        </p>
        <p>
          <a class="btn btn-secondary" href="#" role="button">Order »</a>
          <a class="btn btn-secondary" href="#" role="button">View details »</a>
        </p>
      </div>
    </div>
  </body>
</html>

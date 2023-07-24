<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Student"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="../css/admin.css">
</head>
<body>
<body>
<jsp:include page="nevber.jsp" />
	<%!
	Student st = new Student();%>

	<div id="login">
		<h3 class="text-center text-white pt-5"> Admin Login form</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<%
						if (request.getAttribute("error") != null) {
						%>
						<b><%= request.getAttribute("error") %></b>
						<%
						}
						%>

						<form id="login-form" class="form" action="AdminLog" method="post">
							<h3 class="text-center text-info">Admin Login</h3>

							<div class="form-group">
								<label for="username" class="text-info">UserName:</label><br>
								<input type="text" name="username" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="text" name="password" id="password"
									class="form-control">
							</div>
							<div class="form-group">
								<br> <input type="submit"
									name="submit" class="btn btn-info btn-md" value="submit">
							</div>

							




						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</body>
</html>


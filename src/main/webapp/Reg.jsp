<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Your Forms</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
    
   <div class="registration-form">
        <form  action="RegisterServlet"  method="post" >
            <div class="form-icon">
                <span><i class="icon icon-user"></i></span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" name="firstName" placeholder="First name" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" name="lastName" placeholder="Last name" required>
            </div>
            
            <div class="form-group">
                <input type="text" class="form-control item" name="email" placeholder="Email" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" name="phone-number" placeholder="Phone Number" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" name="roll-number" placeholder="Roll-number" required>
            </div>

            <div class="form-group form-control item">
                <label for="gender">Choose your Gender:</label>
                <input type="radio" name="gender" value="male"> Male
                   <input type="radio" name="gender" value="female"> Female
                   <input type="radio" name="gender" value="others"> others
            </div>

            <div class="form-group form-control item" name="lastAdd" required>
                <label for="course">Choose a course:</label>

                   <select name="course" id="course" required>
                    <option value="defult">Select a course</option>
                      <option value="B.Tech">B.Tech</option>
                      <option value="M.Tech">M.Tech</option>
                      <option value="Diploma">Diploma</option>
                      <option value="MBA">MBA</option>
                    </select>
            </div>
            <div class="form-group">
                <input type="password" class="form-control item" name="password" placeholder="Password" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-block create-account">Create Account</button>
            </div>
            <div>
            <p> Already have an account? <a href ="login.jsp">Login hear</a></p>
            	
            </div>
           
        </form>
      
    </div>
   
</body>
</html>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
       <div>
            <h1 class="h">Book ADD</h1>
        </div>

      <div class="registration-form">
        <form  action="Addbook"  method="post" enctype="multipart/form-data">
            
            <div class="form-group">
                <input type="text" class="form-control item" name="title" placeholder="title" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" name="author" placeholder="Author" required>
            </div>
            
            <div class="form-group">
                <input type="number" class="form-control item" name="price" placeholder="price" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" name="description" placeholder="Description" required>
            </div>
            <div class="form-group">
                <input type="number" class="form-control item" name="quantity" placeholder="quentity" required>
            </div>

            <div class="form-group">
                <input type="text" class="form-control item" name="publiser" placeholder="publiser" required>
            </div>
            

            
            <div class="form-group">
                <label for="exampleFormControlFile1">photo</label>
                <input type="file" name="image" class="form-control-file" id="exampleFormControlFile1"> 
              </div>
            <div class="form-group">
                <button type="submit" class="btn btn-block create-account">Add the book</button>
            </div>
            <div>
                
            </div>
           
        </form>
      
    </div>
 <style>
    .h{
        text-align: center;

    }
 .registration-form{
	padding: 50px 0;
}

.registration-form form{
    background-color: #fff;
    max-width: 600px;
    margin: auto;
    padding: 50px 70px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}

.registration-form .form-icon{
	text-align: center;
    background-color: #5891ff;
    border-radius: 50%;
    font-size: 40px;
    color: white;
    width: 100px;
    height: 100px;
    margin: auto;
    margin-bottom: 50px;
    line-height: 100px;
}

.registration-form .item{
	border-radius: 20px;
    margin-bottom: 25px;
    padding: 10px 20px;
}

.registration-form .create-account{
    border-radius: 30px;
    padding: 10px 20px;
    font-size: 18px;
    font-weight: bold;
    background-color: #5791ff;
    border: none;
    color: white;
    margin-top: 20px;
}
</style>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
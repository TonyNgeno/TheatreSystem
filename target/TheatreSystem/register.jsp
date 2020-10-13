<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/stylo.css" rel="stylesheet" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
  <div class="sidenav">
           <div class="login-main-text">
              <h2>Application<br> Registration Page</h2>
              <p>Please Register from here to access.</p>
           </div>
        </div>
        <div class="main">
           <div class="col-md-6 col-sm-12">
              <div class="login-form">
                 <form method = "post" action="userDetail">
                     <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control" name="firstname" required placeholder="First Name">
                     </div>
                     <div class="form-group">
                        <label>Other Names</label>
                        <input type="text" class="form-control" name="otherNames" required placeholder="Other Names">
                     </div>
                     <div class="form-group">
                        <label>User Name</label>
                        <input type="text" class="form-control" name="username" required placeholder="User Name">
                     </div>

                    <div class="form-group">
                       <label>Id Number</label>
                       <input type="text" class="form-control" name="idNo" required placeholder="Id Number">
                    </div>
                    <div class="form-group">
                        <label>Enter Your Email</label>
                        <input type="text" class="form-control" name="email" required placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label>Your Home Address</label>
                        <input type="text" class="form-control" name="address" required placeholder="Enter Home Address">
                    </div>
                    <div class="form-group">
                        <label>Phone Number</label>
                        <input type="text" class="form-control" name="phoneNo" required placeholder="Phone Number ">
                    </div>
                     <div class="form-group">
                        <label>User Role</label>
                        <input type="text" class="form-control" name="role" required placeholder="Enter Your Role">
                     </div>
                    <div class="form-group">
                       <label>Password</label>
                       <input type="password" class="form-control" name="password" required placeholder="Password">
                    </div>
                    <div class="form-group">
                       <label>Confirm Password</label>
                       <input type="password" class="form-control" name="confirmpassword" required placeholder="Password">
                    </div>
                    <button type="submit" name="btnSubmit" class="btn btn-black">Register</button>
                   <a href="login.jsp" class="tag">Login Here</a>
                 </form>
              </div>
           </div>
        </div>
</body>
</html>

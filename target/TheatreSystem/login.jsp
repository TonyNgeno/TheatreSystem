<!DOCTYPE html>
<html>
<head>
<title>Login</title>
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
              <h2>Application<br> Login Page</h2>
              <p>Login from here to access.</p>
           </div>
        </div>
        <div class="main">
           <div class="col-md-6 col-sm-12">
              <div class="login-form">
                 <form  method = "post" action="loginUser">
                    <div class="form-group">
                       <label>User Name</label>
                       <input type="text" class="form-control" name="username" placeholder="User Name">
                    </div>
                    <div class="form-group">
                       <label>Password</label>
                       <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>

                    <button type="submit" name="btnSubmit" class="btn btn-black">Login</button>

                   <a href="register.jsp" class="tag">Register Here</a>

                 </form>
              </div>
           </div>
        </div>
</body>
</html>

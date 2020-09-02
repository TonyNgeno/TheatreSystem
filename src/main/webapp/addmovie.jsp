<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
 <%@ include file="./page/navbar.jsp" %><br>

   <form method="post" action="insertRooms">
   <div class = "container">
   <h1 align="center"> Add A Room<h1><br>
     <div class="form-group">
       <label for="InputName" class="grey-text font-weight-light">Movie Name</label>
       <input type="text" class="form-control" name="name" placeholder="Enter Movie Name">
     </div>

     <div class="form-group">
       <label for="InputSeats" class="grey-text font-weight-light">Enter Seats</label>
       <input type="text" class="form-control" name="noOfSeats" placeholder="Enter Seats">
     </div>
     <button type="submit" class="btn btn-primary">Submit</button>

   </form>
   </div>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
 <%@ include file="./page/navbar.jsp" %><br>

   <div class = "container">
   <div class="card">
   <div class="card-body px-lg-5 pt-0">
       <h5 class="card-header info-color white-text text-center py-4">
           <strong>Add Movie</strong>
       </h5>
   <form method="post" action="addMovie" >
     <div class="form-group">
       <label for="InputName" class="grey-text font-weight-light">Movie Name</label>
       <input type="text" class="form-control" name="name" placeholder="Enter Movie Name">
     </div>

     <div class="form-group">
       <label for="InputDescription" class="grey-text font-weight-light">Enter Description</label>
       <input type="text" class="form-control" name="description" placeholder="Description">
     </div>

     <div class="form-group">
        <label for="Image" class="grey-text font-weight-light">Enter Image</label><br>
        <input type="file" name="photo" id="photo"
     </div><br><br>

     <button type="submit" class="btn btn-primary">Submit</button>

   </form>
   </div>
   </div>
   </div>
</body>
</html>

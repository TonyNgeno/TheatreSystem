<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
 <%@ include file="./page/navbar.jsp" %><br>

   <form method="post" action="insertSchedule">
   <div class = "container">
   <h1 align="center"> Add A Schedule<h1><br>
     <div class="form-group">
      <label for="movieName">Choose a Movie:</label>
      <select name="movieName" id="movieName">
        <option value="volvo">Volvo</option>
        <option value="saab">Saab</option>
        <option value="mercedes">Mercedes</option>
        <option value="audi">Audi</option>
      </select>
     </div>

     <div class="form-group">
       <label for="InputStartTime" class="grey-text font-weight-light">Start Time</label>
       <input type="time" class="form-control" name="startTime" placeholder="Enter Start Time">
     </div>

     <div class="form-group">
       <label for="InputEndTime" class="grey-text font-weight-light">End Time</label>
       <input type="time" class="form-control" name="endTime" placeholder="Enter End Time">
     </div>

     <div class="form-group">
       <label for="InputDate" class="grey-text font-weight-light">Date</label>
       <input type="date" class="form-control" name="date" placeholder="Enter Date">
     </div>

     <div class="form-group">
        <label for="InputCinemaRoom" class="grey-text font-weight-light">Enter Cinema Room</label>
        <input type="text" class="form-control" name="cinemaRoomName" placeholder="Enter Cinema Room">
     </div>



     <button type="submit" class="btn btn-primary">Submit</button>

   </form>
   </div>
</body>
</html>

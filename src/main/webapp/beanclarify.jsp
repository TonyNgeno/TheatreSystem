<!DOCTYPE html>
<html>
  <body>
      <jsp:useBean id= "user" class = "com.theatre.model.User" />
      <jsp:setProperty name= "user" property = "*"  />
      Name : <jsp:getProperty name= "user" property = "name" /><br/>
      Address: <jsp:getProperty name= "user" property = "address" /><br/>
      Email: <jsp:getProperty name= "user" property = "email" /><br/>
      Password: <jsp:getProperty name= "user" property = "password" /><br/>


      <form action = "#" method ="post">
        Name: <input type = "text" name= "name">
        Address: <input type = "text" name= "address">
        Email: <input type = "text" name= "email">
        Pasword: <input type = "password" name= "password">
        <input type = "submit" value= "Submit">
      </form>


  </body>
</html>
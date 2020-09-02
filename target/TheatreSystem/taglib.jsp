<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
    <body>
        <form action = "#" method= "post">
            Email:<input type = "text" name ="email"/>
            <input type = "submit" value ="submit"/>
        </form>

        <c:out value = "${param.email}"/>
        <c:set var = "exampleVar" value= "${param.email}" />
        <c:out value = "${exampleVar}"/>

    </body>
</html>
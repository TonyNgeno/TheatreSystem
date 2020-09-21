<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.theatre.utilities.*" %>
<%@page import="com.theatre.*" %>
<%@page import="com.theatre.servlet.*" %>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Booking Form</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
<%@ include file="./page/navbar.jsp" %>
 <div class="container-fluid">
	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="col-md-7 col-md-push-5">
						<div class="booking-cta">
							<h1>Make your Booking</h1>

						</div>
					</div>

					<div class="col-md-4 col-md-pull-7">
						<div class="booking-form">
							<form method="post" action="bookings">
							<div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <span class="form-label">User Name</span>
                                        <input class="form-control" type="text" name="username" required>
                                    </div>
                                </div>
                            </div>
                            	<div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <span class="form-label">Phone Number</span>
                                            <input class="form-control" type="text" name = "phoneNo" required>
                                        </div>
                                    </div>
                                </div>
								<div class="form-group">
									<span class="form-label">Movie Name</span>
										<select name = "movieName" class="form-control">
                                 <%
                                    Context context1 = new InitialContext();
                                    DataSource dataSource1 = (DataSource)context1.lookup("java:jboss/datasources/TheatreDS");
                                    try
                                    {
                                        Connection connection1 = dataSource1.getConnection();
                                        String query = "Select * from movieschedules";
                                        Statement statement1 = connection1.createStatement();
                                        ResultSet result1 = statement1.executeQuery(query);
                                        while(result1.next())
                                        {
                                        %>
                                            <option value="<%=result1.getString("movieName")%>"><%=result1.getString("movieName")%></option>
                                        <%
                                        }
                                    }
                                    catch(Exception ex)
                                        {
                                            out.println("Exception:" +ex.getMessage());
                                            ex.printStackTrace();
                                        }
                                 %>
                                </select>
                                <span class="select-arrow"></span>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<div class="form-group">
											<span class="form-label">Cinema Room</span>
											<select name = "cinemaRoomName" class="form-control">
                                             <%
                                                Context context2 = new InitialContext();
                                                DataSource dataSource2 = (DataSource)context2.lookup("java:jboss/datasources/TheatreDS");
                                                try
                                                {
                                                    Connection connection2 = dataSource2.getConnection();
                                                    String query = "Select * from rooms";
                                                    Statement statement2 = connection2.createStatement();
                                                    ResultSet result2 = statement2.executeQuery(query);
                                                    while(result2.next())
                                                    {
                                                    %>
                                                        <option value="<%=result2.getString("name")%>"><%=result2.getString("name")%></option>
                                                    <%
                                                    }
                                                }
                                                catch(Exception ex)
                                                    {
                                                        out.println("Exception:" +ex.getMessage());
                                                        ex.printStackTrace();
                                                    }
                                             %>
											</select>
											<span class="select-arrow"></span>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<span class="form-label">Adults</span>
											<select name = "adultNo"  class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
											<span class="select-arrow"></span>
										</div>
									</div>
									<div class="col-sm-4">
                                        <div class="form-group">
                                            <span class="form-label">Children</span>
                                            <select name = "childrenNo" class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                            <span class="select-arrow"></span>
                                        </div>
                                    </div>
                                </div>
								<div class="form-btn">
									<button type="submit" class="submit-btn">Make Booking</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
 </div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
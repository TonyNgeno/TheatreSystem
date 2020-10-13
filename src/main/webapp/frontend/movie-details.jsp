<%@page import="java.sql.*" %>
<%@page import="com.theatre.utilities.*" %>
<%@page import="com.theatre.*" %>
<%@page import="com.theatre.servlet.*" %>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>
<%@ include file="header.jsp" %><br>
<!DOCTYPE html>
<html lang="en">

      <%@ include file="header.jsp" %><br>
<body>
         <%@ include file="navbartop.jsp" %><br>

    <!-- ==========Banner-Section========== -->
    <section class="details-banner bg_img" data-background="./assets/images/banner/banner03.jpg">
        <div class="container">
            <div class="details-banner-wrapper">
                <div class="details-banner-thumb">
                    <img src="./assets/images/movie/venus.jpg" alt="movie">
                    <a href="https://www.youtube.com/embed/KGeBMAgc46E" class="video-popup">
                        <img src="./assets/images/movie/video-button.png" alt="movie">
                    </a>
                </div>
                 <%
                     String id = request.getParameter("id");
                     try
                     {
                        Context context = new InitialContext();
                        DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
                        Connection connection = dataSource.getConnection();
                        String query = "Select * from movies where id="+id;
                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(query);
                        while(result.next())
                         {

                         %>
                <div class="details-banner-content offset-lg-3">
                    <h3 class="title"><%=result.getString("movieName")%></h3>
                    <div class="social-and-duration">
                        <div class="duration-area">
                            <div class="item">
                          <%

                             try
                             {

                                String query1 = "Select * from movieschedules where id ="+id;
                                Statement statement1 = connection.createStatement();
                                ResultSet result1 = statement1.executeQuery(query1);
                                while(result1.next())
                                 {

                             %>
                                <i class="fas fa-calendar-alt"></i><%=result1.getString("date")%></span>
                                 <%

                                    }
                                    }

                                    catch(Exception ex)
                                    {
                                        out.println("Exception:" +ex.getMessage());
                                        ex.printStackTrace();
                                    }

                                %>
                            </div>
                            <div class="item">
                                <i class="far fa-clock"></i><span><%=result.getString("movieLength")%>mins</span>
                            </div>
                        </div>
                        <ul class="social-share">
                            <li><a href="#0"><i class="fab fa-facebook-f"></i></a></li>
                            <li><a href="#0"><i class="fab fa-twitter"></i></a></li>
                            <li><a href="#0"><i class="fab fa-pinterest-p"></i></a></li>
                            <li><a href="#0"><i class="fab fa-linkedin-in"></i></a></li>
                            <li><a href="#0"><i class="fab fa-google-plus-g"></i></a></li>
                        </ul>
                    </div>
                </div>

            </div>

        </div>
    </section>
    <!-- ==========Banner-Section========== -->

    <!-- ==========Book-Section========== -->
    <section class="book-section bg-one">
        <div class="container">
            <div class="book-wrapper offset-lg-3">
                <div class="left-side">

                </div>
                <a href="movie-seat-plan.jsp" class="custom-button">book tickets</a>
            </div>
        </div>
    </section>
    <!-- ==========Book-Section========== -->

    <!-- ==========Movie-Section========== -->
    <section class="movie-details-section padding-top padding-bottom">
        <div class="container">
            <div class="row justify-content-center flex-wrap-reverse mb--50">
                <div class="col-lg-9 mb-50">
                    <div class="movie-details"><br><br>
                        <h3 class="title">photos</h3>
                        <div class="details-photos owl-carousel">
                            <div class="thumb">
                                <a href="./assets/images/movie/movie-details01.jpg" class="img-pop">
                                    <img src="./assets/images/movie/movie-details01.jpg" alt="movie">
                                </a>
                            </div>
                            <div class="thumb">
                                <a href="./assets/images/movie/movie-details02.jpg" class="img-pop">
                                    <img src="./assets/images/movie/movie-details02.jpg" alt="movie">
                                </a>
                            </div>
                            <div class="thumb">
                                <a href="./assets/images/movie/movie-details03.jpg" class="img-pop">
                                    <img src="./assets/images/movie/movie-details03.jpg" alt="movie">
                                </a>
                            </div>
                            <div class="thumb">
                                <a href="./assets/images/movie/movie-details01.jpg" class="img-pop">
                                    <img src="./assets/images/movie/movie-details01.jpg" alt="movie">
                                </a>
                            </div>
                            <div class="thumb">
                                <a href="./assets/images/movie/movie-details02.jpg" class="img-pop">
                                    <img src="./assets/images/movie/movie-details02.jpg" alt="movie">
                                </a>
                            </div>
                            <div class="thumb">
                                <a href="./assets/images/movie/movie-details03.jpg" class="img-pop">
                                    <img src="./assets/images/movie/movie-details03.jpg" alt="movie">
                                </a>
                            </div>
                        </div>
                        <div class="tab summary-review">

                            <div class="tab-area">
                                <div class="tab-item active">
                                    <div class="item">
                                        <h5 class="sub-title">Synopsis</h5>
                                        <p><%=result.getString("description")%></p>
                                    </div>
                                       <%

                                                        }
                                                        connection.close();
                                                    }

                                                    catch(Exception ex)
                                                    {
                                                        out.println("Exception:" +ex.getMessage());
                                                        ex.printStackTrace();
                                                    }

                                                  %>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ==========Movie-Section========== -->



    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/modernizr-3.6.0.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/isotope.pkgd.min.js"></script>
    <script src="assets/js/magnific-popup.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <script src="assets/js/countdown.min.js"></script>
    <script src="assets/js/odometer.min.js"></script>
    <script src="assets/js/viewport.jquery.js"></script>
    <script src="assets/js/nice-select.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>
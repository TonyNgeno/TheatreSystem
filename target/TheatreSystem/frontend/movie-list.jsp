<!DOCTYPE html>
<html lang="en">
<%@page import="java.sql.*" %>
<%@page import="com.theatre.utilities.*" %>
<%@page import="com.theatre.*" %>
<%@page import="com.theatre.servlet.*" %>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.annotation.Resource" %>
<%@page import="javax.naming.*" %>
<%@ include file="header.jsp" %><br>

<body>
      <%@ include file="navbar.jsp" %><br>
    <!-- ==========Movie-Section========== -->
    <section class="movie-section padding-top padding-bottom">
        <div class="container">
            <div class="row flex-wrap-reverse justify-content-center">
                <div class="col-sm-10 col-md-8 col-lg-3">
                    <div class="widget-1 widget-check">
                        <div class="widget-header">
                            <h5 class="m-title">Filter By</h5> <a href="#0" class="clear-check">Clear All</a>
                        </div>
                        <div class="widget-1-body">
                            <h6 class="subtitle">Language</h6>
                            <div class="check-area">
                                <div class="form-group">
                                    <input type="checkbox" name="lang" id="lang4"><label for="lang4">English</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="widget-1 widget-check">
                        <div class="widget-1-body">
                            <h6 class="subtitle">experience</h6>
                            <div class="check-area">
                                <div class="form-group">
                                    <input type="checkbox" name="mode" id="mode1"><label for="mode1">2d</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="mode" id="mode2"><label for="mode2">3d</label>
                                </div>
                            </div>
                            <div class="add-check-area">
                                <a href="#0">view more <i class="plus"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="widget-1 widget-check">
                        <div class="widget-1-body">
                            <h6 class="subtitle">genre</h6>
                            <div class="check-area">
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre1"><label for="genre1">thriller</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre2"><label for="genre2">horror</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre3"><label for="genre3">drama</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre4"><label for="genre4">romance</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre5"><label for="genre5">action</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre6"><label for="genre6">comedy</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre7"><label for="genre7">romantic</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre8"><label for="genre8">animation</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre9"><label for="genre9">sci-fi</label>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="genre" id="genre10"><label for="genre10">adventure</label>
                                </div>
                            </div>
                            <div class="add-check-area">
                                <a href="#0">view more <i class="plus"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="widget-1 widget-banner">
                        <div class="widget-1-body">
                            <a href="#0">
                                <img src="./assets/images/sidebar/banner/banner02.jpg" alt="banner">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 mb-50 mb-lg-0">
                    <div class="filter-tab tab">
                        <div class="filter-area">
                            <div class="filter-main">
                                <div class="left">
                                    <div class="item">
                                        <span class="show">Show :</span>
                                        <select class="select-bar">
                                            <option value="12">12</option>
                                            <option value="15">15</option>
                                            <option value="18">18</option>
                                            <option value="21">21</option>
                                            <option value="24">24</option>
                                            <option value="27">27</option>
                                            <option value="30">30</option>
                                        </select>
                                    </div>
                                    <div class="item">
                                        <span class="show">Sort By :</span>
                                        <select class="select-bar">
                                            <option value="showing">now showing</option>
                                            <option value="exclusive">exclusive</option>
                                            <option value="trending">trending</option>
                                            <option value="most-view">most view</option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                        </div>
                         <%

                         try
                         {
                            Context context = new InitialContext();
                            DataSource dataSource = (DataSource)context.lookup("java:jboss/datasources/TheatreDS");
                            Connection connection = dataSource.getConnection();
                            String query = "Select * from movies";
                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(query);
                            while(result.next())
                             {

                             %>
                        <div class="tab-area">
                            <div class="tab-item active">
                                <div class="movie-area mb-10">
                                    <div class="movie-list">
                                        <div class="movie-thumb c-thumb">
                                            <a href="movie-details.jsp" class="w-100 bg_img h-100" data-background="./assets/images/movie/movie01.jpg">
                                                <img class="d-sm-none" src="./assets/images/movie/movie01.jpg" alt="movie">
                                            </a>
                                        </div>

                                        <div class="movie-content bg-one">
                                            <h5 class="title">
                                                <a href="movie-details.jsp?id=<%=result.getString("id")%>"><%=result.getString("movieName")%></a>
                                            </h5>
                                            <p class="duration"><%=result.getString("movielength")%>mins</p>
                                            <div class="movie-tags">


                                            </div>
                                            <div class="release">
                                              <%
                                                 String id=request.getParameter("id");
                                                 try
                                                 {

                                                     String query1 = "Select * from movieschedules where id ="+id;
                                                    Statement statement1 = connection.createStatement();
                                                    ResultSet result1 = statement1.executeQuery(query1);
                                                    while(result1.next())
                                                     {

                                                 %>
                                                        <span>Release Date : </span> <a href="#0"><%=result1.getString("date")%></a>
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

                                            <div class="book-area">
                                                <div class="book-ticket">
                                                    <div class="react-item">
                                                        <a href="#">
                                                            <div class="thumb">
                                                                <img src="./assets/images/icons/heart.png" alt="icons">
                                                            </div>
                                                        </a>
                                                    </div>
                                                    <div class="react-item mr-auto">
                                                        <a href="movie-seat-plan.html">
                                                            <div class="thumb">
                                                                <img src="./assets/images/icons/book.png" alt="icons">
                                                            </div>
                                                            <span>book ticket</span>
                                                        </a>
                                                    </div>
                                                    <div class="react-item">
                                                        <a href="#0" class="popup-video">
                                                            <div class="thumb">
                                                                <img src="./assets/images/icons/play-button.png" alt="icons">
                                                            </div>
                                                            <span>watch trailer</span>
                                                        </a>
                                                    </div>
                                            </div>
                                    </div>
                                </div>
                            </div>
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

                        <div class="pagination-area text-center">
                            <a href="#0"><i class="fas fa-angle-double-left"></i><span>Prev</span></a>
                            <a href="#0">1</a>
                            <a href="#0">2</a>
                            <a href="#0" class="active">3</a>
                            <a href="#0">4</a>
                            <a href="#0">5</a>
                            <a href="#0"><span>Next</span><i class="fas fa-angle-double-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ==========Movie-Section========== -->

<%@ include file="bottomscript.jsp" %><br>
</body>

</html>
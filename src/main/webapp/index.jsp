<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="bootstrap-4.5.2-dist/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="bootstrap-4.5.2-dist/css/simple-sidebar.css" rel="stylesheet">

    <title>50th Century Theatres</title>
</head>
<body>
<%@ include file="./page/navbar.jsp" %>
    <div class="container-fluid">
        <div class="row">

            <!-- Movies Showing Card -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-grey text-uppercase mb-1">Movies Showing Today</div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800">10</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-calendar fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



        <!-- Bookings made Today Card-->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-gray text-uppercase mb-1">Bookings made Today</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">0</div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Halls card -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-gray text-uppercase mb-1">Halls</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">2</div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        </div>

        <div class="row">
            <div class="col-xl-3 col-md-6 mb-4">

                <!-- Next Movies Card Dashboard  -->
                <div class="card mb-4" style="width: 18rem;">
                    <div class="card-header">
                        Next movies
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <p class="text-primary">Batman&Robin</p>
                            <p>20-08-2020, 1355:00</p>
                            <p>0 tickets</p>
                        </li>
                    </ul>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <p class="text-primary">Superman</p>
                            <p>20-08-2020, 1355:00</p>
                            <p>1 tickets</p>
                        </li>
                    </ul>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <p class="text-primary">RobinHood</p>
                            <p>20-08-2020, 1355:00</p>
                            <p>5 tickets</p>
                        </li>
                    </ul>


                </div>
            </div>

            <div class="col-xl-3 col-md-6 mb-4">
                <!-- Latest Bookings Card Dashboard  -->
                <div class="card mb-4" style="width: 18rem;">
                    <div class="card-header">
                        Latest Bookings
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <p class="text-primary">Tony Ngeno</p>
                            <p>20-08-2020, 1355:00</p>
                            <p>0 tickets</p>
                        </li>
                    </ul>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <p class="text-primary">Brian Kibet</p>
                            <p>20-08-2020, 1355:00</p>
                            <p>1 tickets</p>
                        </li>
                    </ul>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <p class="text-primary">Newton Kulundu</p>
                            <p>20-08-2020, 1355:00</p>
                            <p>5 tickets</p>
                        </li>
                    </ul>


                </div>
            </div>



        </div>

    </div>


</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>

</body>
</html>
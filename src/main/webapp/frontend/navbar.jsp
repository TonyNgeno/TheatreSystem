
    <!-- ==========Preloader========== -->
    <div class="preloader">
        <div class="preloader-inner">
            <div class="preloader-icon">
                <span></span>
                <span></span>
            </div>
        </div>
    </div>
    <!-- ==========Preloader========== -->
    <!-- ==========Overlay========== -->
    <div class="overlay"></div>
    <a href="#0" class="scrollToTop">
        <i class="fas fa-angle-up"></i>
    </a>
    <!-- ==========Overlay========== -->

    <!-- ==========Header-Section========== -->
    <header class="header-section">
        <div class="container">
            <div class="header-wrapper">
                <div class="logo">
                    <a href="index.html">
                       50th Century Theatres
                    </a>
                </div>
                <ul class="menu">
                    <li>
                        <a href="index.jsp" class="active">Home</a>
                    </li>
                    <li>
                        <a href="movie-list.jsp">Movies</a>
                    </li>
                    <li>
                    <a href="../index.jsp">Admin</a>
                    </li>
                    <li class="header-button pr-0">
                        <a href="../logoutServlet">Log Out</a>
                    </li>
                </ul>
                <div class="header-bar d-lg-none">
					<span></span>
					<span></span>
					<span></span>
				</div>
            </div>
        </div>
    </header>
    <!-- ==========Header-Section========== -->

    <!-- ==========Banner-Section========== -->
    <section class="banner-section">
        <div class="banner-bg bg_img bg-fixed" data-background="./assets/images/banner/banner01.jpg"></div>
        <div class="container">
            <div class="banner-content">
                <h1 class="title  cd-headline clip"><span class="d-block">book your</span> tickets for
                    <span class="color-theme cd-words-wrapper p-0 m-0">
                        <b class="is-visible">Movie</b>
                    </span>
                </h1>
                <p>Safe, secure, reliable ticketing.Your ticket to live entertainment!</p>
            </div>
        </div>
    </section>
    <!-- ==========Banner-Section========== -->

    <!-- ==========Ticket-Search========== -->
    <section class="search-ticket-section padding-top pt-lg-0">
        <div class="container">
            <div class="search-tab bg_img" data-background="./assets/images/ticket/ticket-bg01.jpg">
                <div class="row align-items-center mb--20">
                    <div class="col-lg-6 mb-20">
                        <div class="search-ticket-header">
                            <h6 class="category">welcome</h6>
                            <h3 class="title">what are you looking for</h3>
                        </div>
                    </div>
                    <div class="col-lg-6 mb-20">
                        <ul class="tab-menu ticket-tab-menu">
                            <li class="active">
                                <div class="tab-thumb">
                                    <img src="./assets/images/ticket/ticket-tab01.png" alt="ticket">
                                </div>
                                <span>movie</span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="tab-area">
                    <div class="tab-item active">
                        <form class="ticket-search-form">
                            <div class="form-group large">
                                <input type="text" id ="search-movie-input" placeholder="Search for A Movie">
                                <button type="submit" id ="search-movie-button"><i class="fas fa-search"></i></button>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/city.png" alt="ticket">
                                </div>
                                <span class="type">city</span>
                                <select class="select-bar">
                                    <option value="london">London</option>
                                    <option value="dhaka">dhaka</option>
                                    <option value="rosario">rosario</option>
                                    <option value="madrid">madrid</option>
                                    <option value="koltaka">kolkata</option>
                                    <option value="rome">rome</option>
                                    <option value="khoksa">khoksa</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/date.png" alt="ticket">
                                </div>
                                <span class="type">date</span>
                                <select class="select-bar">
                                    <option value="26-12-19">23/10/2019</option>
                                    <option value="26-12-19">24/10/2019</option>
                                    <option value="26-12-19">25/10/2019</option>
                                    <option value="26-12-19">26/10/2019</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/cinema.png" alt="ticket">
                                </div>
                                <span class="type">cinema</span>
                                <select class="select-bar">
                                    <option value="Awaken">Awaken</option>
                                    <option value="dhaka">dhaka</option>
                                    <option value="rosario">rosario</option>
                                    <option value="madrid">madrid</option>
                                    <option value="koltaka">kolkata</option>
                                    <option value="rome">rome</option>
                                    <option value="khoksa">khoksa</option>
                                </select>
                            </div>
                        </form>
                    </div>
                    <div class="tab-item">
                        <form class="ticket-search-form">
                            <div class="form-group large">
                                <input type="text" placeholder="Search fo Events">
                                <button type="submit"><i class="fas fa-search"></i></button>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/city.png" alt="ticket">
                                </div>
                                <span class="type">city</span>
                                <select class="select-bar">
                                    <option value="london">London</option>
                                    <option value="dhaka">dhaka</option>
                                    <option value="rosario">rosario</option>
                                    <option value="madrid">madrid</option>
                                    <option value="koltaka">kolkata</option>
                                    <option value="rome">rome</option>
                                    <option value="khoksa">khoksa</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/date.png" alt="ticket">
                                </div>
                                <span class="type">date</span>
                                <select class="select-bar">
                                    <option value="26-12-19">23/10/2019</option>
                                    <option value="26-12-19">24/10/2019</option>
                                    <option value="26-12-19">25/10/2019</option>
                                    <option value="26-12-19">26/10/2019</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/cinema.png" alt="ticket">
                                </div>
                                <span class="type">event</span>
                                <select class="select-bar">
                                    <option value="angular">angular</option>
                                    <option value="startup">startup</option>
                                    <option value="rosario">rosario</option>
                                    <option value="madrid">madrid</option>
                                    <option value="koltaka">kolkata</option>
                                    <option value="Last-First">Last-First</option>
                                    <option value="wish">wish</option>
                                </select>
                            </div>
                        </form>
                    </div>
                    <div class="tab-item">
                        <form class="ticket-search-form">
                            <div class="form-group large">
                                <input type="text" placeholder="Search for Movie">
                                <button type="submit"><i class="fas fa-search"></i></button>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/city.png" alt="ticket">
                                </div>
                                <span class="type">city</span>
                                <select class="select-bar">
                                    <option value="london">London</option>
                                    <option value="dhaka">dhaka</option>
                                    <option value="rosario">rosario</option>
                                    <option value="madrid">madrid</option>
                                    <option value="koltaka">kolkata</option>
                                    <option value="rome">rome</option>
                                    <option value="khoksa">khoksa</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/date.png" alt="ticket">
                                </div>
                                <span class="type">date</span>
                                <select class="select-bar">
                                    <option value="26-12-19">23/10/2019</option>
                                    <option value="26-12-19">24/10/2019</option>
                                    <option value="26-12-19">25/10/2019</option>
                                    <option value="26-12-19">26/10/2019</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <div class="thumb">
                                    <img src="./assets/images/ticket/cinema.png" alt="ticket">
                                </div>
                                <span class="type">sports</span>
                                <select class="select-bar">
                                    <option value="football">football</option>
                                    <option value="cricket">cricket</option>
                                    <option value="cabadi">cabadi</option>
                                    <option value="madrid">madrid</option>
                                    <option value="gadon">gadon</option>
                                    <option value="rome">rome</option>
                                    <option value="khoksa">khoksa</option>
                                </select>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ==========Ticket-Search========== -->



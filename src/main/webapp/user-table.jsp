
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="./css/custom.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
                <div class="navbar-header"> 
                    <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </a>
                    <div class="top-left-part">
                        <a class="logo" href="http://localhost:8080/index">
                            <b>
                                <img src="plugins/images/pixeladmin-logo.png" alt="home" />
                            </b>
                            <span class="hidden-xs">
                                <img src="plugins/images/pixeladmin-text.png" alt="home" />
                            </span>
                        </a>
                    </div>
<%--                    <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">--%>
<%--                        <li>--%>
<%--                            <form role="search" class="app-search hidden-xs">--%>
<%--                                <input type="text" placeholder="Search..." class="form-control" >--%>
<%--                                <a href="">--%>
<%--                                    <i class="fa fa-search"></i>--%>
<%--                                </a>--%>
<%--                            </form>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
                    <ul class="nav navbar-top-links navbar-right pull-right">
                        <li>
                            <div class="dropdown">
                                <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#"> 
                                    <img src="plugins/images/users/${ava}" alt="user-img" width="36" class="img-circle" />
                                    <b class="hidden-xs" style='color:#F6F1F1'>${firstName}</b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="http://localhost:8080/profile">Profiles</a></li>
                                    <li><a href="#">Statistics</a></li>
                                    <li class="divider"></li>
                                    <li><a href="http://localhost:8080/login">Log out</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-header -->
                <!-- /.navbar-top-links -->
                <!-- /.navbar-static-side -->
            </nav>
        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu">
                    <li style="padding: 10px 0 0;">
                        <a href="http://localhost:8080/index" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                                                    aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/usersRoles" class="waves-effect"><i class="fa fa-user fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Member</span></a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/roles" class="waves-effect"><i class="fa fa-modx fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Role</span></a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/jobs" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                        aria-hidden="true"></i><span class="hide-menu">Project</span></a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/tasksStatusJobsUsers" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                   aria-hidden="true"></i><span class="hide-menu">Task</span></a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/blank" class="waves-effect"><i class="fa fa-columns fa-fw"
                                                                    aria-hidden="true"></i><span class="hide-menu">Blank Page</span></a>
                    </li>
                    <li>
                        <a href="404.jsp" class="waves-effect"><i class="fa fa-info-circle fa-fw"
                                                                  aria-hidden="true"></i><span class="hide-menu">Error 404</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Members</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href="http://localhost:8080/user-add"  class="btn btn-sm btn-success">Add</a>
                        <a href="http://localhost:8080/usersRoles"
                           class="btn btn-sm btn-info">Show all</a>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <div class="table-responsive">
                                <table class="table" id="example">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                            <th>Role</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <div class="wrap" >
                                        <div class="search">
                                            <form  >
                                                <input type="text" class="searchTerm" name ="subSearch" placeholder="Find ?">
                                                <button type="submit" class="searchButton">
                                                    <i class="fa fa-search"></i>

                                                </button>
                                            </form >
                                        </div>
                                    </div>
                                    <br>
                                    <tbody>
                                    <% int count = 1;%>
                                        <c:forEach items="${usersRoles}" var="item">
                                            <tr>
                                                <td>${item.getId()}</td>
                                                <td>${item.getFirstName()}</td>
                                                <td>${item.getLastName()}</td>
                                                <td>${item.getUsername()}</td>
                                                <td>${item.getRoleName()}</td>
                                                <td>
                                                    <a href="http://localhost:8080/userChooseEmail"  class="btn btn-sm btn-primary" >Update</a>
                                                    <a href="#" class="btn btn-sm btn-danger btn-xoa" id =${item.getId()} >Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> Copyright &copy; 2023 </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="js/jquery.slimscroll.js"></script>
    <script src="js/jquery.dataTables.js"></script>
    <!--Wave Effects -->
    <script src="js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="js/custom.min.js"></script>
<%--    <script>--%>
<%--        $(document).ready(function () {--%>
<%--            $('#example').DataTable();--%>
<%--        });--%>
<%--    </script>--%>
    <script>
        $(document).ready(function () {
            $('#example').DataTable({
                    "language": {
                        // "sInfo": "Showing _START_ to _END_ of _TOTAL_ entries",
                        "sInfo": "Showing _TOTAL_ entries",
                        "sLengthMenu": "Show _MENU_ entries",
                        "infoFiltered": "",
                        "sInfoEmpty": "Showing 0 entries",


                    },
                    "bFilter":false
                }
            );
        });
    </script>
    <script src="js/user.js"></script>
</body>

</html>

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
                        <a class="logo" href="index.jsp">
                            <b>
                                <img src="plugins/images/pixeladmin-logo.png" alt="home" />
                            </b>
                            <span class="hidden-xs">
                                <img src="plugins/images/pixeladmin-text.png" alt="home" />
                            </span>
                        </a>
                    </div>
                    <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                        <li>
                            <form role="search" class="app-search hidden-xs">
                                <input type="text" placeholder="Search..." class="form-control"> 
                                <a href="">
                                    <i class="fa fa-search"></i>
                                </a>
                            </form>
                        </li>
                    </ul>
                    <ul class="nav navbar-top-links navbar-right pull-right">
                        <li>
                            <div class="dropdown">
                                <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#"> 
                                    <img src="plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle" />
                                    <b class="hidden-xs">Cybersoft</b> 
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
                        <a href="index.jsp" class="waves-effect"><i class="fa fa-clock-o fa-fw"
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
                        <a href="blank.jsp" class="waves-effect"><i class="fa fa-columns fa-fw"
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
                        <h4 class="page-title">Danh sách thành viên</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href="http://localhost:8080/user-add"  class="btn btn-sm btn-success">Thêm mới</a>
<%--                        "role-add.jsp"--%>
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
                                            <th>Hành động</th>
                                        </tr>
                                    </thead>
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
                                                    <a href="http://localhost:8080/user-add" class="btn btn-sm btn-primary">Sửa</a>
                                                    <a href="#" class="btn btn-sm btn-danger btn-xoa" id =${item.getId()} >Xóa</a>
                                                    <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>
                                                </td>
                                            </tr>
                                        </c:forEach>

<%--                                        <tr>--%>
<%--                                            <td>2</td>--%>
<%--                                            <td>Deshmukh</td>--%>
<%--                                            <td>Gaylord</td>--%>
<%--                                            <td>@Ritesh</td>--%>
<%--                                            <td>member</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>3</td>--%>
<%--                                            <td>Sanghani</td>--%>
<%--                                            <td>Gusikowski</td>--%>
<%--                                            <td>@Govinda</td>--%>
<%--                                            <td>developer</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>4</td>--%>
<%--                                            <td>Roshan</td>--%>
<%--                                            <td>Rogahn</td>--%>
<%--                                            <td>@Hritik</td>--%>
<%--                                            <td>supporter</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>5</td>--%>
<%--                                            <td>Joshi</td>--%>
<%--                                            <td>Hickle</td>--%>
<%--                                            <td>@Maruti</td>--%>
<%--                                            <td>member</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>6</td>--%>
<%--                                            <td>Nigam</td>--%>
<%--                                            <td>Eichmann</td>--%>
<%--                                            <td>@Sonu</td>--%>
<%--                                            <td>supporter</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>1</td>--%>
<%--                                            <td>Deshmukh</td>--%>
<%--                                            <td>Prohaska</td>--%>
<%--                                            <td>@Genelia</td>--%>
<%--                                            <td>admin</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>2</td>--%>
<%--                                            <td>Deshmukh</td>--%>
<%--                                            <td>Gaylord</td>--%>
<%--                                            <td>@Ritesh</td>--%>
<%--                                            <td>member</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>3</td>--%>
<%--                                            <td>Sanghani</td>--%>
<%--                                            <td>Gusikowski</td>--%>
<%--                                            <td>@Govinda</td>--%>
<%--                                            <td>developer</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>4</td>--%>
<%--                                            <td>Roshan</td>--%>
<%--                                            <td>Rogahn</td>--%>
<%--                                            <td>@Hritik</td>--%>
<%--                                            <td>supporter</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>5</td>--%>
<%--                                            <td>Joshi</td>--%>
<%--                                            <td>Hickle</td>--%>
<%--                                            <td>@Maruti</td>--%>
<%--                                            <td>member</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>6</td>--%>
<%--                                            <td>Nigam</td>--%>
<%--                                            <td>Eichmann</td>--%>
<%--                                            <td>@Sonu</td>--%>
<%--                                            <td>supporter</td>--%>
<%--                                            <td>--%>
<%--                                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>--%>
<%--                                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>--%>
<%--                                                <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
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
    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
    <script src="js/user.js"></script>
</body>

</html>
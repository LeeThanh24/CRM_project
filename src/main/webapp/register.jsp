<%--&lt;%&ndash;<!DOCTYPE html>&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@ page contentType="text/html; charset=UTF-8" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@ page isELIgnored="false" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<html lang="en">&ndash;%&gt;--%>
<%--&lt;%&ndash;<head>&ndash;%&gt;--%>
<%--&lt;%&ndash;  <title>Bootstrap Example</title>&ndash;%&gt;--%>
<%--&lt;%&ndash;  <meta charset="utf-8">&ndash;%&gt;--%>
<%--&lt;%&ndash;  <meta name="viewport" content="width=device-width, initial-scale=1">&ndash;%&gt;--%>
<%--&lt;%&ndash;  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">&ndash;%&gt;--%>
<%--&lt;%&ndash;  <link rel="stylesheet" href="css/login.css">&ndash;%&gt;--%>
<%--&lt;%&ndash;</head>&ndash;%&gt;--%>
<%--&lt;%&ndash;<body>&ndash;%&gt;--%>

<%--&lt;%&ndash;&lt;%&ndash;<div class="container">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;  <div class="row mt-5">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;    <div class="col-md-5 m-auto mt-5">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;      <h3 class="text-center">System management</h3>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;      <div class="p-4 border mt-4">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;&lt;%&ndash;&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;    action : đường dẫn form gọi tới&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;    method : quy định phương thức gọi tới ở đường dẫn trong thuộc tính action&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;    name : thuộc tính name của thẻ input là tên của tham số truyền qua link được gọi&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;    ở action&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;&ndash;%&gt;&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;        <form action="http://localhost:8080/login" method="post">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;            <div class="form-group">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;              <label>Email</label>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;              <input type="email" class="form-control" name="email">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;            <div class="form-group">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;              <label>Passowrd</label>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;              <input type="password" class="form-control" name="password">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;            <button type="submit" class="btn btn-primary">Sign in </button>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;            <button type="submit" class="btn btn-primary">Sign up</button>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;          </form>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;      </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;      </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;  </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;</div>&ndash;%&gt;&ndash;%&gt;--%>

<%--&lt;%&ndash;<div class="container">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="screen">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="screen__content">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form class="login">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <div class="login__field">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <i class="login__icon fas fa-user"></i>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="text" class="login__input" placeholder="User name / Email">&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <div class="login__field">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <i class="login__icon fas fa-lock"></i>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="password" class="login__input" placeholder="Password">&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <button class="button login__submit">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <span class="button__text">Log In Now</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <i class="button__icon fas fa-chevron-right"></i>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </button>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <div class="social-login">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <h3>log in via</h3>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <div class="social-icons">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <a href="#" class="social-login__icon fab fa-instagram"></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <a href="#" class="social-login__icon fab fa-facebook"></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <a href="#" class="social-login__icon fab fa-twitter"></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="screen__background">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <span class="screen__background__shape screen__background__shape4"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <span class="screen__background__shape screen__background__shape3"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <span class="screen__background__shape screen__background__shape2"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <span class="screen__background__shape screen__background__shape1"></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>


<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>&ndash;%&gt;--%>
<%--&lt;%&ndash;<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>&ndash;%&gt;--%>

<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>


<%--<!DOCTYPE html>--%>
<%--<!-- Coding By CodingNepal - codingnepalweb.com -->--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
<%--    <title>Login & Registration Form</title>--%>
<%--    <!---Custom CSS File--->--%>
<%--    <link rel="stylesheet" href="css/login.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <input type="checkbox" id="check">--%>
<%--    <div class="login form">--%>
<%--        <header>Login</header>--%>
<%--        <form action="http://localhost:8080/login" method="post">--%>
<%--            <input type="text" name="email" placeholder="Enter your email">--%>
<%--            <input type="password" name="password" placeholder="Enter your password">--%>
<%--            <a href="#">Forgot password?</a>--%>
<%--            <input type="submit" class="button" value="Login">--%>
<%--        </form>--%>
<%--        <div class="signup">--%>
<%--        <span class="signup">Don't have an account?--%>
<%--         <label for="check">Signup</label>--%>
<%--        </span>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--&lt;%&ndash;    <div class="registration form">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <header>Sign Up</header>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <form action="http://localhost:8080/login" method="get">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="text" name ="fullname" placeholder="Enter your name">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="text" name ="email" placeholder="Enter your email">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="password"  name ="password" placeholder="Create a password">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="password" name ="confirmPassword" placeholder="Confirm your password">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="submit" id = "btn_signup" class="button" value="Signup">&ndash;%&gt;--%>
<%--&lt;%&ndash;        </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="signup">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <span class="signup">Already have an account?&ndash;%&gt;--%>
<%--&lt;%&ndash;         <label for="check">Login</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </span>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--</div>--%>

<%--&lt;%&ndash;<div class="form">&ndash;%&gt;--%>

<%--&lt;%&ndash;    <ul class="tab-group">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <li class="tab active"><a href="#signup">Sign Up</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <li class="tab"><a href="#login">Log In</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </ul>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <div class="tab-content">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div id="signup">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <h1>Sign Up for Free</h1>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <form action="/" method="post">&ndash;%&gt;--%>

<%--&lt;%&ndash;                <div class="top-row">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <div class="field-wrap">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            First Name<span class="req">*</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <input type="text" required autocomplete="off" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;                    <div class="field-wrap">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            Last Name<span class="req">*</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <input type="text"required autocomplete="off"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;                <div class="field-wrap">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        Email Address<span class="req">*</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="email"required autocomplete="off"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;                <div class="field-wrap">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        Set A Password<span class="req">*</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="password"required autocomplete="off"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;                <button type="submit" class="button button-block"/>Get Started</button>&ndash;%&gt;--%>

<%--&lt;%&ndash;            </form>&ndash;%&gt;--%>

<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <div id="login">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <h1>Welcome Back!</h1>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <form action="/" method="post">&ndash;%&gt;--%>

<%--&lt;%&ndash;                <div class="field-wrap">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        Email Address<span class="req">*</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="email"required autocomplete="off"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;                <div class="field-wrap">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        Password<span class="req">*</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="password"required autocomplete="off"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;                <p class="forgot"><a href="#">Forgot Password?</a></p>&ndash;%&gt;--%>

<%--&lt;%&ndash;                <button class="button button-block"/>Log In</button>&ndash;%&gt;--%>

<%--&lt;%&ndash;            </form>&ndash;%&gt;--%>

<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;    </div><!-- tab-content -->&ndash;%&gt;--%>

<%--&lt;%&ndash;</div> <!-- /form -->&ndash;%&gt;--%>


<%--<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>--%>
<%--&lt;%&ndash;<script src="js/login.js"></script> <!-- Essential -->&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>

<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>
<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form | CodingLab</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>
<div class="container">
    <div class="wrapper">
        <div class="title"><span>Register</span></div>
        <form action="http://localhost:8080/register" method="post">
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text" name ="fullname" placeholder="Name" required>
            </div>
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text" name ="email" placeholder="Email" required>
            </div>
            <div class="row">
                <i class="fas fa-lock"></i>
                <input type="password" name ="password" placeholder="Password" required>
            </div>
            <div class="row">
                <i class="fas fa-lock"></i>
                <input type="password" name ="confirmPassword" placeholder="Confirm password" required>
            </div>
            <div class="pass"><a href="http://localhost:8080/forgotPassword">Forgot password?</a></div>
            <div class="row button">
                <input type="submit" value="Login">
            </div>
            <div class="signup-link">Alrealdy have an account ? <a href="http://localhost:8080/login">Login</a></div>
        </form>
    </div>
</div>

</body>
</html>

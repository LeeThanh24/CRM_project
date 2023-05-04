<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!-- Created By CodingLab - www.codinglabweb.com -->
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
    <h1>${email}</h1>
    <div class="wrapper">
        <div class="title"><span>Change password</span></div>
        <form action="http://localhost:8080/changePassword" method="post">
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text"  name ="newPassword" placeholder="New password" required>
            </div>
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text"  name ="confirmPassword" placeholder="Confirm password" required>
            </div>
            <div class="row button">
                <input type="submit" value="Change">
            </div>
            <div class="signup-link"> <a href="http://localhost:8080/login">Back to login</a></div>


        </form>
    </div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
background-color: gray;
}
 .navbar{
background-color: green;
width: 100%;
height: 50px;
}
.navbar {
    overflow: hidden;
    background-color: #333;
}

.navbar a {
    float: left;
    display: block;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 20px;
    text-decoration: none;
}

.navbar a:hover {
    background-color: #ddd;
    color: black;
}

.navbar a.active {
    background-color: #4CAF50;
    color: white;
}

.content{
text-align:center;
margin-top: 100px;
background-color:lime;
color:blue;
width: 100%;
height: 300px;

}
.content h1{
padding-top: 50px;
}

</style>
</head>
<body>

<div class="navbar">

<a href="#" class="active">online Stock Trader</a>
    <a href="#">Home</a>
    <!--  <a href="#">Services</a>
    <a href="#">Contact</a> -->
    <a href="/users/reg" id=signin>SignUp</a>
    <a href="/users/log" id="login">LogIn</a>
     



</div>
<div class="content">

<h1>Online Stock Trading</h1>

<h3>Create account, link bank account to profile</h3>

<h3>Add stocks to watch list</h3>

<h3>Buy and sell stocks</h3>
</div>


</body>
</html>
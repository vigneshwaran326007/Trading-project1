<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
body{
background-color:brown;

}
.content{
margin-left:28%;
margin-top: 50px;
}
h1{
text-align: center;
color:green;
font-size: 37px;
margin-top: 50px;
text-decoration: underline;
}
table,tr,td{
padding:20px;
font-size: 20px;
}
td input{

color:green;
font-size: 20px;
}
#log{
background-color: red;
color:black;
border-radius: 20px;
width:100px;
margin-left:60px;
}
#log:hover{
background-color: black;
color:white;
}
label{
font-size: 20px;
margin-left:60px;
}
label a:hover{
color:green;
}
</style>
</head>
<body>

<h1>User Login Page</h1>

 

<div class="content">

<form action="/users/valid" method="get">
<table>

<tr>

<td>Username</td>
<td><input type="text" name="username" id="uname" required="required"></td>

</tr>
<tr>

<td>Email</td>
<td><input type="email" name="email" id="uid" required="required"></td>

</tr>

<tr>

<td>Password</td>
<td><input type="password" name="password" id="pass" required="required"></td>

</tr>

<tr>

<td></td>
<td><a href="Mainpage"><input type="submit" value="LogIn" id="log"></a></td>

</tr>


</table>

<label>Don't have an Account! please  <a href="/users/reg">  Register</a></label>


</form>
</div>

</body>
</html>
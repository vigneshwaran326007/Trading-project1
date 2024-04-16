<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style type="text/css">
body{
background-color:orange;

}
.content{
margin-left: 28%;
margin-top: 50px;
}
h1{
text-align: center;
color:blue;
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
#reg{
background-color: red;
color:black;
border-radius: 20px;
width:100px;
margin-left:60px;
}
#reg:hover{
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
<h1>User Register Page</h1>
<div class="content">
<form action="/users/add" method="post">
<table>

<tr>
<td>UserName</td>
<td><input type="text" name="username" id="uid" required="required"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" id="upass" required="required"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="email" id="umail" required="required"></td>
</tr>
<tr>
<td>Role</td>
<td><input type="text" name="role" id="urole" required="required"></td>
</tr>
<tr>
<td>Account Balance</td>
<td><input type="number" name="accountBalance" id="ubal" required="required"></td>
</tr>
<tr>
<td>Registration Date</td>
<td><input type="date" name="registrationDate" id="regdate" required="required"></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Register" id="reg" ></td>
</tr>


</table>
<label>Already have an Account!<a href="/users/log">LogIn</a></label>

</form>
</div>
</body>
</html>
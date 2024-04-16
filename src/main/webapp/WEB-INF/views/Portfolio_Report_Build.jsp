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
    padding: 14px 35px;
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
/* .navbar a#out{
margin-left: 140px;
} */
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: fixed;
  background-color:gray;
  width: 200px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: red;
  font-size:16px; 
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  
}

.dropdown-content a:hover {
  background-color: black;
  color:white;
}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color:  #3e8e41;
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

<div class="navbar">

<a href="#" class="active">online Stock Trader</a>



    <a href="#">Home</a>
    <div class="dropdown">
    
    <a href="#" class="dropbtn">Market Data</a>
   <!-- <div class="dropdown-content">
   <a href="#">Market Summary</a>
   <a href="#">Historical Data</a>
   <a href="#">Stock Performance</a>
   </div >  -->
     </div>
     <div class="dropdown">
    <a href="#" class="dropbtn">Portfolio</a>
   <!--  <div class="dropdown-content">
   <a href="#">Portfolio summary</a>
   <a href="#">Asset Allocation</a>
   <a href="#">Performance</a>
   <a href="#">Risk Analysis</a>
   </div >  -->
     </div>
    <div class="dropdown">
    <a href="#" class="dropbtn" >Transaction</a>
    <!-- <div class="dropdown-content">
   <a href="#">Transaction Information</a>
   <a href="#">Transaction Status</a>
   <a href="#">Tax Reporting</a>
   <a href="#">Order History Report</a>
   </div >  -->
     </div>
      <div class="dropdown">
    <a href="#" class="dropbtn">Stock</a>
    <!-- <div class="dropdown-content">
   <a href="#">Company List</a>
   <a href="#">Stock Report generator</a>
   
   </div > --> 
     </div>
    <div class="dropdown">
    <a href="#" class="dropbtn">UserDetails</a>
    <!-- <div class="dropdown-content">
   <a href="/users/list">User List</a>
   <a href="#">User Report</a>
   
   </div > --> 
     </div>
    <div class="dropdown">
    <a href="#" class="dropbtn">Report</a>
   <!--  <div class="dropdown-content">
   <a href="#">Annual Report</a>
   <a href="#">Monthly Report</a>
   <a href="#">Custom stock Report</a>
    <a href="#">Stock Custom Report</a>
   </div >  -->
     </div>
     
       <div class="dropdown">
    <a href="/users/home" class="dropbtn">LogOut</a>
    
     </div>
     
</div>


<h1>REPORT BUILDER</h1>

 

<div class="content">

<form action="/portfolios/addportfolio" method="post">
<table>

<tr>

<td>Stock id</td>
<td><input type="number" name="stock" id="sym" required="required"></td>

</tr>
<tr>

<td>User Id</td>
<td><input type="number" name="user" id="user" required="required"></td>

</tr>

<tr>

<td>Quantity</td>
<td><input type="number" name="quantity" id="qny" required="required"></td>

</tr>
<tr>
<td>Average Price</td>
<td><input type="number" name="averagePrice" id="avgprice" required="required"></td>

</tr>
<tr>
<td>Total Investment</td>
<td><input type="number" name="totalInvestment" id="invest" required="required"></td>

</tr>

<tr>

<td></td>
<td><input type="submit" value="Register" id="log"></td>

</tr>


</table>



</form>
</div>


</body>
</html>
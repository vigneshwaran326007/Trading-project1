<%@page import="com.vignesh.tradingApplication.model.MarketData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: gray;
}

.navbar {
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
	background-color: gray;
	width: 200px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: red;
	font-size: 16px;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: black;
	color: white;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

.content1 {
	margin-left: 28%;
	margin-top: 50px;
}

h1 {
	text-align: center;
	color: green;
	font-size: 37px;
	margin-top: 50px;
	text-decoration: underline;
}

table, tr, td {
	padding: 20px;
	font-size: 20px;
}

td input {
	color: green;
	font-size: 20px;
}

#log {
	background-color: red;
	color: black;
	border-radius: 20px;
	width: 100px;
	margin-left: 60px;
}

#log:hover {
	background-color: black;
	color: white;
}

label {
	font-size: 20px;
	margin-left: 60px;
}

label a:hover {
	color: green;
}
.content1{
margin-left:5%;
margin-top:50px;
}
h1{
text-align: center;
color:violet;
font-size: 36px;
text-decoration: underline;
}

table,th,tr,td{
border:2px solid black;
border-collapse: collapse;
text-align:center;
padding:20px;
font-size: 20px;
color:blue;

}
th{
color:brown;
font-size: 23px;
}
#add,#remove{
background-color: orange;
color:white;
border-radius: 20px;
}
</style>

</head>
<body>

	<div class="navbar">

		<a href="#" class="active">online Stock Trader</a> <a href="#">Home</a>
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
			<!-- <div class="dropdown-content">
   <a href="#">Portfolio summary</a>
   <a href="#">Asset Allocation</a>
   <a href="#">Performance</a>
   <a href="#">Risk Analysis</a>
   </div > -->
		</div>
		<div class="dropdown">
			<a href="#" class="dropbtn">Transaction</a>
			<!--   <div class="dropdown-content">
   <a href="#">Transaction Information</a>
   <a href="#">Transaction Status</a>
   <a href="#">Tax Reporting</a>
   <a href="#">Order History Report</a>
   </div > -->
		</div>
		<div class="dropdown">
			<a href="#" class="dropbtn">Stock</a>
			<!-- <div class="dropdown-content">
   <a href="#">Company List</a>
   <a href="#">Stock Report generator</a>
   
   </div >  -->
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
   </div > -->
		</div>

		<div class="dropdown">
			<a href="/users/home" class="dropbtn">LogOut</a>

		</div>

	</div>
	
	<h1>Market List</h1>
	<div class="content1">
		<table>
			<tr>
				<th>Id</th>
				<th>Date</th>
				<th>High Price</th>
				<th>Low Price</th>
				<th>Open Price</th>
				<th>close Price</th>
				<th>Stock Id</th>
				<th>Volume</th>
			</tr>
			
			   <% ArrayList<MarketData> al= (ArrayList<MarketData>)request.getAttribute("marketlist");
            
            for(MarketData a:al){
            	out.println("<tr>");
            	out.println("<td>"+a.getId()+"</td>");
            	out.println("<td>"+a.getDate()+"</td>");
            	out.println("<td>"+a.getHighPrice()+"</td>");
            	out.println("<td>"+a.getLowPrice()+"</td>");
            	out.println("<td>"+a.getOpenPrice()+"</td>");
            	out.println("<td>"+a.getClosePrice()+"</td>");
            	out.println("<td>"+a.getStock()+"</td>");
            	out.println("<td>"+a.getVolume()+"</td>");
            	out.println("</tr>");
            }
            
            
            %>

			<c:if test="${not empty marketlist}">
				<c:forEach items="${marketlist}" var="user">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.date}" /></td>
						<td><c:out value="${user.highPrice}" /></td>
						<td><c:out value="${user.lowPrice}" /></td>
						<td><c:out value="${user.openPrice}" /></td>
						<td><c:out value="${user.closePrice}" /></td>
						<td><c:out value="${user.stock}" /></td>
						<td><c:out value="${user.volume}" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

</body>

</html>
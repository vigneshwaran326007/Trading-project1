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
	padding: 14px 30px;
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
	width: 150px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: red;
	font-size: 13px;
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

/* .image > img {
	margin-top: 200px;
	width: 100%;
	 height: 500 px;
	background_size: cover;
} */

.image{
	width:100px;
	aspect-ratio:1/1;
	background-image: url(../image/img1.jpg);
}
</style>
</head>
<body>

	<div class="navbar">

		<a href="#" class="active">online Stock Trader</a> <a href="#">Home</a>
		<div class="dropdown">

			<a href="#" class="dropbtn">Market Data</a>
			<div class="dropdown-content">
				<a href="/marketdata/marketlist">Market Summary</a> <a href="#">Historical
					Data</a> <a href="#">Stock Performance</a> <a href="/marketdata/add">Report
					Build</a>
			</div>
		</div>
		<div class="dropdown">
			<a href="#" class="dropbtn">Portfolio</a>
			<div class="dropdown-content">
				<a href="/portfolios/portfoliolist">Portfolio summary</a> <a
					href="/portfolios/add">Report Build</a> <a href="#">Performance</a>
				<a href="#">Risk Analysis</a>
			</div>
		</div>
		<div class="dropdown">
			<a href="#" class="dropbtn">Transaction</a>
			<div class="dropdown-content">
				<a href="/transactions/transactionlist">Transaction Information</a>
				<a href="#">Transaction Status</a> <a href="/transactions/add">
					Report Builder</a> <a href="#">Order History Report</a>
			</div>
		</div>
		<div class="dropdown">
			<a href="#" class="dropbtn">Stock</a>
			<div class="dropdown-content">
				<a href="/stocks/stocklist">Company List</a> <a href="/stocks/add">Stock
					Register</a>

			</div>
		</div>
		<div class="dropdown">
			<a href="#" class="dropbtn">UserDetails</a>
			<div class="dropdown-content">
				<a href="/users/userlist">User List</a> <a href="/report/generate">User
					Report</a>

			</div>
		</div>
		<div class="dropdown">
			<a href="#" class="dropbtn">Report</a>
			<div class="dropdown-content">
				<a href="/report/generate">Annual Report</a> <a
					href="/report/generate">Monthly Report</a> <a
					href="/report/customer">Custom stock Report</a> <a
					href="/report/stock">Stock Custom Report</a>
			</div>
		</div>

		<div class="dropdown">
			<a href="/users/home" class="dropbtn">LogOut</a>

		</div>




	</div>

	<div class="image">

		<!-- <img src="./img1.jpg" alt="hiii"> -->

	</div>



</body>
</html>
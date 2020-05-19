<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

	<h1>Error Creating the following Order</h1>
		
	<h2>${error.message}</h2>

	<table>
		<tr>
			<td><b>Product ID</b></td>
			<td><b>Customer ID</b></td>
			<td><b>Quantity</b></td>
		</tr>
		<tr>
			<td>${order.prod.pId}</td>
			<td>${order.cust.cId}</td>
			<td>${order.qty}</td>
		</tr>
	</table><br>

</body>

	<a href="/index.html">Home</a>
	<a href="/addOrder.html">New Order</a>
	<a href="/showOrders.html">List Orders</a>
</html>
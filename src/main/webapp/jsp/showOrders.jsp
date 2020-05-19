<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- CSS -->
<link rel="stylesheet" href="/css/style.css">

<title>Insert title here</title>
</head>
<body>
	<h1>List of Orders</h1>

	<table>

		<c:forEach items="${orders}" var="order">
			<tr>
				<th><h2>${order.oId}</h2></th>
			</tr>

			<tr>
				<td><b>Quantity</b></td>
				<td><b>Order Date</b></td>
				<td><b>Customer ID</b></td>
				<td><b>Customer Name</b></td>
				<td><b>Product ID</b></td>
				<td><b>Description</b></td>
			</tr>

			<tr>
				<td>${order.qty}</td>
				<td>${order.orderDate}</td>
				<td>${order.cust.cId}</td>
				<td>${order.cust.cName}</td>
				<td>${order.prod.pId}</td>
				<td>${order.prod.pDesc}</td>
			</tr>

		</c:forEach>

	</table><br>
	
	<a href="/index.html">Home</a>
	<a href="/addOrder.html">Add Order</a>
	<a href="/showProducts.html">List Products</a>
	<a href="/showCustomers.html">List Customers</a>
	<a href="/logout">Logout</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- CSS -->
<link rel="stylesheet" href="/css/style.css">

<title>Customers</title>
</head>
<body>
	<h1>List of Customers</h1>

	<table>

		<c:forEach items="${customers}" var="customer">
			<tr>
				<th><h2>${customer.cId} ${customer.cName}</h2></th>
			</tr>

			<tr>
				<th><b>${customer.cName}'s Orders</b></th>
			</tr>

			<tr>
				<td><b>Order ID</b></td>
				<td><b>Quantity</b></td>
				<td><b>Product ID</b></td>
				<td><b>Description</b></td>
			</tr>

			<tr>
				<c:forEach items="${customer.orders}" var="order">
					<tr>
						<td>${order.oId}</td>
						<td>${order.qty}</td>
						<td>${order.prod.pId}</td>
						<td>${order.prod.pDesc}</td>
					</tr>
				</c:forEach>
			</tr>

		</c:forEach>

	</table><br>

	<a href="/index.html">Home</a>
	<a href="/addCustomer.html">Add Customer</a>
	<a href="/showProducts.html">List Products</a>
	<a href="/showOrders.html">List Orders</a>
	<a href="/logout">Logout</a>

</body>
</html>
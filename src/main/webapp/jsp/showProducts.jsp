<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADCWA Final Project</title>
</head>
<body>
	<h1>List of Products</h1>

	<table border="1">
		<tr>
			<td>Product ID</td>
			<td>Description</td>
			<td>Quantity in Stock</td>
		</tr>
		<tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.pId}</td>
					<td>${product.pDesc}</td>
					<td>${product.qtyInStock}</td>
				</tr>
			</c:forEach>
		</tr>
	</table><br>
	
	<a href="/index.html">Home</a>
	<a href="/addProduct.html">Add Product</a>
	<a href="/showProducts.html">List Products</a>
	<a href="/showOrders.html">List Orders</a>
	<a href="/logout">Logout</a>

</body>
</html>
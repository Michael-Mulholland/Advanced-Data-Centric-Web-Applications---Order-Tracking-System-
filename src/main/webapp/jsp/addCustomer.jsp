<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add New Customer</h1>
	<form:form modelAttribute="customer">
		<table>
			<tr>
				<td>Cust Name:</td>
				<td><form:input path="cName"></form:input></td>
				<td><form:errors path="cName"></form:errors></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table><br>
	</form:form>

	<a href="/index.html">Home</a>
	<a href="/showOrders.html">List Orders</a>
	<a href="/showProducts.html">List Products</a>
</body>
</html>
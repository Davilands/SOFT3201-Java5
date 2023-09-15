<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: 50px"></div>
	<table border="1" style="width: 100%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Amount</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${giohang.items}">
			<form action="/cart/update/${item.id}" method="post">
				<input type="hidden" name="id" value="${item.id}">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td><input name="qty" value="${item.qty}"
						onblur="this.form.submit()" style="width: 50px"></td>
					<td>${item.price * item.qty}</td>
					<td><a href="/cart/remove/${item.id}">Remove</a></td>
				</tr>

			</form>
		</c:forEach>
	</table>
	<a href="/cart/clear">Clear Cart</a>
	<a href="/item/index">Add more</a>
</body>
</html>
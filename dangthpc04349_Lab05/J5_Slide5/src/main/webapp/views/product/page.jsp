<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.myButton {
	box-shadow: 0px 1px 0px 0px #fff6af;
	background: linear-gradient(to bottom, #ffec64 5%, #ffab23 100%);
	background-color: #ffec64;
	border-radius: 6px;
	border: 1px solid #ffaa22;
	display: inline-block;
	cursor: pointer;
	color: #333333;
	font-family: Arial;
	font-size: 15px;
	font-weight: bold;
	padding: 6px 24px;
	text-decoration: none;
	text-shadow: 0px 1px 0px #ffee66;
}

.myButton:hover {
	background: linear-gradient(to bottom, #ffab23 5%, #ffec64 100%);
	background-color: #ffab23;
}

.myButton:active {
	position: relative;
	top: 1px;
}

.column {
	float: left;
	width: 50%;
}
.row{
	margin-top: 10px;
}
/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>
<body>
	<h1 align='center'>DANH SÁCH SẢN PHẨM</h1>
	<table border="1" style="width: 100%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Date</th>
			<th>Category</th>
		</tr>
		<c:forEach var="sp" items="${trang.content}">
			<tr>
				<td>${sp.id}</td>
				<td>${sp.name}</td>
				<td><fmt:formatNumber value="${sp.price}"/> </td>
				<td><fmt:formatDate value="${sp.createDate}" pattern="dd/MM/yyyy"/> </td>
				<td>${sp.category.name}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="row">
		<div class="column">
			<ul>
				<li>Trang số: ${trang.number + 1}</li>
				<li>Kích thước trang: ${trang.size}</li>
				<li>Tổng số trang: ${trang.totalPages}</li>
				<li>Số phần tử hiện tại: ${trang.numberOfElements}</li>
				<li>Tổng số phần tử: ${trang.totalElements}</li>
			</ul>
		</div>
		<div class="column" style="text-align: right;">
			<a class='myButton' href="/product?page=0"> |&lt; </a> 
			<a class='myButton'	href="/product?page=${trang.number-1 < 0 ? 0:trang.number-1}">&lt;&lt; </a>
			<a class='myButton' href="/product?page=${trang.number+1 > trang.totalPages - 1 ? trang.totalPages - 1: trang.number+1}">&gt; &gt; </a>
			<a class='myButton'	href="/product?page=${trang.totalPages-1}"> &gt;| </a>
		</div>
	</div>
</body>
</html>
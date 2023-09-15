<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>SORTING BY ${ field }</h3>
	<table border="1" style="width: 100%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Date</th>
		</tr>
		<c:forEach items="${ listProduct }" var="item">
			<tr>
				<td>${ item.id }</td>
				<td>${ item.name }</td>
				<td><fmt:formatNumber value="${ item.price }" /></td>
				<td><fmt:formatDate value="${ item.createDate }"
						pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>
	</table>

	<!-- JavaScript Bundle with Popper -->
	<script src="/js/jquery-3.2.1.slim.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>

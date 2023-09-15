<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>CategoryId</th>
			<th>Category name</th>
		</tr>
		<c:forEach items="${list}" var = "cate">
			<tr>
				<td>${ cate.id }</td>
				<td>${ cate.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
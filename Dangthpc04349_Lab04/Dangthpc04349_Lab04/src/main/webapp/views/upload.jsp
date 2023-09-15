<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"> <br> <input type="submit"
			name="btnUpload" value="Upload"> <br>
	</form>
	${message}
	<h1>Công ty</h1>
	<p>Name: ${com.name}</p>
	<p>Logo: ${com.logo}</p>
</body>
</html>
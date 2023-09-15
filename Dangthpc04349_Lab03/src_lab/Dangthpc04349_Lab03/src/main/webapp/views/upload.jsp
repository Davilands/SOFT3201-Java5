<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>
<body>
	<form action="/upload/save" method="post" enctype="multipart/form-data">
		<label>File:</label> <br>
		<input type="file" name="file"> <br>
		<button>Submit</button>
	</form>
</body>
</html>
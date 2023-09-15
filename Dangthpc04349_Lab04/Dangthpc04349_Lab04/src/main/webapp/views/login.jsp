<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/account/login" method="post">
		<label>Username:</label> <input name="username" type="text"
			value="${user}"><br> <label>Password:</label> <input
			name="password" type="password" value="${pass}"><br> <input
			type="checkbox" name="remember" checked="checked" value="true">Remember
		me?
		<button>Login</button>
	</form>
</body>
</html>
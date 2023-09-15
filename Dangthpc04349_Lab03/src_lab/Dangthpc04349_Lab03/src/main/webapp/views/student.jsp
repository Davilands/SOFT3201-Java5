<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài 1</title>
</head>
<body>
	<div>
		<div>
			FORM STUDENT
		</div>
		<div>
			<form:form action="/student/save" modelAttribute="student">
				<div>
					<label>Name:</label>
					<form:input path="name"/>
				</div>
				
				<div>
					<label>Email:</label>
					<form:input path="email" />
				</div>
				
				<div>
					<label for="exampleInputPassword1">Marks:</label>
					<form:input path="marks"/>
				</div>
				
				<div >
					<label>Gender:</label>
					<form:radiobuttons path="gender" items="${ gender }" delimiter=" " />
				</div>
				
				<div>
					<label >Hobbies:</label>
					<form:radiobuttons path="hobbies" items="${ hobbies }" delimiter=" " />
				</div>
				
				<div>
					<label for="inputState">Faculty:</label>
					<form:select path="faculty">
						<form:options items="${ faculty }"/>
					</form:select>
				</div>
				<button type="submit">Submit</button>
			</form:form>
		</div>
		<div >Lab3-Bai1</div>
	</div>
</body>
</html>
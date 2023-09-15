<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validator Form 2</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcnd.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div>
		<c:if test="${ message != null }">
			<div role="alert">
				<strong>Error!</strong> ${ message }
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&time;</span>
				</button>
			</div>
		</c:if>
		<div >
			<div>
				FORM STUDENT</div>
			<div>
				<form:form action="/student/save3" modelAttribute="student">
					<div>
						<label>Name:</label>
						<form:input path="name"/>
						<form:errors path="name" element="small"></form:errors>
					</div>

					<div>
						<label>Email:</label>
						<form:input path="email" />
						<form:errors path="email" element="small"></form:errors>
					</div>

					<div >
						<label for="exampleInputPassword1">Marks:</label>
						<form:input path="marks" />
						<form:errors path="marks" element="small"></form:errors>
					</div>

					<div >
						<label >Gender:</label>
						<form:radiobuttons path="gender" items="${ gender2 }" delimiter=" "/>
						<form:errors path="gender" element="small"></form:errors>
					</div>

					<div>
						<label >Hobbies:</label>
						<form:radiobuttons path="hobbies" items="${ hobbies }"
							delimiter=" " />
						<form:errors path="hobbies" element="small"></form:errors>
					</div>

					<div >
						<label for="inputState">Faculty:</label>
						<form:select path="faculty">
							<form:options items="${ faculty }" />
						</form:select>
						<form:errors path="faculty" element="small"></form:errors>
					</div>
					<button type="submit" >Submit</button>
				</form:form>
			</div>
			<div>Lab3-Bai3</div>
		</div>
	</div>
		
		
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>
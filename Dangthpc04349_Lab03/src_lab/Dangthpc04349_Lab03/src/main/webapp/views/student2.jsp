<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validator Form</title>
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
		<div>
			<div>
				FORM STUDENT</div>
			<div>
				<form:form action="/student/save2" modelAttribute="student">
					<div>
						<label>Name:</label>
						<form:input path="name" cssClass="form-control" />
						<form:errors path="name" element="small"></form:errors>
					</div>

					<div>
						<label>Email:</label>
						<form:input path="email" cssClass="form-control" />
						<form:errors path="email" element="small"></form:errors>
					</div>

					<div>
						<label for="exampleInputPassword1">Marks:</label>
						<form:input path="marks" cssClass="form-control" />
						<form:errors path="marks" element="small"></form:errors>
					</div>

					<div>
						<label >Gender:</label>
						<form:radiobuttons path="gender" items="${ gender2 }" delimiter=" "/>
						<form:errors path="gender" element="small"></form:errors>
					</div>

					<div>
						<label>Hobbies:</label>
						<form:radiobuttons path="hobbies" items="${ hobbies }"
							delimiter=" "/>
						<form:errors path="hobbies" element="small"></form:errors>
					</div>

					<div>
						<label for="inputState">Faculty:</label>
						<form:select path="faculty">
							<form:options items="${ faculty }" />
						</form:select>
						<form:errors path="faculty" element="small"></form:errors>
					</div>
					<button type="submit">Submit</button>
				</form:form>
			</div>
			<div>Lab3-Bai3</div>
		</div>
	</div>
		
		
</body>
</html>
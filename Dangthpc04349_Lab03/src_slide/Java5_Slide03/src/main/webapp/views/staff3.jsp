<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<fr:form modelAttribute="staff" method="POST" action="/staff3">
		<fr:errors path="*" delimiter=",">
		</fr:errors>
		<br>
ID: <fr:input path="id" />
		<fr:errors path="id" element="span"></fr:errors>
		<br>
Fullname:<fr:input path="fullname" />
		<fr:errors path="fullname" element="span"></fr:errors>
		<br>
Gender:<fr:radiobuttons path="gender" items="${genders}" />
		<fr:errors path="gender" element="span"></fr:errors>
		<br>
Email: <fr:input path="email" />
		<fr:errors path="email" element="span"></fr:errors>
		<br>
Salary: <fr:input path="salary" />
		<fr:errors path="salary" element="span"></fr:errors>
		<br>
Position: <fr:select path="position">
			<fr:option value="Chưa chọn vị trí" ></fr:option>
			<fr:options items="${positions}" />
		</fr:select>
		<fr:errors path="position" element="span"></fr:errors>
		<br>
Hobbies: <fr:checkboxes items="${hobbies}" path="hobbies" />
		<fr:errors path="hobbies" element="span"></fr:errors>
		<br>
		<fr:button>Save</fr:button>
	</fr:form>
	${message}
</body>
</html>
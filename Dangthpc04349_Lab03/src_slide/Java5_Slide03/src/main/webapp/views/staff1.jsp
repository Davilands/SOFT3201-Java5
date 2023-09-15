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
	<fr:form modelAttribute="staff" method="POST">
		<fr:input path="manv" />
		<br>
		<fr:input path="tennv" />
		<br>
		<fr:radiobuttons path="position" items="${vitri}" />
		<br>
		<fr:checkboxes path="hobbies" items="${sothich}" />
		<br>
		<fr:select path="country.maquocgia">
			<fr:options items="${quocgia}" itemLabel="tenquocgia"
				itemValue="maquocgia" />
		</fr:select>
		<fr:button>Save</fr:button>
	</fr:form>
</body>
</html>
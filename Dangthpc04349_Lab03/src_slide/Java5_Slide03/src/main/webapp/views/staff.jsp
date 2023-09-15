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
	<fr:form modelAttribute="nhanvien" method="POST">
		<fr:input path="maNV" placeholder="Nhập mã NV" />
		<br>
		<fr:input path="tenNV" placeholder="Nhập tên NV" />
		<br>
		<fr:input path="email" placeholder="Nhập địa chỉ email" />
		<br>
		<fr:radiobutton path="gioiTinh" value="true" label="Nam" />
		<fr:radiobutton path="gioiTinh" value="false" label="Nữ" />
		<br>
		<fr:select path="viTri">
			<fr:option value="CEO"> Chief Excutive Officer</fr:option>
			<fr:option value="DIR">Director</fr:option>
			<fr:option value="MAN">Manager</fr:option>
			<fr:option value="EMP">Emloyee</fr:option>
		</fr:select>
		<fr:button>Save</fr:button>
	</fr:form>
</body>
</html> 
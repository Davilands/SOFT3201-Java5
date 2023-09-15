<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="alert alert-primary" role="alert">${param.message}</div>
	<div class="container">
		<fr:form action="/account/create" method="POST" modelAttribute="account" enctype="multipart/form-data">
			<div class="form-group">
				<label for="exampleInputAcount">Tài khoản</label>
				<fr:input class="form-control" path="username" placeholder="Nhập tài khoản"/>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword">Mật khẩu</label>
				<fr:input type="password" class="form-control" path="password" placeholder="Nhập mật khẩu"/>
			</div>
			<div class="form-group">
				<label for="exampleInputFullname">Họ tên</label>
				<fr:input class="form-control" path="fullname" placeholder="Nhập họ tên"/>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail">Email</label>
				<fr:input type="email" class="form-control" path="email" placeholder="Nhập email"/>
			</div>
			<div class="custom-file">
				<input type="file" class="custom-file-input" name="photo_file">
				<label class="custom-file-lable" for="validateCustomFile">Chọn hình ảnh..</label>
			</div>
			<div class="form-check">
				<fr:checkbox class="form-check-input" path="admin"/>
				<label class="form-check-lable" for="exampleCheck1">Quản tị</label>
			</div>
			<div class="form-check">
				<fr:checkbox class="form-check-input" path="activated"/>
				<label class="form-check-lable" for="exampleCheck1">Hoạt động</label>
			</div>
			<button type="submit" class="btn btn-primary">Thêm</button>
			<button formaction="/account/update" type="submit" class="btn btn-secondary">Cập nhật</button>
			<button formaction="/account/index" type="submit" class="btn btn-infor">Làm lại</button>
		</fr:form>
	</div>
	<div style="margin: 15px"></div>
	<table class="table table-striped">
		<tr>
			<th>STT</th>
			<th>Tài khoản</th>
			<th>Họ tên</th>
			<th>Trạng thái</th>
			<th>Vai trò</th>
			<th>Hành động</th>
		</tr>
		<c:set value="1" var="i" />
		<c:forEach items="${listAccount}" var="acc">
			<tr>
				<td>${i}</td>
				<td>${acc.username}</td>
				<td>${acc.fullname}</td>
				<td>${acc.activated ? "Hoạt động": "Khóa"}</td>
				<td>${acc.admin? "Quản trị": "Khách hàng"}</td>
				<td>
					<a href="/account/edit/${acc.username}" class="btn btn-warning">Sửa</a>
					<a href="javascript:deleteUser('${acc.username}')" class="btn btn-danger">Xóa</a>
				</td>
			</tr>
		<c:set var="i" value="${i+1}" />
		</c:forEach>
		
	</table>
	<!-- JavaScript Bundle with Popper -->
	<script src="/js/jquery-3.2.1.slim.min.js"></script>
	<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
	<script>
		function deleteUser(uname){
			if(confirm("Bạn muốn xóa tài khoản "+uname + "phải không?") == true){
				window.location.href = "/account/delete/" + uname;
			}
		}
	</script>


</body>
</html>
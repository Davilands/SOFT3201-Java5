<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<style>
	h1.header{
		padding: 20px; 
		background-color: #90EE90; 
		border-radius: 5px
	}
</style>
</head>
<body style="padding: 10px">
	<div class="container">
		<header>
			<tiles:insertAttribute name="header" />
			<h3>aloo</h3>
		</header>

		<tiles:insertAttribute name="menu" />

		<main class="row">
			<article class="col-sm-9">
				 <tiles:insertAttribute name="body"/>
			</article>
			<aside class="col-sm-3">
				<tiles:insertAttribute name="aside" />
			</aside>
		</main>
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script>
	$(".lang").click(function(event){
		event.preventDefault();
		$.ajax({
			url: $(this).attr("href"),
			success: function(){
				location.reload();
			}
		});
	});
</script>
</html>
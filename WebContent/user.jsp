<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<!DOCTYPE html>
<html>
<head>
<title>User</title>
</head>
<body>
	<f:view>
		<div>Email : ${userController.user.email}</div>

		<div>password : ${userController.user.password}</div>
		<div>username : ${userController.user.username}</div>
		<div>
			<button onclick="goBack()">Torna agli ordini</button>

			<script>
				function goBack() {
					window.history.back();
				}
			</script>
		</div>
	</f:view>
</body>
</html>
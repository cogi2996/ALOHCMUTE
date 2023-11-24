<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<style>
/* Định dạng form */
form {
	width: 50%;
	margin: 0 auto;
	font-family: Arial, sans-serif;
}

/* Định dạng input và label */
label, input {
	display: block;
	margin-bottom: 10px;
}

input[type="submit"] {
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<form action='<c:url value = "/dangki"></c:url>' method="post">
		<label for="gmail">Gmail:</label> <input type="email" id="gmail"
			name="gmail" required> <label for="password">Mật
			khẩu:</label> <input type="password" id="password" name="password" required>

		<label for="mobile">Số điện thoại:</label> <input type="tel"
			id="mobile" name="mobile" required> <label for="firstName">Tên:</label>
		<input type="text" id="firstName" name="firstName" required> <label
			for="midName">Tên đệm:</label> <input type="text" id="midName"
			name="midName"> <label for="lastName">Họ:</label> <input
			type="text" id="lastName" name="lastName" required> <label
			for="address">Địa chỉ:</label> <input type="text" id="address"
			name="address" required> <label for="position">Chức
			vụ:</label> <input type="text" id="position" name="position" required>

		<label for="workPlace">Nơi làm việc:</label> <input type="text"
			id="workPlace" name="workPlace" required> <input
			type="submit" value="Đăng ký">
	</form>

</body>
</html>

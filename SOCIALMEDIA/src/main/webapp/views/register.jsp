<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
</html> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đăng ký</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-5">
        <form action='<c:url value="/dangki"></c:url>' method="post">
            <div class="form-group">
                <label for="gmail">Gmail:</label>
                <input type="email" class="form-control col-md-4" id="gmail" name="gmail" required>
            </div>
            <div class="form-group ">
                <label for="password">Mật khẩu:</label>
                <input type="password" class="form-control col-md-4" id="password" name="password" required>
            </div>
            <div class="form-group ">
                <label for="mobile">Số điện thoại:</label>
                <input type="tel" class="form-control col-md-4" id="mobile" name="mobile" required>
            </div>
            <div class="form-row">
               <div class="form-group col-md-4">
                    <label for="lastName">Họ:</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" required>
                </div>
                <div class="form-group col-md-4">
                    <label for="midName">Tên đệm:</label>
                    <input type="text" class="form-control" id="midName" name="midName">
                </div>
                
                 <div class="form-group col-md-4">
                    <label for="firstName">Tên:</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" required>
                </div>
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ:</label>
                <input type="text" class="form-control" id="address" name="address" required>
            </div>
            <div class="form-group">
                <label for="position">Khoa:</label>
                <input type="text" class="form-control col-md-4" id="position" name="position" required>
            </div>
            <div class="form-group">
                <label for="workPlace">Ngành học:</label>
                <input type="text" class="form-control col-md-4" id="workPlace" name="workPlace" required>
            </div>
            <button type="submit" class="btn btn-primary">Đăng ký</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies (Optional for form interaction) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

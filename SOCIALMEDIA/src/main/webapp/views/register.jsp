<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng kí</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
body {
	background:
		url('https://static-communitytable.parade.com/wp-content/uploads/2014/03/rethink-target-heart-rate-number-ftr.jpg')
		fixed;
	background-size: cover;
}

*[role="form"] {
	max-width: 530px;
	padding: 15px;
	margin: 0 auto;
	border-radius: 0.3em;
	background-color: #f2f2f2;
}

*[role="form"] h2 {
	font-family: 'Open Sans', sans-serif;
	font-size: 40px;
	font-weight: 600;
	color: #000000;
	margin-top: 5%;
	text-align: center;
	text-transform: uppercase;
	letter-spacing: 4px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<form class="form-horizontal" role="form">
			<h2 class="text-center">Đăng kí</h2>
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">Họ*</label>
				<div class="col-sm-9">
					<input type="text" id="firstName" placeholder="Họ"
						class="form-control" autofocus required />
				</div>
			</div>
			<div class="form-group">
				<label for="middleName" class="col-sm-3 control-label">Tên
					lót</label>
				<div class="col-sm-9">
					<input type="text" id="lastName" placeholder="Tên lót"
						class="form-control" autofocus />
				</div>
			</div>
			<div class="form-group">
				<label for="lastName" class="col-sm-3 control-label">Tên*</label>
				<div class="col-sm-9">
					<input type="text" id="lastName" placeholder="Tên"
						class="form-control" autofocus required />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email* </label>
				<div class="col-sm-9">
					<input type="email" id="email" placeholder="Email"
						class="form-control" name="email" required />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Mật
					khẩu*</label>
				<div class="col-sm-9">
					<input type="password" id="password" placeholder="Mật khẩu"
						class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Xác
					nhận mật khẩu*</label>
				<div class="col-sm-9">
					<input type="password" id="password"
						placeholder="Xác nhận mật khẩu" class="form-control" required />
				</div>
			</div>

			<div class="form-group">
				<label for="phoneNumber" class="col-sm-3 control-label">Số
					điện thoại</label>
				<div class="col-sm-9">
					<input type="phoneNumber" id="phoneNumber"
						placeholder="Số điện thoại" class="form-control" required />
					<span class="help-block">Số điện
						thoại của bạn sẽ không bị tiết lộ ở bất cứ đâu</span>
				</div>
			</div>
			<div class="form-group">
				<label for="faculty" class="col-sm-3 control-label">Khoa</label>
				<div class="col-sm-9">
					<select id="faculty" name="faculty" class="form-control" size="1">
						<option value="Công nghệ thông tin">Công nghệ thông tin</option>
						<option value="Thực phẩm">Thực phẩm</option>
						<option value="Điện - Điện tử">Điện - Điện tử</option>
						<option value="Ngôn ngữ anh">Ngôn ngữ anh</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="branch" class="col-sm-3 control-label">Chuyên
					ngành</label>
				<div class="col-sm-9">
					<select id="branch" name="branch" class="form-control" size="1">
						<option value="Công nghệ phần mềm">Công nghệ phần mềm</option>
						<option value="Hệ thống thông tin">Hệ thống thông tin</option>
						<option value="An ninh mạng">An ninh mạng</option>
						<option value="Trí tuệ nhân tạo">Trí tuệ nhân tạo</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<span class="help-block">*Phần bắt buộc</span>
				</div>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Đăng
				kí</button>
		</form>
	</div>
</body>
</html>

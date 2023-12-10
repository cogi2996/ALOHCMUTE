<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">Quên Mật Khẩu</div>
					<div class="card-body">
						<!-- HTML -->
						<form>
							<div class="form-group">
								<label for="email">Email</label> <input type="email"
									class="form-control" id="email" name="email" required />
							</div>
							<button class="btn btn-primary">Gửi Email Đặt Lại Mật
								Khẩu</button>
							<p id="successMessage" style="display: none; color: green;">Email
								đã được gửi thành công!</p>
							<p id="errorMessage" style="display: none; color: red;">Gửi
								email thất bại. Vui lòng thử lại sau!</p>
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script type="module"
		src='<c:url value = "/templates/login/script/forgotPass.js"></c:url>'></script>
</body>
</html>
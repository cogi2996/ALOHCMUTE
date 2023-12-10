<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="card card-hire ">
		<div class="row g-0">
			<div class="col-md-2">
				<img
					src="https://career.fpt-software.com/wp-content/uploads/wp-jobhunt-users/FPT-Software_new-01-3-180x135.png"
					class="img-logo" alt="">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title">Data Analyst</h5>
					<p class="card-text" id="business-name">FPT Ho Chi Minh City 1</p>
					<p class="card-text" id="address">Đường D1, Đ. D1, Phường Tân
						Phú, Quận 9, TP HCM</p>
					<p class="card-text" id="money">Salary: 2000$ - 4000$</p>
					<p class="card-text" id="time-update">
						<small class="text-body-secondary">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
			<div class="col-md-2 icons">
				<ion-icon class="send icon" name="navigate-outline"></ion-icon>

				<ion-icon class="close icon" name="close-outline"></ion-icon>
			</div>
		</div>
	</div>

	<div class="card card-hire ">
		<div class="row g-0">
			<div class="col-md-2">
				<img
					src="https://career.fpt-software.com/wp-content/uploads/wp-jobhunt-users/FPT-Software_new-01-3-180x135.png"
					class="img-logo" alt="">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title">Data Analyst</h5>
					<p class="card-text" id="business-name">FPT Ho Chi Minh City 2</p>
					<p class="card-text" id="address">Đường D1, Đ. D1, Phường Tân
						Phú, Quận 9, TP HCM</p>
					<p class="card-text" id="money">Salary: 2000$ - 4000$</p>
					<p class="card-text" id="time-update">
						<small class="text-body-secondary">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
			<div class="col-md-2 icons">
				<ion-icon class="send icon" name="navigate-outline"></ion-icon>

				<ion-icon class="close icon" name="close-outline"></ion-icon>
			</div>
		</div>

		<script>
			document.addEventListener('DOMContentLoaded', function() {
				// Thêm sự kiện click cho tất cả các icon close
				document.querySelectorAll('.close').forEach(
						function(icon) {
							icon.addEventListener('click', function() {
								// Tìm card chứa icon close và toggle class js-hidden-card
								icon.closest('.card').classList
										.toggle('js-hidden-card');
							});
						});
			});
			document.querySelectorAll('.send').forEach(function(locationIcon) {
				locationIcon.addEventListener('click', function() {
					// Chuyển màu và làm mờ nút
					locationIcon.style.color = '#cccccc';
					locationIcon.style.pointerEvents = 'none';
				})
			});
		</script>



	</div>
</body>
</html>
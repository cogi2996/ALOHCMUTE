<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="card shadow border-0 mb-7">
	<div class="card-header">
		<h5 class="mb-0">UPDATE USER</h5>
	</div>
	<div class="table-responsive">
		<form action="update" method="post">
			<input name="userID" value="${user.getUserID()}" hidden="">
			<div class="form-group">
				<label for="lastName">Họ</label> <input type="text"
					class="form-control" id="lastName" value="${user.getLastName()}"
					name="lastName" placeholder="Nhập họ">
			</div>
			<div class="form-group">
				<label for="midName">Tên lót </label> <input type="text"
					class="form-control" id="midName" name="midName"
					value="${user.getMidName()}" placeholder="Nhập tên lót ">
			</div>
			<div class="form-group">
				<label for="firstName">Tên</label> <input type="text"
					class="form-control" id="firstName" name="firstName"
					value="${user.getFirstName()}" placeholder="Nhập tên ">
			</div>
			<div class="form-group">
				<label for="mobile">Số điện thoại</label> <input type="text"
					class="form-control" id="mobile" name="mobile"
					value="${user.getMobile()}" placeholder="Nhập số điện thoại ">
			</div>
			<div class="form-group">
				<label for="address">Địa chỉ </label> <input type="text"
					class="form-control" id="address" value="${user.getAddress()}"
					name="address" placeholder="Nhập địa chỉ ">
			</div>
			<div class="form-group">
				<label for="position">Chức vụ </label> <input type="text"
					class="form-control" id="position" value="${user.getPosition()}"
					name="position" placeholder="Nhập chức vụ">
			</div>
			<div class="form-group">
				<label for="workPlace">Nơi làm việc </label> <input type="text"
					class="form-control" id="workPlace" value="${user.getWorkPlace()}"
					name="workPlace" placeholder="Nhập nơi làm việc">
			</div>

			<div class="form-group">
				<label for="avatar">Ảnh đại diện</label> <input type="text"
					class="form-control" name="avatar" id="avatar"
					value="${user.getAvatar()}" />
			</div>

			<button type="submit" class="btn btn-default">Sửa</button>
			<button type="reset" class="btn btn-primary">Hủy</button>
		</form>
	</div>

</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-xl px-4 mt-4">
		<!-- Account page navigation-->

		<hr class="mt-0 mb-4" />
		<div class="row">
			<div class="col-xl-4">
				<!-- Profile picture card-->
				<div class="card mb-4 mb-xl-0">
					<div class="card-header">Profile Picture</div>
					<div class="card-body text-center">
						<!-- Profile picture image-->
						<img class="img-account-profile rounded-circle mb-2"
							src="${user.avatar}" alt=""
							style="width: 160px; height: 160px; object-fit: cover;">
						<!-- Profile picture help block-->
						<div class="small font-italic text-muted mb-4">JPG hoặc PNG
							không quá 5 MB</div>
						<!-- Profile picture upload button-->
						<div class="form-group">
							 <input type="file"
								class="form-control" id="image">
						</div>
					</div>

				</div>
			</div>
			<div class="col-xl-8">
				<!-- Account details card-->
				<div class="card mb-4">
					<div class="card-header">Account Details</div>
					<div class="card-body">
						<form id="updateForm">
							<!-- Form Row-->
							<div class="row gx-3 mb-3">
								<!-- Form Group (last name)-->
								<div class="col-md-4">
									<label class="small mb-1" for="inputLastName"> Họ</label> <input
										class="form-control" id="inputLastName" type="text"
										placeholder="Enter your last name" value="${user.lastName}"
										name="lastName" />
								</div>


								<!-- Form Group (last name)-->
								<div class="col-md-4">
									<label class="small mb-1" for="inputLastName">Tên đệm</label> <input
										class="form-control" id="inputLastName" type="text"
										placeholder="Enter your last name" value="${user.midName}"
										name="midName" />
								</div>
								<!-- Form Group (first name)-->
								<div class="col-md-4">
									<label class="small mb-1" for="inputFirstName">Tên</label> <input
										class="form-control" id="inputFirstName" type="text"
										placeholder="Enter your first name" value="${user.firstName}"
										name="firstName" />
								</div>
							</div>
							<!-- Form Row        -->
							<div class="row gx-3 mb-3">
								<!-- Form Group (organization name)-->
								<div class="col-md-6">
									<label class="small mb-1" for="inputOrgName">Khoa</label> <input
										class="form-control" id="inputOrgName" type="text"
										placeholder="Enter your organization name"
										value="${user.workPlace}" name="workPlace" />
								</div>
								<!-- Form Group (location)-->
								<div class="col-md-6">
									<label class="small mb-1" for="inputLocation">Ngành</label> <input
										class="form-control" id="inputLocation" type="text"
										placeholder="Enter your location" value="${user.position}"
										name="position" />
								</div>
							</div>
							<!-- Form Group (email address)-->
							<div class="mb-3">
								<label class="small mb-1" for="inputEmailAddress">Địa
									chi</label> <input class="form-control" id="inputEmailAddress"
									type="adress" placeholder="Nhập địa chỉ của bạn"
									value="${user.address}" name="address" />
							</div>
							<!-- Form Group (email address)-->
							<div class="mb-3">
								<label class="small mb-1" for="inputEmailAddress">Tiểu
									sử</label> <input class="form-control" id="inputEmailAddress"
									type="text" placeholder="Hãy cho mọi người hiểu thêm về bạn"
									value="${user.biography}" name="biography" />
							</div>
							<!-- Form Row-->
							<div class="row gx-3 mb-3">
								<!-- Form Group (phone number)-->
								<div class="col-md-6">
									<label class="small mb-1" for="inputPhone">Số điện
										thoại</label> <input class="form-control" id="inputPhone" type="tel"
										placeholder="Enter your phone number" value="${user.mobile}"
										name="mobile" />
								</div>

							</div>
							<!-- Save changes button-->
							<button class="btn btn-primary" type="submit">Cập nhật</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="module"
		src='<c:url value = "/templates/user/script/editProfile.js"></c:url>'></script>
</body>
</html>
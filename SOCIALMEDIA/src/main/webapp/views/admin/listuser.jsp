<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<!-- Phần head của trang -->
</head>
<body>
	<div class="card shadow border-0 mb-7">
		<div class="card-header">
			<h5 class="mb-0">LIST USER</h5>
		</div>
		<div class="row justify-content-center">
			<div class="col-12 col-md-10 col-lg-8">
				<form class="card card-sm">
					<div class="card-body row no-gutters align-items-center">
						<div class="col-auto">
							<i class="fas fa-search h4 text-body"></i>
						</div>
						<!--end of col-->
						<div class="col">
							<input
								id="searchInput"
								class="form-control form-control-lg form-control-borderless"
								type="search" placeholder="Search username">
						</div>
						<!--end of col-->
						<div class="col-auto">
							<button class="btn btn-lg btn-success" onclick="searchWithKeyword()">Search</button>
						</div>
						<!--end of col-->
					</div>
				</form>
			</div>
		</div>
		<div class="table-responsive">
			<table class="table table-hover table-nowrap">
				<thead class="thead-light">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Phone</th>
						<th scope="col">Address</th>
						<th scope="col">Position</th>
						<th scope="col">WorkPlace</th>
						<th scope="col">Join Date</th>
						<th scope="col">Last Login</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<c:forEach var="item" items="${listUser}">
					<tbody>
						<tr>
							<td>${item.getUserID()}</td>
							<td><img alt="..."
								src="${item.getAvatar()}"
								class="avatar avatar-sm rounded-circle me-2"> <a
								class="text-heading font-semibold"
								href="profile?id=${item.getUserID()}"> ${item.getLastName()}
									${item.getMidName()} ${item.getFirstName()} </a></td>
							<td>${item.getMobile() }</td>
							<td>${item.getAddress() }</td>
							<td>${item.getPosition() }</td>
							<td>${item.getWorkPlace() }</td>
							<td>${item.getCreateDate()}</td>
							<td>${item.getLastLogin()}</td>
							<td class="text-end"><a
								href="delete?id=${item.getUserID()}"
								class="btn btn-sm btn-neutral">Delete</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
		<div class="card-footer border-0 py-5">
			<span class="text-muted text-sm">Showing ${countAll} users</span>
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:forEach begin="1" end="${endP}" var="i">
						<li class="page-item"><a class="page-link"
							href="listuser?index=${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>
	<script>
		// Hàm lấy dữ liệu và chuyển hướng
		function searchWithKeyword() {
			// Lấy giá trị từ trường input
			var keyword = document.getElementById("searchInput").value;

			// Chuyển hướng với keyword
			href = "/SOCIALMEDIA/admin-manage/user/searchUser?keyword="
					+ encodeURIComponent(keyword) + "&index=1";
		}
		
	</script>
		<script type="module"
		src='<c:url value = "/templates/navigation/script/navigationAdmin.js"></c:url>'></script>
</body>
</html>



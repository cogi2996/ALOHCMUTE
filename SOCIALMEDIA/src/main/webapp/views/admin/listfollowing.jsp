<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card shadow border-0 mb-7">
	<div class="card-header">
		<h5 class="mb-0">LIST FOLLOWING</h5>
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
				</tr>
			</thead>
			<c:forEach var="item" items="${listFollowing}">
				<tbody>
					<tr>
						<td>${item.getUserID()}</td>
						<td><img alt="..."
							src="${item.getAvatar() }"
							class="avatar avatar-sm rounded-circle me-2">
								${item.getLastName()} ${item.getMidName()}
								${item.getFirstName()}</td>
						<td>${item.getMobile() }</td>
						<td>${item.getAddress() }</td>
						<td>${item.getPosition() }</td>
						<td>${item.getWorkPlace() }</td>
						<td>${item.getCreateDate()}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<div class="card-footer border-0 py-5">
		<span class="text-muted text-sm">${countFollowing } following</span>
<!-- 		<nav aria-label="Page navigation example"> -->
<!-- 			<ul class="pagination"> -->
<%-- 				<c:forEach begin="1" end="${endP}" var="i"> --%>
<%-- 					<li class="page-item"><a class="page-link" href="listuser?index=${i}">${i}</a></li> --%>
<%-- 				</c:forEach> --%>
<!-- 			</ul> -->
<!-- 		</nav> -->
	</div>
</div>

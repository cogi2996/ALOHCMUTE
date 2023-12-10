<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card shadow border-0 mb-7">
	<div class="card-header">
		<h5 class="mb-0">RESULT FIND GROUPS</h5>
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
							class="form-control form-control-lg form-control-borderless"
							type="search" placeholder="${keyword}">
					</div>
					<!--end of col-->
					<div class="col-auto">
						<button class="btn btn-lg btn-success">Search</button>
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
					<th scope="col">GROUP NAME</th>
					<th scope="col">CREATE TIME</th>
					<th scope="col">CREATER ID</th>
					<th scope="col">CREATER NAME</th>	
					<th scope="col">Action</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${listGroup}">
				<tbody>
					<tr>
						<td>${item.getGroupID()}</td>
						<td>${item.getGroupName() }</td>
						<td>${item.getCreateTime() }</td>
						<td><img alt="..."
								src="${item.getAdmin().getAvatar()}"
								class="avatar avatar-sm rounded-circle me-2">${item.getAdmin().getUserID() }</td>
						<td class="text-heading font-semibold">${item.getAdmin().getLastName()}
								${item.getAdmin().getMidName()} ${item.getAdmin().getFirstName()}</td>
						<td><a
							href="delete?id=${item.getGroupID()}"
							class="btn btn-sm btn-neutral">Delete</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<div class="card-footer border-0 py-5">
		<span class="text-muted text-sm">${countAll } groups</span>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:forEach begin="1" end="${endP}" var="i">
					<li class="page-item"><a class="page-link" href="searchGroup?keyword=${keyword}&index=${i}">${i}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</div>
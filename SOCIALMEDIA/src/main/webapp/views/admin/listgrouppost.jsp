<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card shadow border-0 mb-7">
	<div class="card-header">
		<h5 class="mb-0">LIST GROUP POSTS</h5>
	</div>
	<div class="table-responsive">
		<table class="table table-hover table-nowrap">
			<thead class="thead-light">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Content</th>
					<th scope="col">Create Time</th>
					<th scope="col">Update Time</th>
					<th scope="col">Group ID</th>
					<th scope="col">Group Name</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${listPost}">
				<tbody>
					<tr>
						<td>${item.getGroupPostID()}</td>
						<td style="white-space: pre-line;">${item.getGroupPostText() }</td>
						<td>${item.getGroupPostCreateTime() }</td>
						<td>${item.getGroupPostUpdateTime() }</td>
						<td>${item.getGroup().getGroupID()}</td>
						<td>${item.getGroup().getGroupName()}</td>
						<td>
							<a href="delete?id=${item.getGroupPostID()}" class="btn btn-sm btn-neutral">Delete</a>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<div class="card-footer border-0 py-5">
		<span class="text-muted text-sm">${countPost } posts of GROUP</span>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:forEach begin="1" end="${endP}" var="i">
					<li class="page-item"><a class="page-link" href="listgrouppost?index=${i}">${i}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</div>
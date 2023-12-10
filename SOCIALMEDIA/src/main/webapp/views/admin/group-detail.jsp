<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card shadow border-0 mb-7">
	<div class="card-header">
		<h5 class="mb-0">GROUP DETAIL</h5>
	</div>
	<div class="table-responsive">
		<table class="table table-hover table-nowrap">
			<thead class="thead-light">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">GROUP NAME</th>
					<th scope="col">CREATE TIME</th>
					<th scope="col">MEMBER QUANTITY</th>
					<th scope="col">CREATER ID</th>
					<th scope="col">CREATER NAME</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${group.getGroupID()}</td>
					<td>${group.getGroupName() }</td>
					<td>${group.getCreateTime() }</td>
					<td>${group.getMember().size()}</td>
					<td>${group.getAdmin().getUserID() }</td>
					<td>${group.getAdmin().getLastName()}
						${group.getAdmin().getMidName()} ${group.getAdmin().getFirstName()}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>



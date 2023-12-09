<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card shadow border-0 mb-7">
	<div class="card-header">
		<h5 class="mb-0">LIST USER</h5>
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
					<th scope="col">Friends</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${listUser}">
				<tbody>
					<tr>
						<td>${item.getUserID()}</td>
						<td><img alt="..."
							src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
							class="avatar avatar-sm rounded-circle me-2"> <a
							class="text-heading font-semibold" href="#">
								${item.getLastName()} ${item.getMidName()}
								${item.getFirstName()} </a></td>
						<td>${item.getMobile() }</td>
						<td>${item.getAddress() }</td>
						<td>${item.getPosition() }</td>
						<td>${item.getWorkPlace() }</td>
						<td>${item.getCreateDate()}</td>
						<td>${item.getLastLogin()}</td>
						<td class="text-end"><a href="following?id=${item.getUserID()}"
							class="btn btn-sm btn-neutral">Following</a><a
							href="follower?id=${item.getUserID()}"
							class="btn btn-sm btn-neutral">Follower</a></td>
						<td class="text-end"><a href="update?id=${item.getUserID()}"
							class="btn btn-sm btn-neutral">Update</a><a
							href="delete?id=${item.getUserID()}"
							class="btn btn-sm btn-neutral">Delete</a></td>
					</tr>
				</tbody>
			</c:forEach>
			<%-- <tbody>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img alt="..."
						src="https://images.unsplash.com/photo-1502823403499-6ccfcf4fb453?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80"
						class="avatar avatar-sm rounded-circle me-2"> <a
						class="text-heading font-semibold" href="#"> Jason Martinez </a></td>
					<td>0123456789</td>
					<td>Ho Chi Minh</td>
					<td>Bi thu</td>
					<td>Cong nghe thong tin</td>
					<td>Feb 15, 2023</td>
					<td class="text-end"><a href="#"
						class="btn btn-sm btn-neutral">View</a>
						<button type="button" onclick="showSweetAlert()"
							class="btn btn-sm btn-square btn-neutral text-danger-hover">
							<i class="bi bi-trash"></i>
						</button></td>
				</tr>
			</tbody> --%>
		</table>
	</div>
	<div class="card-footer border-0 py-5">
		<span class="text-muted text-sm">Showing 10 users</span>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:forEach begin="1" end="${endP}" var="i">
					<li class="page-item"><a class="page-link" href="listuser?index=${i}">${i}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<link
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
		rel="stylesheet" />

	<!-- List group -->
	<section class="group" style="margin-top: 39px">
		<div class="card social-tabs"
			style="width: 100%; align-items: center; margin-bottom: 20px; border: 1px solid rgba(0,0,0,.125);">
			<ul class="nav nav-tabs md-tabs tab-timeline" role="tablist"
				style="height: 40px; margin-top: 25px;">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href=<c:url value = "listgroup"/> role="tab">
						All Groups </a>
					<div class="slide"></div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"					
					href="/SOCIALMEDIA/group/allGroup/mygroup?userID=user4" role="tab">My Groups</a>
				
					<div class="slide"></div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href=<c:url value = "creategroup"/> data-bs-toggle="modal"
					data-bs-target="#creategroup" data-toggle="tab" role="tab">Create
						a Group</a>
					<div class="slide"></div></li>
				<li>
					<form class="navbar-form pull-right flex-row float-right"
						style="display: flex; justify-content: flex-end">
						<div style="max-width: 470px" class="input-group">
							<input type="text" id="groupName" name="groupName"
								placeholder="Search" class="form-control" />
							<button type="submit"
								formaction="/SOCIALMEDIA/group/allGroup/searchgroup?groupName=${groupName}"
								formmethod="get">Tìm kiếm</button>
						</div>
					</form>
				</li>
			</ul>
		</div>

		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8 col-lg-offset-2">
					<!-- foreach begin -->
					<c:forEach var="item" items="${listGroup}">
						<div class="group-box full-width">
							<div class="group-body">
								<img class="img-responsive img-circle"
									src="https://bootdey.com/img/Content/avatar/avatar1.png" alt />
								<div class="name-box">
									<!-- Group Name -->
									<!--<h7>${item.groupName}</h7>-->
									<a
										href="/SOCIALMEDIA/grouppost/allgrouppost?groupID=${item.groupID}">
										<h7>${item.groupName}</h7>
									</a>
									<!-- Group ID
                <span>@vannessa</span> -->
									<div class="group-base">
										<ul class="list-group">
											<li class="list-group-item full-width">-->
												<div class="pull-left" style="margin-right: 0px">
													<span>Nhóm ${item.numberOfFollower} thành viên </span>
												</div>
									</div>
								</div>
								<span><a href class="btn btn-info btn-sm"> Follow</a></span>
							</div>
						</div>
					</c:forEach>
					<!-- foreach end -->
				</div>
			</div>
		</div>

		<!-- Pagination 

		<div class="text-center mt-3 mt-sm-3 fixed-bottom ">
			<ul class="pagination justify-content-center mb-0">
				<li class="page-item disabled"><span class="page-link">Prev</span>
				</li>
				<li class="page-item active" aria-current="page"><span
					class="page-link">1 </span> <span class="sr-only">(current)</span></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">...</a></li>
				<li class="page-item"><a class="page-link" href="#">25</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</div>-->
	</section>

	<!-- Add new group form BEGIN-->
	<div class="modal" id="creategroup" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Create Group</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div>
					<!-- tin begin -->
						<form action="creategroup" method="post">
							<!-- 2 column grid layout with text inputs for the Group ID and Creater ID
							<div class="row mb-4">
								<div class="col">
									<div data-mdb-input-init class="form-outline">
										<label class="form-label" for="creategroup">Group ID</label> <input
											type="text" name="groupID" id="creategroup" class="form-control" />
									</div>
								</div>
								<div class="col">
									<div data-mdb-input-init class="form-outline">
										<label class="form-label" for="creategroup">Creater ID</label>
										<input readonly="readonly" type="text" id="creategroup"
											class="form-control" name="CreaterID" />
									</div>
								</div>
							</div>-->

							<!-- Group Name input -->
							<div data-mdb-input-init class="form-outline mb-4">
								<label class="form-label" for="creategroup">Group Name</label> <input
									type="text" name="groupName" id="creategroup" class="form-control" />
							</div>

							<!-- Create Time input
							<div data-mdb-input-init class="form-outline mb-4">
								<label class="form-label" for="creategroup">Create Time</label>
								<input type="password" id="creategroup" class="form-control" />
							</div>-->

							<!-- Submit button 
							<button data-mdb-ripple-init type="button"
								class="btn btn-primary btn-block mb-4">Add new Group</button>-->
							<input type="submit" value="Add new Group" style="background-color: #0074cc; color: white;">
						</form>
					</div>
						<!-- tin end -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<!--<button type="button" class="btn btn-primary">Save changes</button>-->
				</div>
			</div>
		</div>
	</div>
	<!-- Add new group form END-->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	<script type="text/javascript"></script>
</body>
</html>
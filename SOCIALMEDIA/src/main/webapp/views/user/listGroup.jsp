<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="card social-tabs" style="width: 100%">
			<ul class="nav nav-tabs md-tabs tab-timeline" role="tablist" style="margin-top:4rem">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="#allgroup" role="tab">All Groups</a>
					<div class="slide"></div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#mygroup" role="tab">My Groups</a>
					<div class="slide"></div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#creategroup" role="tab">Create a Group</a>
					<div class="slide"></div></li>
				<li>
					<form class="navbar-form pull-right flex-row float-right"
						style="display: flex; justify-content: flex-end">
						<div style="max-width: 470px" class="input-group">
							<input type="text" id="srch-term" name="srch-term"
								placeholder="Search" class="form-control" />
						</div>
					</form>
				</li>
			</ul>
		</div>

		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8 col-lg-offset-2">
					<!-- foreach begin -->
					<div class="group-box full-width">
						<div class="group-body">
							<img class="img-responsive img-circle"
								src="https://bootdey.com/img/Content/avatar/avatar1.png" alt />
							<div class="name-box">
								<!-- Group Name -->
								<h7>Group Name</h7>
								<!-- Group ID
                <span>@vannessa</span> -->
								<div class="group-base">
									<!-- <ul class="list-group">
                    <li class="list-group-item full-width"> -->
									<div class="pull-left" style="margin-right: 0px">
										<span> 14,000 follower </span>
									</div>
									<!-- </li>
                  </ul> -->
								</div>
							</div>
							<span><a href class="btn btn-info btn-sm"> Follow</a></span>
						</div>
					</div>
				</div>
				<!-- foreach end -->
			</div>
		</div>

		<!-- Pagination -->

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
		</div>
	</section>

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
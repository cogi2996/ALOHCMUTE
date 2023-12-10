<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Group Home left bar begin -->
	<!-- <div class=""> -->

	<div class="container-fluid" style="margin-top: 56px">
		<div class="row">
			<div class="col-lg-2">
				<div class=" col-md-2 card float-left" style="width: fit-content;">
					<div class="card-body">
						<!-- Group info -->
						<div class="d-flex flex-column align-items-center text-center"
							style="padding-bottom: 2rem; border-bottom: 1px solid #a3a3a3;">
							<!-- <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Admin" -->
							<!-- class="rounded-circle bg-primary" width="110"> -->
							<div class="mt-3">
								<h4>${group.groupName}</h4>
								<p class="text-secondary mb-1">Nhóm ${countUserGroup} thành viên</p>
								<p class="text-muted font-size-sm">Bay Area, San Francisco,CA</p>
								<button class="btn btn-primary">Follow</button>
								<!-- <button class="btn btn-outline-primary">Message</button> -->
							</div>
						</div>
						<!-- Leftbar end -->
					</div>
				</div>
			</div>
			<div class="col-xl-9 col-lg-8 col-md-8 col-xs-12 ">
				<div class="card social-tabs">
					<ul class="nav nav-tabs md-tabs tab-timeline" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#post" role="tab">Post</a>
							<div class="slide"></div></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#about" role="tab">About</a>
							<div class="slide"></div></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="/SOCIALMEDIA/timkiem/listusergroup?groupID=${groupID}" role="tab">Friends</a>
							<div class="slide"></div></li>
						<li>
							<form class="navbar-form pull-right flex-row float-right"
								style="display: flex; justify-content: flex-end">
								<div style="max-width: 470px;" class="input-group">
									<input type="text" id="srch-term" name="srch-term"
										placeholder="Search" class="form-control">
								</div>
							</form>
						</li>
					</ul>

				</div>
				<div class="">
					<div class="row justify-content-center">
						<div class="col-md-6 grid-margin">
							<div class="card rounded">
								<div class="card-header">
									<div class="d-flex align-items-center justify-content-between">
										<div class="d-flex align-items-center">
											<img class="img-xs rounded-circle"
												src="https://bootdey.com/img/Content/avatar/avatar6.png" alt>
											<div class="ml-2">
												<p>Mike Popescu</p>
												<p class="tx-11 text-muted">1 min ago</p>
											</div>
										</div>
										<div class="dropdown">
											<button class="btn p-0" type="button"
												id="dropdownMenuButton2" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false">
												<svg xmlns="http://www.w3.org/2000/svg" width="24"
													height="24" viewBox="0 0 24 24" fill="none"
													stroke="currentColor" stroke-width="2"
													stroke-linecap="round" stroke-linejoin="round"
													class="feather feather-more-horizontal icon-lg pb-3px">
                                                    <circle cx="12"
														cy="12" r="1"></circle>
                                                    <circle cx="19"
														cy="12" r="1"></circle>
                                                    <circle cx="5"
														cy="12" r="1"></circle>
                                                </svg>
											</button>
											<div class="dropdown-menu"
												aria-labelledby="dropdownMenuButton2">
												<a class="dropdown-item d-flex align-items-center" href="#">
													<svg xmlns="http://www.w3.org/2000/svg" width="24"
														height="24" viewBox="0 0 24 24" fill="none"
														stroke="currentColor" stroke-width="2"
														stroke-linecap="round" stroke-linejoin="round"
														class="feather feather-meh icon-sm mr-2">
                                                        <circle cx="12"
															cy="12" r="10"></circle>
                                                        <line x1="8"
															y1="15" x2="16" y2="15"></line>
                                                        <line x1="9"
															y1="9" x2="9.01" y2="9"></line>
                                                        <line x1="15"
															y1="9" x2="15.01" y2="9"></line>
                                                    </svg> <span class>Unfollow</span>
												</a> <a class="dropdown-item d-flex align-items-center" href="#">
													<svg xmlns="http://www.w3.org/2000/svg" width="24"
														height="24" viewBox="0 0 24 24" fill="none"
														stroke="currentColor" stroke-width="2"
														stroke-linecap="round" stroke-linejoin="round"
														class="feather feather-corner-right-up icon-sm mr-2">
                                                        <polyline
															points="10 9 15 4 20 9"></polyline>
                                                        <path
															d="M4 20h7a4 4 0 0 0 4-4V4"></path>
                                                    </svg> <span class>Go
														to post</span>
												</a> <a class="dropdown-item d-flex align-items-center" href="#">
													<svg xmlns="http://www.w3.org/2000/svg" width="24"
														height="24" viewBox="0 0 24 24" fill="none"
														stroke="currentColor" stroke-width="2"
														stroke-linecap="round" stroke-linejoin="round"
														class="feather feather-share-2 icon-sm mr-2">
                                                        <circle cx="18"
															cy="5" r="3"></circle>
                                                        <circle cx="6"
															cy="12" r="3"></circle>
                                                        <circle cx="18"
															cy="19" r="3"></circle>
                                                        <line x1="8.59"
															y1="13.51" x2="15.42" y2="17.49">
                                                        </line>
                                                        <line x1="15.41"
															y1="6.51" x2="8.59" y2="10.49">
                                                        </line>
                                                    </svg> <span class>Share</span>
												</a> <a class="dropdown-item d-flex align-items-center" href="#">
													<svg xmlns="http://www.w3.org/2000/svg" width="24"
														height="24" viewBox="0 0 24 24" fill="none"
														stroke="currentColor" stroke-width="2"
														stroke-linecap="round" stroke-linejoin="round"
														class="feather feather-copy icon-sm mr-2">
                                                        <rect x="9"
															y="9" width="13" height="13" rx="2" ry="2">
                                                        </rect>
                                                        <path
															d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1">
                                                        </path>
                                                    </svg> <span class>Copy
														link</span>
												</a>
											</div>
										</div>
									</div>
								</div>
								<div class="card-body">
									<p class="mb-3 tx-14">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Accusamus minima delectus nemo
										unde quae recusandae assumenda.</p>
									<img class="img-fluid"
										src="https://bootdey.com/img/Content/avatar/avatar6.png" alt>
								</div>
								<div class="card-footer">
									<div class="d-flex post-actions">
										<a href="javascript:;"
											class="d-flex align-items-center text-muted mr-4"> <svg
												xmlns="http://www.w3.org/2000/svg" width="24" height="24"
												viewBox="0 0 24 24" fill="none" stroke="currentColor"
												stroke-width="2" stroke-linecap="round"
												stroke-linejoin="round"
												class="feather feather-heart icon-md">
                                                <path
													d="M20.84 4.61a5.5 5.5 0 0 0-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 0 0-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 0 0 0-7.78z">
                                                </path>
                                            </svg>
											<p class="d-none d-md-block ml-2">Like</p>
										</a> <a href="javascript:;"
											class="d-flex align-items-center text-muted mr-4"> <svg
												xmlns="http://www.w3.org/2000/svg" width="24" height="24"
												viewBox="0 0 24 24" fill="none" stroke="currentColor"
												stroke-width="2" stroke-linecap="round"
												stroke-linejoin="round"
												class="feather feather-message-square icon-md">
                                                <path
													d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z">
                                                </path>
                                            </svg>
											<p class="d-none d-md-block ml-2">Comment</p>
										</a> <a href="javascript:;"
											class="d-flex align-items-center text-muted"> <svg
												xmlns="http://www.w3.org/2000/svg" width="24" height="24"
												viewBox="0 0 24 24" fill="none" stroke="currentColor"
												stroke-width="2" stroke-linecap="round"
												stroke-linejoin="round"
												class="feather feather-share icon-md">
                                                <path
													d="M4 12v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8"></path>
                                                <polyline
													points="16 6 12 2 8 6"></polyline>
                                                <line x1="12" y1="2"
													x2="12" y2="15"></line>
                                            </svg>
											<p class="d-none d-md-block ml-2">Share</p>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	</div>

	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		
	</script>
	<!-- <script type="module" src="/group home/grouphome.js"></script>
    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script> -->
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<body>
	<div class="container">
		<div class="profile-page tx-13">
			<div class="row">
				<div class="col-12 grid-margin">
					<div class="profile-header">
						<div class="cover">
							<div class="gray-shade"></div>
							<figure>
								<img src="https://bootdey.com/img/Content/bg1.jpg"
									class="img-fluid" alt="profile cover" />
							</figure>
							<div
								class="cover-body d-flex justify-content-between align-items-center">
								<div>
									<img class="profile-pic"
										src="${user.avatar}"
										alt="profile" /> <span class="profile-name" data-user-id ="${user.userID}">
										${user.lastName} ${user.midName} ${user.firstName}</span>
								</div>
								<div class="d-none d-md-block">
								<a href='<c:url value = "/editProfile"></c:url>' >
									<button class="btn btn-primary btn-icon-text btn-edit-profile">
										<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
											viewBox="0 0 24 24" fill="none" stroke="currentColor"
											stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round"
											class="feather feather-edit btn-icon-prepend">
                        <path
												d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path>
                        <path
												d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path>
                      </svg>
										
									</button>
										</a>
								</div>
							</div>
						</div>
						<div class="header-links">
							<ul class="links d-flex align-items-center mt-3 mt-md-0">
								<li class="header-link-item d-flex align-items-center active">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-columns mr-1 icon-md">
                      <path
											d="M12 3h7a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-7m0-18H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h7m0-18v18"></path>
                    </svg> <a class="pt-1px d-none d-md-block" href="#">Timeline</a>
								</li>
								<li
									class="header-link-item ml-3 pl-3 border-left d-flex align-items-center">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-user mr-1 icon-md">
                      <path
											d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                      <circle cx="12" cy="7" r="4"></circle>
                    </svg> <a class="pt-1px d-none d-md-block" href="#">${user.getFollowingUsers().size()}
										Following</a>
								</li>
								<li
									class="header-link-item ml-3 pl-3 border-left d-flex align-items-center">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-users mr-1 icon-md">
                      <path
											d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                      <circle cx="9" cy="7" r="4"></circle>
                      <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                      <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
										<span class="text-muted tx-12">${user.getFollowers().size()}</span>
                    </svg> <a class="pt-1px d-none d-md-block" href="#">Follower
								</a>
								</li>
								<li
									class="header-link-item ml-3 pl-3 border-left d-flex align-items-center">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round"
										class="feather feather-image mr-1 icon-md">
                      <rect x="3" y="3" width="18" height="18" rx="2"
											ry="2"></rect>
                      <circle cx="8.5" cy="8.5" r="1.5"></circle>
                      <polyline points="21 15 16 10 5 21"></polyline>
                    </svg> <a class="pt-1px d-none d-md-block" href="#">Photos</a>
								</li>

							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row profile-body">
				<!-- left wrapper start -->
				<div class="d-none d-md-block col-md-4 col-xl-3 left-wrapper">
					<div class="card rounded">
						<div class="card-body">
							<div
								class="d-flex align-items-center justify-content-between mb-2">
								<h6 class="card-title mb-0">Tiểu sử</h6>
								<div class="dropdown">
									<button class="btn p-0" type="button" id="dropdownMenuButton"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
											viewBox="0 0 24 24" fill="none" stroke="currentColor"
											stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round"
											class="feather feather-more-horizontal icon-lg text-muted pb-3px">
                        <circle cx="12" cy="12" r="1"></circle>
                        <circle cx="19" cy="12" r="1"></circle>
                        <circle cx="5" cy="12" r="1"></circle>
                      </svg>
									</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<a class="dropdown-item d-flex align-items-center" href="#">
											<svg xmlns="http://www.w3.org/2000/svg" width="24"
												height="24" viewBox="0 0 24 24" fill="none"
												stroke="currentColor" stroke-width="2"
												stroke-linecap="round" stroke-linejoin="round"
												class="feather feather-edit-2 icon-sm mr-2">
                          <path
													d="M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z"></path>
                        </svg> <span class="">Edit</span>
										</a> <a class="dropdown-item d-flex align-items-center" href="#">
											<svg xmlns="http://www.w3.org/2000/svg" width="24"
												height="24" viewBox="0 0 24 24" fill="none"
												stroke="currentColor" stroke-width="2"
												stroke-linecap="round" stroke-linejoin="round"
												class="feather feather-git-branch icon-sm mr-2">
                          <line x1="6" y1="3" x2="6" y2="15"></line>
                          <circle cx="18" cy="6" r="3"></circle>
                          <circle cx="6" cy="18" r="3"></circle>
                          <path d="M18 9a9 9 0 0 1-9 9"></path>
                        </svg> <span class="">Update</span>
										</a> <a class="dropdown-item d-flex align-items-center" href="#">
											<svg xmlns="http://www.w3.org/2000/svg" width="24"
												height="24" viewBox="0 0 24 24" fill="none"
												stroke="currentColor" stroke-width="2"
												stroke-linecap="round" stroke-linejoin="round"
												class="feather feather-eye icon-sm mr-2">
                          <path
													d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path>
                          <circle cx="12" cy="12" r="3"></circle>
                        </svg> <span class="">View all</span>
										</a>
									</div>
								</div>
							</div>
							<p>${user.biography}</p>
							<div class="mt-3">
								<h6 class="card-title mb-0">Ngày tham gia</h6>
								<p class="text-muted">${user.createDate}</p>
							</div>
							<div class="mt-3">
								<h6 class="card-title mb-0">Khoa</h6>
								<p class="text-muted">${user.workPlace}</p>
							</div>
							<div class="mt-3">
								<h6 class="card-title mb-0">Ngành</h6>
								<p class="text-muted">${user.position}</p>
							</div>

							<div class="mt-3 d-flex social-links">
								<a href="javascript:;"
									class="btn d-flex align-items-center justify-content-center border mr-2 btn-icon github">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-github"
										data-toggle="tooltip" title=""
										data-original-title="github.com/nobleui">
                      <path
											d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22"></path>
                    </svg>
								</a> <a href="javascript:;"
									class="btn d-flex align-items-center justify-content-center border mr-2 btn-icon twitter">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-twitter"
										data-toggle="tooltip" title=""
										data-original-title="twitter.com/nobleui">
                      <path
											d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path>
                    </svg>
								</a> <a href="javascript:;"
									class="btn d-flex align-items-center justify-content-center border mr-2 btn-icon instagram">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-instagram"
										data-toggle="tooltip" title=""
										data-original-title="instagram.com/nobleui">
                      <rect x="2" y="2" width="20" height="20" rx="5"
											ry="5"></rect>
                      <path
											d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path>
                      <line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line>
                    </svg>
								</a>
							</div>
						</div>
					</div>
				</div>
				<!-- left wrapper end -->
				<!-- middle wrapper start -->
				<div class="col-md-8 col-xl-6 middle-wrapper">
					<div class="row">
						<div class="col-md-12 grid-margin">
							<div class="wrapper create-post">
								<a class="create-post__avatar"> <img alt="User avatar"
									src="${user.avatar}" />
								</a> <input class="create-post__input" placeholder="Create Post" />
								<!-- <a class="create-post__link"> <i
									class="fa-solid fa-image icon"></i>
								</a> <a class="create-post__link"> <i
									class="fa-solid fa-link icon"></i>
								</a> -->
								<!-- modal create post -->
								<div class="container create-post__modal">
									<div class="row">
										<div class="col-md-6">
											<div class="card">
												<div class="card-header"
													style="display: flex; justify-content: space-between; align-items: center;">
													<div>Tạo bài viết</div>
													<div class="btn-close"></div>
												</div>
												<div class="card-body form-createPost">
													<form action="/SOCIALMEDIA/api/v1/posts" method="POST">
														<div class="form-group">
															<label for="author">${currentUser.lastName}
																${currentUser.midName} ${currentUser.firstName}</label>
														</div>

														<div class="form-group">
															<label for="content">Nội dung</label>
															<textarea class="form-control" id="content"
																placeholder="Tuấn ơi, bạn đang nghĩ gì thế?"></textarea>
														</div>
														<div class="form-group">
															<label for="image">Ảnh</label> <input type="file"
																class="form-control" id="image" />
														</div>
														<button type="submit" class="btn btn-primary btn-submit"
															style="margin-top: 20px">Đăng</button>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<ul class="list-post">

							</ul>
						</div>
					</div>
				</div>
				<!-- middle wrapper end -->
				<!-- right wrapper start -->
				<div class="d-none d-xl-block col-xl-3 right-wrapper">
					<div class="row">
						<div class="col-md-12 grid-margin">
							<div class="card rounded">
								<div class="card-body">
									<h6 class="card-title">Ảnh</h6>
									<div class="latest-photos">
										<div class="row">
											<div class="col-md-4">
												<figure>
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar1.png"
														alt="" />
												</figure>
											</div>
											<div class="col-md-4">
												<figure>
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar2.png"
														alt="" />
												</figure>
											</div>
											<div class="col-md-4">
												<figure>
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar3.png"
														alt="" />
												</figure>
											</div>
											<div class="col-md-4">
												<figure>
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar4.png"
														alt="" />
												</figure>
											</div>
											<div class="col-md-4">
												<figure>
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar5.png"
														alt="" />
												</figure>
											</div>
											<div class="col-md-4">
												<figure>
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar6.png"
														alt="" />
												</figure>
											</div>
											<div class="col-md-4">
												<figure class="mb-0">
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar7.png"
														alt="" />
												</figure>
											</div>
											<div class="col-md-4">
												<figure class="mb-0">
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar8.png"
														alt="" />
												</figure>
											</div>
											<div class="col-md-4">
												<figure class="mb-0">
													<img class="img-fluid"
														src="https://bootdey.com/img/Content/avatar/avatar9.png"
														alt="" />
												</figure>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12 grid-margin">
							<div class="card rounded">
								<div class="card-body">
									<h6 class="card-title">Đề xuất cho bạn</h6>
									<c:forEach var="user" items="${listSuggestFollow}">
										<div
											class="d-flex justify-content-between mb-2 pb-2 border-bottom">
											<div class="d-flex align-items-center hover-pointer">
												<img class="img-xs rounded-circle" src="${user.avatar}"
													alt="" />
												<div class="ml-2" style="margin-left: 15px">
												<a href="/SOCIALMEDIA/profile?userID=${user.userID}" >${user.lastName}
											${user.midName} ${user.firstName}</a>
													<%-- <p class="font-weight-bold mb-0">${user.lastName}
														${user.midName} ${user.firstName}</p> --%>
													<p class="tx-11 text-muted">${user.workPlace}</p>
												</div>
											</div>
											<button class="btn btn-icon btn__follow "
												data-user-id="${user.userID}">
												<svg xmlns="http://www.w3.org/2000/svg" width="24"
													height="24" viewBox="0 0 24 24" fill="none"
													stroke="currentColor" stroke-width="2"
													stroke-linecap="round" stroke-linejoin="round"
													class="feather feather-user-plus" data-toggle="tooltip"
													title="" data-original-title="Connect">
                          <path
														d="M16 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                          <circle cx="8.5" cy="7" r="4"></circle>
                          <line x1="20" y1="8" x2="20" y2="14"></line>
                          <line x1="23" y1="11" x2="17" y2="11"></line>
                        </svg>
											</button>
										</div>

									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- right wrapper end -->
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<%-- 
	<script type="module"
		src='<c:url value = "/templates/user/script/home.js"></c:url>'></script> --%>
	<script type="module"
		src='<c:url value = "/templates/user/script/profile.js"></c:url>'></script>
	<script type="module"
		src='<c:url value = "/templates/home/script/commentService.js"></c:url>'></script>
</body>
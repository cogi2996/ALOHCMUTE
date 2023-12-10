<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%-- <c:set var="pageSpecificCSS">
	<c:url value="/templates/user/css/suggestFollow.css"/>
</c:set> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<div class="container-fluid" style="margin-top: 56px">
		<div class="row justify-content-between">
			<div class="col-md-2" style="padding: 0; height: 100vh">
				<div class="left-pane col-2 position-fixed shawdow">
					<div class="list-group" data-bs-spy="scroll">
						<a href="#"
							class="list-group-item border-0 py-3 list-group-item-action active">
							<i class="fa-solid fa-newspaper me-2"></i> <span>Feeds</span>
						</a> <a
							href='<c:url value ="/profile?userID=${currentUser.userID}"></c:url>'
							class="list-group-item border-0 py-3 list-group-item-action">
							<i class="fa-solid fa-user me-2"></i> <span>Profiles</span>
						</a> <a href="#"
							class="list-group-item border-0 py-3 list-group-item-action"><i
							class="fa-solid fa-user-group me-2"></i><span>Friends</span></a> <a
							href="#"
							class="list-group-item border-0 py-3 list-group-item-action"><i
							class="fa-solid fa-users me-2"></i><span>Groups</span></a>
					</div>
				</div>
			</div>
			<div class="col-md-6 justify-content-center">
				<div class="wrapper create-post">
					<a class="create-post__avatar"> <img alt="User avatar"
						src="${currentUser.avatar}" />
					</a> <input class="create-post__input" placeholder="Create Post" /> <a
						class="create-post__link"> <i class="fa-solid fa-image icon"></i>
					</a> <a class="create-post__link"> <i class="fa-solid fa-link icon"></i>
					</a>
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
			<div class="col-md-3">

				<!--HÃY THÊM VÀO ĐÂY  -->
				<div class="card rounded">
					<div class="card-body">
						<h6 class="card-title">Đề xuất cho bạn</h6>
						<c:forEach var="user" items="${listSuggestFollow}">
							<div
								class="d-flex justify-content-between mb-2 pb-2 border-bottom">
								<div class="d-flex align-items-center hover-pointer">
									<img class="img-xs rounded-circle" src="${user.avatar}" alt="" />
									<div class="ml-2" style="margin-left: 15px">
										<p class="font-weight-bold mb-0">${user.lastName}
											${user.midName} ${user.firstName}</p>
										<p class="tx-11 text-muted">${user.workPlace}</p>
									</div>
								</div>
								<button class="btn btn-icon btn__follow "
									data-user-id="${user.userID}">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-user-plus"
										data-toggle="tooltip" title="" data-original-title="Connect">
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


	<script
		src='<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></c:url>'></script>
	<script>
		/*  function loadAjax() {
		        var amount = document.getElementsByClassName("post").length;
		        console.log(amount);
		        $.ajax({
		          url: "/SOCIALMEDIA/home/loadAjaxPost",
		          type: "get",
		          data: {
		            exits: amount,
		          },
		          success: function (data) {
		            $(".list-post").append(data);
		           
		          },
		          error: function (xhr) {},
		        });
		      } */
	</script>
	<%-- <script type="module"
		src='<c:url value = "/templates/firebase/firebase.js"></c:url>'></script> --%>
	<script type="module"
		src='<c:url value = "/templates/user/script/home.js"></c:url>'></script>
	<script type="module"
		src='<c:url value = "/templates/home/script/commentService.js"></c:url>'></script>
	<!-- 	<script type="module" src="loadCommentHome.js"></script> -->
</body>
</html>


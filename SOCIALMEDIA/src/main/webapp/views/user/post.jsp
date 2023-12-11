<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid" style="margin-top: 56px">
		<div class="row justify-content-between">
			<div class="col-md-2" style="padding: 0; height: 100vh"></div>
			<div class="col-md-6 justify-content-center">

				<ul class="list-post">
					<li class="wrapper post" data-post-id="20">
						<div class="post__header">
							<div class="main-author">
								<img class="main-author__avatar" alt="Subreddit Icon"
									role="presentation" src="${user.avatar}">
								<div class="d-flex flex-column">
									<p class="main-author__name mb-1">
										<a
											href="/SOCIALMEDIA/profile?userID=KUyTipGNpdVhNj2iLWUuDhqTzmB2">${user.lastName} ${user.midName} ${user.firstName}</a>
									</p>
									<p class="main-author__date text-muted small">22:36</p>
								</div>
							</div>
						</div>



						<p class="sub-author__name"></p>


						<div class="post__content">
							<div class="content-text">${post.userPostText}</div>
							<div class="content-media"
								style="position: relative; display: flex; justify-content: center; align-items: center;">
								<div class="background"
									style="background-image: url(${post.userPostImage}); opacity: 0.1; position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></div>
								<div class="content-media__img"
									style="position: relative; z-index: 1">
									<c:if test="${not empty post.userPostImage}">
										<img src="${post.userPostImage}" alt="" width="500"
											height="500" style="display: block; margin: 0 auto">
									</c:if>

								</div>

							</div>
						</div>
						<div class="post__feedback">
							<button type="button"
								class="feedback__btn btn__feedback-like active "
								onclick="handelToggleLike()">
								<i class="fa-solid fa-thumbs-up icon"></i>
								<p>1 like</p>
							</button>
							<button type="button"
								class="feedback__btn post__feedback-comment">
								<i class="fa-regular fa-comment icon"></i>
								<p>Comment</p>
							</button>

							<button type="button" class="feedback__btn"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false">
								<i class="fa-solid fa-ellipsis-vertical"></i>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="#">Sao chép</a></li>

								<li><a class="dropdown-item dropdown-item-delete" href="#">Xoá</a>
								</li>
							</ul>
						</div>
						<section class="gradient-custom post__comment d-none">
							<div class="container">
								<div
									class="row d-flex justify-content-center post__comment__list custom-scrollbar">
									<!-- bình luận cha -->

								</div>
							</div>
							<!-- input bình luận cha -->
							<div class="card">
								<div
									class="mt-3 d-flex flex-row align-items-center p-3 form-color">
									<img src="" width="50" class="rounded-circle mr-2"
										style="margin-right: 10px"> <input type="text"
										class="form-control input_comment"
										placeholder="  Viết câu trả lời...">
								</div>
							</div>
						</section>
					</li>
				</ul>
			</div>
			<div class="col-md-2"></div>
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

	<script type="module"
		src='<c:url value = "/templates/user/script/home.js"></c:url>'></script>
	<script type="module"
		src='<c:url value = "/templates/home/script/commentService.js"></c:url>'></script>
	<script>
      // JavaScript to prevent cursor blinking on click for input
      const createPostInput = document.querySelector(".create-post__input");
      createPostInput.addEventListener("mousedown", (e) => {
        e.preventDefault(); // Prevents the default focus behavior
      });
    </script>
</body>
</html>

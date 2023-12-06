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
						</a> <a href="#"
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
						src="https://styles.redditmedia.com/t5_6tgdza/styles/profileIcon_snoob64c08dd-9253-4a17-9006-378fff570d44-headshot.png?width=256&amp;height=256&amp;crop=256:256,smart&amp;s=975f806419bee0b32ca65c2dcc6e1a9ef4ad2108" />
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
												<label for="author">Đặng Công Tuấn</label>
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
					<li class="wrapper post" data-post-id="3">
						<div class="post__header">
							<div class="main-author">
								<img class="main-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="main-author__name">KTX ĐHQG TP.HCM</p>
							</div>
							<div class="sub-author">
								<img class="sub-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="sub-author__name">Mỹ Phụng</p>
							</div>
						</div>
						<div class="post__content">
							<div class="content-text">hoàn hôn ở Pải</div>
							<div class="content-media"
								style="position: relative; display: flex; justify-content: center; align-items: center;">
								<div class="background"
									style="background-image: url(https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg); opacity: 0.1; position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></div>
								<div class="content-media__img"
									style="position: relative; z-index: 1">
									<img
										src="https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg"
										alt="" width="500" height="500"
										style="display: block; margin: 0 auto" />
								</div>
							</div>
						</div>
						<div class="post__feedback">
							<button type="button" class="feedback__btn active"
								onclick="handelToggleLike()">
								<i class="fa-solid fa-thumbs-up icon"></i>
								<p>100 Like</p>
							</button>
							<button type="button"
								class="feedback__btn post__feedback-comment">
								<i class="fa-regular fa-comment icon"></i>
								<p>Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-share icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-ellipsis-vertical"></i>
							</button>
						</div>
						<section class="gradient-custom post__comment d-none">
							<div class="container">
								<div
									class="row d-flex justify-content-center post__comment__list custom-scrollbar">
									<!-- bình luận cha -->
									<div class="card post__comment__item d-none">
										<div class="card-body">
											<div class="row">
												<div class="col">
													<div class="d-flex flex-start">
														<img class="rounded-circle shadow-1-strong me-3"
															src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(10).webp"
															alt="avatar" width="65" height="65" />
														<div class="flex-grow-1 flex-shrink-1">
															<div class="comment__container">
																<div>
																	<div
																		class="d-flex justify-content-between align-items-center">
																		<p class="mb-1">
																			Maria Smantha <span class="small">- 2 hours
																				ago</span>
																		</p>
																		<a href="#"><i class="fas fa-reply fa-xs"></i><span
																			class="small"> reply</span></a>
																	</div>
																	<p class="small mb-0">It is a long established fact
																		that a reader will be distracted by the readable
																		content of a page.</p>
																</div>
																<!-- bình luận con -->
																<div class="d-flex flex-start mt-4">
																	<a class="me-3" href="#"> <img
																		class="rounded-circle shadow-1-strong"
																		src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"
																		alt="avatar" width="65" height="65" />
																	</a>
																	<div class="flex-grow-1 flex-shrink-1">
																		<div>
																			<div
																				class="d-flex justify-content-between align-items-center">
																				<p class="mb-1">
																					Simona Disa <span class="small">- 3 hours
																						ago</span>
																				</p>
																			</div>
																			<p class="small mb-0">letters, as opposed to
																				using 'Content here, content here', making it look
																				like readable English.</p>
																		</div>
																	</div>
																</div>

																<div class="d-flex flex-start mt-4">
																	<a class="me-3" href="#"> <img
																		class="rounded-circle shadow-1-strong"
																		src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(32).webp"
																		alt="avatar" width="65" height="65" />
																	</a>
																	<div class="flex-grow-1 flex-shrink-1">
																		<div>
																			<div
																				class="d-flex justify-content-between align-items-center">
																				<p class="mb-1">
																					John Smith <span class="small">- 4 hours ago</span>
																				</p>
																			</div>
																			<p class="small mb-0">the majority have suffered
																				alteration in some form, by injected humour, or
																				randomised words.</p>
																		</div>
																	</div>
																</div>
															</div>
															<!-- inuput text -->
															<div class="card">
																<div
																	class="mt-3 d-flex flex-row align-items-center p-3 form-color">
																	<img
																		src="https://media.licdn.com/dms/image/C4D03AQFTEOiGeGdutQ/profile-displayphoto-shrink_100_100/0/1657024175293?e=1707350400&v=beta&t=8w5gteNGTFSB2Yua7kTDzX5a5Pd6CT5YTPHi-gZIbGQ"
																		width="50" class="rounded-circle mr-2"
																		style="margin-right: 10px" /> <input type="text"
																		class="form-control input_comment"
																		placeholder="  Viết câu trả lời..." />
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
							<!-- input bình luận cha -->
							<div class="card">
								<div
									class="mt-3 d-flex flex-row align-items-center p-3 form-color">
									<img
										src="https://media.licdn.com/dms/image/C4D03AQFTEOiGeGdutQ/profile-displayphoto-shrink_100_100/0/1657024175293?e=1707350400&v=beta&t=8w5gteNGTFSB2Yua7kTDzX5a5Pd6CT5YTPHi-gZIbGQ"
										width="50" class="rounded-circle mr-2"
										style="margin-right: 10px" /> <input type="text"
										class="form-control input_comment"
										placeholder="  Viết câu trả lời..." />
								</div>
							</div>
						</section>
					</li>
					<li class="wrapper post" data-post-id="4">
						<div class="post__header">
							<div class="main-author">
								<img class="main-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="main-author__name">KTX ĐHQG TP.HCM</p>
							</div>
							<div class="sub-author">
								<img class="sub-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="sub-author__name">Mỹ Phụng</p>
							</div>
						</div>
						<div class="post__content">
							<div class="content-text">hoàn hôn ở Pải</div>
							<div class="content-media"
								style="position: relative; display: flex; justify-content: center; align-items: center;">
								<div class="background"
									style="background-image: url(https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg); opacity: 0.1; position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></div>
								<div class="content-media__img"
									style="position: relative; z-index: 1">
									<img
										src="https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg"
										alt="" width="500" height="500"
										style="display: block; margin: 0 auto" />
								</div>
							</div>
						</div>
						<div class="post__feedback">
							<button type="button" class="feedback__btn active"
								onclick="handelToggleLike()">
								<i class="fa-solid fa-thumbs-up icon"></i>
								<p>100 Like</p>
							</button>
							<button type="button"
								class="feedback__btn post__feedback-comment">
								<i class="fa-regular fa-comment icon"></i>
								<p>Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-share icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-ellipsis-vertical"></i>
							</button>
						</div>
						<section class="gradient-custom post__comment d-none">
							<div class="container">
								<div
									class="row d-flex justify-content-center post__comment__list custom-scrollbar">
									<!-- bình luận cha -->
									<div class="card post__comment__item d-none">
										<div class="card-body">
											<div class="row">
												<div class="col">
													<div class="d-flex flex-start">
														<img class="rounded-circle shadow-1-strong me-3"
															src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(10).webp"
															alt="avatar" width="65" height="65" />
														<div class="flex-grow-1 flex-shrink-1">
															<div class="comment__container">
																<div>
																	<div
																		class="d-flex justify-content-between align-items-center">
																		<p class="mb-1">
																			Maria Smantha <span class="small">- 2 hours
																				ago</span>
																		</p>
																		<a href="#"><i class="fas fa-reply fa-xs"></i><span
																			class="small"> reply</span></a>
																	</div>
																	<p class="small mb-0">It is a long established fact
																		that a reader will be distracted by the readable
																		content of a page.</p>
																</div>
																<!-- bình luận con -->
																<div class="d-flex flex-start mt-4">
																	<a class="me-3" href="#"> <img
																		class="rounded-circle shadow-1-strong"
																		src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"
																		alt="avatar" width="65" height="65" />
																	</a>
																	<div class="flex-grow-1 flex-shrink-1">
																		<div>
																			<div
																				class="d-flex justify-content-between align-items-center">
																				<p class="mb-1">
																					Simona Disa <span class="small">- 3 hours
																						ago</span>
																				</p>
																			</div>
																			<p class="small mb-0">letters, as opposed to
																				using 'Content here, content here', making it look
																				like readable English.</p>
																		</div>
																	</div>
																</div>

																<div class="d-flex flex-start mt-4">
																	<a class="me-3" href="#"> <img
																		class="rounded-circle shadow-1-strong"
																		src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(32).webp"
																		alt="avatar" width="65" height="65" />
																	</a>
																	<div class="flex-grow-1 flex-shrink-1">
																		<div>
																			<div
																				class="d-flex justify-content-between align-items-center">
																				<p class="mb-1">
																					John Smith <span class="small">- 4 hours ago</span>
																				</p>
																			</div>
																			<p class="small mb-0">the majority have suffered
																				alteration in some form, by injected humour, or
																				randomised words.</p>
																		</div>
																	</div>
																</div>
															</div>
															<!-- inuput text -->
															<div class="card">
																<div
																	class="mt-3 d-flex flex-row align-items-center p-3 form-color">
																	<img
																		src="https://media.licdn.com/dms/image/C4D03AQFTEOiGeGdutQ/profile-displayphoto-shrink_100_100/0/1657024175293?e=1707350400&v=beta&t=8w5gteNGTFSB2Yua7kTDzX5a5Pd6CT5YTPHi-gZIbGQ"
																		width="50" class="rounded-circle mr-2"
																		style="margin-right: 10px" /> <input type="text"
																		class="form-control input_comment"
																		placeholder="  Viết câu trả lời..." />
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
							<!-- input bình luận cha -->
							<div class="card">
								<div
									class="mt-3 d-flex flex-row align-items-center p-3 form-color">
									<img
										src="https://media.licdn.com/dms/image/C4D03AQFTEOiGeGdutQ/profile-displayphoto-shrink_100_100/0/1657024175293?e=1707350400&v=beta&t=8w5gteNGTFSB2Yua7kTDzX5a5Pd6CT5YTPHi-gZIbGQ"
										width="50" class="rounded-circle mr-2"
										style="margin-right: 10px" /> <input type="text"
										class="form-control input_comment"
										placeholder="  Viết câu trả lời..." />
								</div>
							</div>
						</section>
					</li>
					<li class="wrapper post">
						<div class="post__header">
							<div class="main-author">
								<img class="main-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="main-author__name">Mỹ Phụng</p>
							</div>
						</div>
						<div class="post__content">
							<div class="content-text">GỬI CON. Có ai khen con đẹp. Con
								hãy cảm ơn và quên đi lời khen ấy Ai bảo con ngoan. Hãy cảm ơn
								và nhớ ngoan hiền hơn nữa Với người òa khóc vì nỗi đau mà họ
								đang mang… See more</div>
							<div class="content-media"></div>
						</div>
						<div class="post__feedback">
							<button type="button" class="feedback__btn active"
								onclick="handelToggleLike()">
								<i class="fa-solid fa-thumbs-up icon"></i>
								<p>100 Like</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-regular fa-comment icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-share icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-ellipsis-vertical"></i>
							</button>
						</div>
					</li>
					<li class="wrapper post">
						<div class="post__header">
							<div class="main-author">
								<img class="main-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="main-author__name">Mỹ Phụng</p>
							</div>
						</div>
						<div class="post__content">
							<div class="content-text">GỬI CON. Có ai khen con đẹp. Con
								hãy cảm ơn và quên đi lời khen ấy Ai bảo con ngoan. Hãy cảm ơn
								và nhớ ngoan hiền hơn nữa Với người òa khóc vì nỗi đau mà họ
								đang mang… See more</div>
							<div class="content-media"></div>
						</div>
						<div class="post__feedback">
							<button type="button" class="feedback__btn active"
								onclick="handelToggleLike()">
								<i class="fa-solid fa-thumbs-up icon"></i>
								<p>100 Like</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-regular fa-comment icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-share icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-ellipsis-vertical"></i>
							</button>
						</div>
					</li>
					<li class="wrapper post">
						<div class="post__header">
							<div class="main-author">
								<img class="main-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="main-author__name">Mỹ Phụng</p>
							</div>
						</div>
						<div class="post__content">
							<div class="content-text">GỬI CON. Có ai khen con đẹp. Con
								hãy cảm ơn và quên đi lời khen ấy Ai bảo con ngoan. Hãy cảm ơn
								và nhớ ngoan hiền hơn nữa Với người òa khóc vì nỗi đau mà họ
								đang mang… See more</div>
							<div class="content-media"></div>
						</div>
						<div class="post__feedback">
							<button type="button" class="feedback__btn active"
								onclick="handelToggleLike()">
								<i class="fa-solid fa-thumbs-up icon"></i>
								<p>100 Like</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-regular fa-comment icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-share icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-ellipsis-vertical"></i>
							</button>
						</div>
					</li>
					<li class="wrapper post">
						<div class="post__header">
							<div class="main-author">
								<img class="main-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="main-author__name">Mỹ Phụng</p>
							</div>
						</div>
						<div class="post__content">
							<div class="content-text">GỬI CON. Có ai khen con đẹp. Con
								hãy cảm ơn và quên đi lời khen ấy Ai bảo con ngoan. Hãy cảm ơn
								và nhớ ngoan hiền hơn nữa Với người òa khóc vì nỗi đau mà họ
								đang mang… See more</div>
							<div class="content-media"></div>
						</div>
						<div class="post__feedback">
							<button type="button" class="feedback__btn active"
								onclick="handelToggleLike()">
								<i class="fa-solid fa-thumbs-up icon"></i>
								<p>100 Like</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-regular fa-comment icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-share icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-ellipsis-vertical"></i>
							</button>
						</div>
					</li>
				</ul>
			</div>
			<div class="col-md-2">

				<!--HÃY THÊM VÀO ĐÂY  -->
				<div class="card rounded">
					<div class="card-body">
						<h6 class="card-title">suggestions for you</h6>
						<div
							class="d-flex justify-content-between mb-2 pb-2 border-bottom">
							<div class="d-flex align-items-center hover-pointer">
								<img class="img-xs rounded-circle"
									src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="" />
								<div class="ml-2">
									<p>Mike Popescu</p>
									<p class="tx-11 text-muted">12 Mutual Friends</p>
								</div>
							</div>
							<button class="btn btn-icon">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
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
						<div
							class="d-flex justify-content-between mb-2 pb-2 border-bottom">
							<div class="d-flex align-items-center hover-pointer">
								<img class="img-xs rounded-circle"
									src="https://bootdey.com/img/Content/avatar/avatar3.png" alt="" />
								<div class="ml-2">
									<p>Mike Popescu</p>
									<p class="tx-11 text-muted">12 Mutual Friends</p>
								</div>
							</div>
							<button class="btn btn-icon">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
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
						<div
							class="d-flex justify-content-between mb-2 pb-2 border-bottom">
							<div class="d-flex align-items-center hover-pointer">
								<img class="img-xs rounded-circle"
									src="https://bootdey.com/img/Content/avatar/avatar4.png" alt="" />
								<div class="ml-2">
									<p>Mike Popescu</p>
									<p class="tx-11 text-muted">12 Mutual Friends</p>
								</div>
							</div>
							<button class="btn btn-icon">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
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
						<div
							class="d-flex justify-content-between mb-2 pb-2 border-bottom">
							<div class="d-flex align-items-center hover-pointer">
								<img class="img-xs rounded-circle"
									src="https://bootdey.com/img/Content/avatar/avatar5.png" alt="" />
								<div class="ml-2">
									<p>Mike Popescu</p>
									<p class="tx-11 text-muted">12 Mutual Friends</p>
								</div>
							</div>
							<button class="btn btn-icon">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
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
						<div
							class="d-flex justify-content-between mb-2 pb-2 border-bottom">
							<div class="d-flex align-items-center hover-pointer">
								<img class="img-xs rounded-circle"
									src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="" />
								<div class="ml-2">
									<p>Mike Popescu</p>
									<p class="tx-11 text-muted">12 Mutual Friends</p>
								</div>
							</div>
							<button class="btn btn-icon">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
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
						<div class="d-flex justify-content-between">
							<div class="d-flex align-items-center hover-pointer">
								<img class="img-xs rounded-circle"
									src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="" />
								<div class="ml-2">
									<p>Mike Popescu</p>
									<p class="tx-11 text-muted">12 Mutual Friends</p>
								</div>
							</div>
							<button class="btn btn-icon">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<div class="col-xl-12 col-lg-8 col-md-8 col-xs-12 ">
				<div class="card social-tabs"
					style="width: 100%; align-items: center; margin-top: 10px; margin-bottom: 20px; border: 1px solid rgba(0, 0, 0, .125);">
					<ul class="nav nav-tabs md-tabs tab-timeline" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#post" role="tab">Post</a>
							<div class="slide"></div></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#about" role="tab">About</a>
							<div class="slide"></div></li>

						<%--
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="/SOCIALMEDIA/timkiem/listusergroup?groupID=${groupID}" role="tab">Friends</a>
							<div class="slide"></div></li>--%>
						<li class="nav-item"><a class="nav-link"
							href="/SOCIALMEDIA/timkiem/listusergroup?groupID=${groupID}"
							role="tab">Friends</a>
							<div class="slide"></div></li>
						<!-- tin begin-->
						<li>
							<form class="navbar-form pull-right flex-row float-right"
								style="display: flex; justify-content: flex-end">
								<div style="max-width: 470px" class="input-group">
									<input type="text" id="keyword" name="keyword"
										placeholder="Search" class="form-control" /> <input
										type="hidden" id="groupID" name="groupID" value="${groupID}" />
									<button type="submit"
										formaction="/SOCIALMEDIA/timkiem/searchusergroup?groupID=${groupID}&keyword=${keyword}"
										formmethod="get">Tìm kiếm</button>
								</div>
							</form>
						</li>
						<!-- tin end-->
					</ul>

				</div>
				<div>
					<div class="row justify-content-center">
						<div class=" col-md-6 grid-margin card">
							<div class="card-body">
								<!-- Group info -->
								<div class="d-flex flex-column align-items-center text-center"
									style="padding-bottom: 2rem; border-bottom: 1px solid #a3a3a3;">
									<!-- <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Admin" -->
									<!-- class="rounded-circle bg-primary" width="110"> -->
									<div class="mt-3">
										<h4>${group.groupName}</h4>
										<p class="text-secondary mb-1">Nhóm ${countUserGroup}
											thành viên</p>
										<!-- <p class="text-muted font-size-sm">${group.createTime}</p>-->
										<button class="btn btn-primary">Follow</button>
										<!-- <button class="btn btn-outline-primary">Message</button> -->
									</div>
								</div>
								<!-- Leftbar end -->
							</div>
						</div>
					</div>
				</div>
				<div class="">
					<div class="row justify-content-center">
						<div class="col-md-6 grid-margin">
							<div class="card rounded">
								<tbody>
									<c:set var="index" value="0" />
									<c:forEach var="item" items="${listGroupPost}">
										<c:if test="${index > 0}">
											<hr>
										</c:if>
										<div class="card">
											<div class="card-header">
												<div
													class="d-flex align-items-center justify-content-between">
													<div class="d-flex align-items-center">
														<img class="img-xs rounded-circle"
															src="${item.getUser().getAvatar()}"
															alt>
														<div class="ml-2">
															<p>${item.getUser().getFirstName()}
																${item.getUser().getMidName()}
																${item.getUser().getLastName()}</p>
															<p class="tx-11 text-muted">
																<fmt:formatDate value="${item.getUserPostCreateTime()}"
																	pattern="HH:mm:ss dd-MM-yyyy" />
															</p>
														</div>
													</div>
												</div>
											</div>
											<div class="card-body">
												<p class="mb-3 tx-14">${item.userPostText}</p>
												<img class="img-fluid"
													src="${item.getUserPostImg()}"
													alt>
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
																d="M20.84 4.61a5.5 5.5 0 0 0-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 0 0-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 0 0 0-7.78z"></path>
           													 </svg>
														<p class="d-none d-md-block ml-2">Like</p>
													</a>
												</div>
											</div>
										</div>
										<c:set var="index" value="${index + 1}" />
									</c:forEach>
								</tbody>
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
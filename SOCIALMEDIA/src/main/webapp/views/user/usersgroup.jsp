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
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
		integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA="
		crossorigin="anonymous" />
	<div class="container mt-3 mb-4">
		<div class="col-lg-9 mt-4 mt-lg-0">
			<div class="row">
				<div class="col-md-12">
					<div
						class="user-dashboard-info-box table-responsive mb-0 bg-white p-4 shadow-sm">
						<table class="table manage-candidates-top mb-0">
							<thead>
								<tr>
									<th>Kết quả tìm kiếm</th>
									<th class="text-center"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${listuser}">
									<tr class="candidates-list">
										<td class="title">
											<div class="thumb">
												<img class="img-fluid"
													src="https://bootdey.com/img/Content/avatar/avatar7.png"
													alt="" />
											</div>
											<div class="candidate-list-details">
												<div class="candidate-list-info">
													<div class="candidate-list-title">
														<h5 class="mb-0">
															<a href="#">${item.firstName} ${item.midName} ${item.lastName}</a>
														</h5>
													</div>
													<div class="candidate-list-option">
														<ul class="list-unstyled">
															<li><i class="fas fa-filter pr-1"></i>${item.position}</li>
															<li><i class="fas fa-map-marker-alt pr-1"></i>${item.workPlace}</li>
														</ul>
													</div>
												</div>
											</div>
										</td>
										<td class="candidate-list-favourite-time text-center"></td>
										<%-- This is JSP comment										
										<td><a href="#" class="btn btn-primary" role="button"
											data-bs-toggle="button">follow</a></td>--%>
										<td><a
											href='<c:url value="/api/v1/userFollow?sourceID=${userID}&targetID=${item.userID}"/>'
											class="btn btn-primary" role="button" data-bs-toggle="button">follow</a></td>

									</tr>
								</c:forEach>
							</tbody>

						</table>
						<div class="text-center mt-3 mt-sm-3">
							<%--
							<ul class="pagination justify-content-center mb-0">
								<li class="page-item disabled"><span class="page-link">Prev</span>
								</li>
								<li class="page-item active" aria-current="page"><span
									class="page-link">1 </span> <span class="sr-only">(current)</span>
								</li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">...</a>
								</li>
								<li class="page-item"><a class="page-link" href="#">25</a>
								</li>
								<li class="page-item"><a class="page-link" href="#">Next</a>
								</li>
							</ul>--%>
							<span class="text-muted text-sm">Showing 10 users</span>
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<c:forEach begin="1" end="${endP}" var="i">
										<li class="page-item"><a class="page-link"
											href="group/listuser?groupID=${groupID}&index=${i}">${i}</a></li>
									</c:forEach>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
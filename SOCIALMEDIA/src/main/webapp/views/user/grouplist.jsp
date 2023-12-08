<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="listgroup.css" /> -->
</head>
<body>
	<!-- List group -->
	<section class="followers">
		<!-- Tools bar -->
		<div class="groups">
			<ul class="ul-group-item">
				<div class="li-group-container">
					<li class="li-group-item"><a href="#">All Groups</a></li>
					<div>15</div>
				</div>
				<div class="li-group-container">
					<li class="li-group-item"><a href="#">My Groups (14)</a></li>
					<div>15</div>
				</div>
				<div class="li-group-container">
					<li class="li-group-item"><a href="#">Create a Group</a></li>
				</div>
			</ul>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<!-- FOREACH TẠI ĐÂY ↓↓↓↓ -->
					<c:forEach var="item" items="${listGroup}">
						<div class="followers-box">
							<div class="followers-body">
								<img class="img-responsive img-circle"
									src="https://bootdey.com/img/Content/avatar/avatar1.png"
									alt="#">
								<div class="name-box">
									<!-- Group Name -->
									<h4>${item.groupName}</h4>
									<!-- Group ID -->
									<span>${item.groupID}</span>
									<div class="followers-base">
										<ul class="list-group">
											<li class="list-group-item full-width">
												<div class="pull-left" style="margin-right: 20px;">
													<!-- Số lượng người theo dõi page -->
													<span> 14,000 Followers </span>
												</div>
											</li>
										</ul>
									</div>
								</div>
								<span><a href="#" class="btn btn-info btn-sm"> Follow</a></span>
							</div>
						</div>
						</c:forEach>
						<!-- KẾT THÚC FOREACH TẠI ĐÂY -->
				</div>
			</div>
		</div>
	</section>

</body>
</html>
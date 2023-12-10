<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
<link rel="icon" href="https://w7.pngwing.com/pngs/429/434/png-transparent-computer-icons-icon-design-business-administration-admin-icon-hand-monochrome-silhouette-thumbnail.png" type="image/png">
<link rel="stylesheet"
	href="<c:url value = "/templates/admin/css/style.css"/>" />
	<link rel="stylesheet"
	href="<c:url value = "/templates/admin/css/user-detail.css"/>" />
<link
	href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
</head>
<body>
	<div
		class="d-flex flex-column flex-lg-row h-lg-full bg-surface-secondary">
		<%@include file="/common/admin/left.jsp"%>
		<div class="h-screen flex-grow-1 overflow-y-lg-auto">
			<%@include file="/common/admin/header.jsp"%>
			<main class="py-6 bg-surface-secondary">
				<decorator:body></decorator:body>
			</main>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
	<script
		src='<c:url value = "/templates/admin/script/script.js"></c:url>'></script>
</body>
</html>
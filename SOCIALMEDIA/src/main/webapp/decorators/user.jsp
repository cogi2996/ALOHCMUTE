<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href='<c:url value = "/templates/user/css/common.css"/>' />
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/home.css"/>" />
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/reset.css"/>" />

<%
// Lấy URI của request
String uri = request.getRequestURI();

// Kiểm tra nếu URI chứa "home", thêm home.css vào head
if (uri.contains("home")) {
%>
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/profile.css"/>" />
<%
} else if (uri.contains("profile")) {
%>
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/profile.css"/>" />
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<!-- <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" /> -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<%
} else if (uri.contains("editProfile")) {
%>
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/editProfile.css"/>" />
<%
} else if (uri.contains("timkiem")) {
%>
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/resultFind.css"/>" />
<%
<<<<<<< HEAD
=======
} else if (uri.contains("allGroup")) {
%>
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/group.css"/>" />

<%
} else if (uri.contains("grouppost")) {
%>
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/groupinfo.css"/>" />

<%
>>>>>>> branch 'tin-api' of https://github.com/cogi2996/ALOHCMUTE.git
}
%>

<<<<<<< HEAD
<!-- list group css -->
=======

<%-- 	<!-- list group css -->
>>>>>>> branch 'tin-api' of https://github.com/cogi2996/ALOHCMUTE.git
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/listgroup.css"/>" />
</head> --%>
<body>
	<%@include file="/common/user/header.jsp"%>
	<decorator:body></decorator:body>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src='<c:url value = "/templates/user/script/main.js"></c:url>'></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

	<!--  list group js-->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src='<c:url value ="/templates/navigation/script/navigation.js"></c:url>'></script>
</body>
</html>
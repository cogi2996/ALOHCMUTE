<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="listfollower.css" />
</head>
<body>
	<c:forEach items="${listfollowers}" var="item" varStatus="STT">
        <!-- Placeholder for follower item -->
		<div class="follower">
			<img src="${item.avatar}" alt="Avatar">
			<p>${item.lastName}${item.midName} ${item.firstName}</p>
		</div>
	</c:forEach>
</body>
</html>
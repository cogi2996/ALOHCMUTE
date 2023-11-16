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
	
        <!-- Placeholder for follower item -->
		<div class="follower">
			<c:forEach items="${listfollower}" var="item" varStatus="STT">
				<img src="${item.avatar}" alt="Avatar">
				<p>${item.lastName} ${item.midName} ${item.firstName}</p>
			</c:forEach>
		</div>
	
</body>
</html>

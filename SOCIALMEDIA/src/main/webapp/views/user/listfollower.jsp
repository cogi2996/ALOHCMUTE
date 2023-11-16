<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Follower List</title>
    <link rel="stylesheet" href="listfollower.css">
</head>
<body>
	<c:forEach items="${listfollower}" var="item" varStatus="STT">
	    <div class="follower-list">
	        <!-- Placeholder for follower item -->
	        <div class="follower">
	            <img src="${item.avatar}" alt="Avatar">
	            <p>${item.lastName} ${item.midName} ${item.firstName}</p>
	        </div>
	
	        <!-- Repeat the above structure for each follower -->
	        <!-- <div class="follower">
	            <img src="avatar2.jpg" alt="Avatar">
	            <p>Jane Smith</p>
	        </div> -->
	    </div>
	</c:forEach>
</body>
</html>

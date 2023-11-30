<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Hello World</p>
	<script type="module"
		src='<c:url value = "/templates/firebase/firebase.js"></c:url>'></script>
	<script type="module"
		src='<c:url value = "/templates/login/script/login.js"></c:url>'></script>
</body>
</html>
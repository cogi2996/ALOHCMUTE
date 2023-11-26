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
	<form action='<c:url value="/xacthuctaikhoan"></c:url>' method ="post">

		<div class="form-group">
			<label for="inputTitle">Mã xác thực</label> <input type="text"
				class="form-control" id="inputTitle" name="code"
				placeholder="Nhập mã xác thực gồm 6 chữ số ">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	
</body>
</html>
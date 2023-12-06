<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<style>
body {
	background-color: #f9fafb;
	margin-top: 20px;
}

.profile-page .profile-header {
	box-shadow: 0 0 10px 0 rgba(183, 192, 206, 0.2);
	border: 1px solid #f2f4f9;
}

.profile-page .profile-header .cover {
	position: relative;
	border-radius: 0.25rem 0.25rem 0 0;
}

.profile-page .profile-header .cover figure {
	margin-bottom: 0;
}

@media ( max-width : 767px) {
	.profile-page .profile-header .cover figure {
		height: 110px;
		overflow: hidden;
	}
}

@media ( min-width : 2400px) {
	.profile-page .profile-header .cover figure {
		height: 280px;
		overflow: hidden;
	}
}

.profile-page .profile-header .cover figure img {
	border-radius: 0.25rem 0.25rem 0 0;
	width: 100%;
}

@media ( max-width : 767px) {
	.profile-page .profile-header .cover figure img {
		-webkit-transform: scale(2);
		transform: scale(2);
		margin-top: 15px;
	}
}

@media ( min-width : 2400px) {
	.profile-page .profile-header .cover figure img {
		margin-top: -55px;
	}
}

.profile-page .profile-header .cover .gray-shade {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 1;
	background: linear-gradient(rgba(255, 255, 255, 0.1), #fff 99%);
}

.profile-page .profile-header .cover .cover-body {
	position: absolute;
	bottom: -20px;
	left: 0;
	z-index: 2;
	width: 100%;
	padding: 0 20px;
}

.profile-page .profile-header .cover .cover-body .profile-pic {
	border-radius: 50%;
	width: 100px;
}

@media ( max-width : 767px) {
	.profile-page .profile-header .cover .cover-body .profile-pic {
		width: 70px;
	}
}

.profile-page .profile-header .cover .cover-body .profile-name {
	font-size: 20px;
	font-weight: 600;
	margin-left: 17px;
}

.profile-page .profile-header .header-links {
	padding: 15px;
	display: -webkit-flex;
	display: flex;
	-webkit-justify-content: center;
	justify-content: center;
	background: #fff;
	border-radius: 0 0 0.25rem 0.25rem;
}

.profile-page .profile-header .header-links ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.profile-page .profile-header .header-links ul li a {
	color: #000;
	-webkit-transition: all 0.2s ease;
	transition: all 0.2s ease;
}

.profile-page .profile-header .header-links ul li:hover, .profile-page .profile-header .header-links ul li.active
	{
	color: #727cf5;
}

.profile-page .profile-header .header-links ul li:hover a, .profile-page .profile-header .header-links ul li.active a
	{
	color: #727cf5;
}

.profile-page .profile-body .left-wrapper .social-links a {
	width: 30px;
	height: 30px;
}

.profile-page .profile-body .right-wrapper .latest-photos>.row {
	margin-right: 0;
	margin-left: 0;
}

.profile-page .profile-body .right-wrapper .latest-photos>.row>div {
	padding-left: 3px;
	padding-right: 3px;
}

.profile-page
        .profile-body
        .right-wrapper
        .latest-photos>.row>div
        figure {
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	margin-bottom: 6px;
}

.profile-page
        .profile-body
        .right-wrapper
        .latest-photos>.row>div
        figure:hover {
	-webkit-transform: scale(1.06);
	transform: scale(1.06);
}

.profile-page
        .profile-body
        .right-wrapper
        .latest-photos>.row>div
        figure
        img {
	border-radius: 0.25rem;
}

.rtl .profile-page .profile-header .cover .cover-body .profile-name {
	margin-left: 0;
	margin-right: 17px;
}

.img-xs {
	width: 37px;
	height: 37px;
}

.rounded-circle {
	border-radius: 50% !important;
}

img {
	vertical-align: middle;
	border-style: none;
}

.card-header:first-child {
	border-radius: 0 0 0 0;
}

.card-header {
	padding: 0.875rem 1.5rem;
	margin-bottom: 0;
	background-color: rgba(0, 0, 0, 0);
	border-bottom: 1px solid #f2f4f9;
}

.card-footer:last-child {
	border-radius: 0 0 0 0;
}

.card-footer {
	padding: 0.875rem 1.5rem;
	background-color: rgba(0, 0, 0, 0);
	border-top: 1px solid #f2f4f9;
}

.grid-margin {
	margin-bottom: 1rem;
}

.card {
	box-shadow: 0 0 10px 0 rgba(183, 192, 206, 0.2);
	-webkit-box-shadow: 0 0 10px 0 rgba(183, 192, 206, 0.2);
	-moz-box-shadow: 0 0 10px 0 rgba(183, 192, 206, 0.2);
	-ms-box-shadow: 0 0 10px 0 rgba(183, 192, 206, 0.2);
}

.rounded {
	border-radius: 0.25rem !important;
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 1px solid #f2f4f9;
	border-radius: 0.25rem;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<!-- phần cần để hiển thị navigation  -->
<link
	href="https://cdn.jsdeljs.cloudflare.com/ajax/libs/font-awesome/6.4.2/csivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="<c:url value = "/templates/user/css/reset.css"/>" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />

<link rel="stylesheet"
	href='<c:url value = "/templates/user/css/common.css"/>' />
</head>
<body>
	<%@include file="/common/user/header.jsp"%>
	<decorator:body></decorator:body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src='<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></c:url>'></script>
	<script>
		

		/*  function loadAjax() {
		        var amount = document.getElementsByClassName("post").length;
		        console.log(amount);
		        $.ajax({
		          url: "/SOCIALMEDIA/home/loadAjaxPost",
		          type: "get",
		          data: {
		            exits: amount,
		          },
		          success: function (data) {
		            $(".list-post").append(data);
		           
		          },
		          error: function (xhr) {},
		        });
		      } */
		
	</script>
	<script src='<c:url value = "/templates/user/script/home.js"></c:url>'></script>
</body>
</html>

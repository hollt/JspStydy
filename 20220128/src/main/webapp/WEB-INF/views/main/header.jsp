<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br>
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="main.do">Home</a></li>
				<c:if test="${empty id }"> <!-- 세션이 가지고 있는 id가 비어있으면, 세션에 어트리뷰트 해준 매게변수 id값 -->
					<li><a href="loginForm.do">Login</a></li>
				</c:if>
				<c:if test="${not empty id }"> <!-- 아이디가 값이 담겨있으면 보여줘라 -->
					<li><a href="logout.do">LogOut</a></li>
				</c:if>
				<li><a href="noticeList.do">Notice</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Product</a></li>
				<li><a href="#">Service</a></li>
				<li><a href="#">Members</a></li>
				
			</ul>
		</div>
	</div>
</body>
</html>
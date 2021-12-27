<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet" type="">
</head>
<body>
	<div class="title-bar">
		<%= session.getAttribute("username") %>
	</div>
	
	<div class="left" style="width:20%;background-color: yellow">
		<%@ include file="/WEB-INF/views/common/userSideNav.jspf" %>
	</div>
		
	<div class="left">
		User Dashboard page content will be displayed here
	</div>	
</body>
</html>
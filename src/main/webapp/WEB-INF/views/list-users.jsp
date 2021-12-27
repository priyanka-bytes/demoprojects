<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet" type="">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	tr:hover {
	
		background-color:green;
		color:white;
		cursor:pointer;
	
	}

</style>



</head>
<body>
<form>
	<h2>Users List</h2>

	<div class="" >
	
	<c:if test="${not empty userlist }">
		<table border="1" id="users">
			<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of Birth</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Mother Tongue</th>
			</tr>	
			</thead>
			<tbody>
				<c:forEach var="user" items="${userlist}">
					<tr onclick="redirectUserEdit(${user.id})">
					<td>${user.id}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.dateOfBirth}</td>
						<td>${user.gender.lookupValue}</td>
						<td>${user.email}</td>
						<td>${user.mobile}</td>
						<td>${user.motherTongue.lookupValue}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</div>
	</form>
	<script type="text/javascript">
	
		function redirectUserEdit(userId) {
			console.log(userId);
			<% String userid="userId";%>
		    
		    <%
		    session.setAttribute("userId", userid);
		        %>
			var url = 'basicInfo?action=basic&userId='+userId;
			window.location.href = url;
		}	
	
	</script>
</body>
</html>
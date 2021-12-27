<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ page isELIgnored="false" %>

<html>
<head>
	<!-- <script src="<c:url value="/resources/js/app.js" />"></script> --> 
	
	<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet" type="">
</head>
<body>
	<div class="content">
		<div class="login">
      		<form:form method = "POST" action = "${pageContext.request.contextPath}/auth/login" modelAttribute="loginForm">
				<div class="elem">
					<label> Username:</label>
					<input type="text" name="username"/>
				</div>
				
				<div class="elem">
					<label> Password:</label>
					<input type="password" name="password"/>
				</div>
				
				 <input type = "submit" value = "Submit"/>
			</form:form>		
		</div>
		
		<a class="left" href="${pageContext.request.contextPath}/register">Register</a>
	</div>
</body>
</html>

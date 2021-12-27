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
</head>
<body>
	<div class="content no-margin">
		<h3>Register</h3>
		<h6>Join to our community now!</h6>
		
		<form:form method = "POST" action="${pageContext.request.contextPath}/register/save" modelAttribute="registerUser">
			<div class="elem">
				<label> First Name:</label>
				<form:input type="text" name="firstName" path="firstName" />
			</div>
			
			<div class="elem">
				<label> Last Name:</label>
				<form:input type="text" name="lastName" path="lastName" />
			</div>
			
			<div class="elem">
				<label> Date of Birth:</label>
				<form:input type="date"  name="dateOfBirth" path="dateOfBirth"  />
			</div>
			
			<div class="elem">
				<label> Gender:</label>
				<form:select id="gender" path="gender.id">
					<option value="">Select Gender</option>
					<c:if test="${not empty genders }">
						<c:forEach var="obj" items="${genders }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
						</c:forEach>
					</c:if>
				</form:select>
			</div>
			 
			<div class="elem">
				<label> Mobile:</label>
				<form:input type="text" name="mobile" path="mobile" />
			</div>
			
			<div class="elem">
				<label> Email:</label>
				<form:input type="text" name="email" path="email" />
			</div>
			
			<!--  <div class="elem">
				<label> Street Name:</label>
				<input type="text" name="streetName"  />
			</div>
			
			<div class="elem">
				<label> Flat #:</label>
				<input type="text" name="flatNumber" />
			</div>
			
			<div class="elem">
				<label> Building Name:</label>
				<input type="text" name="building Name"/>
			</div>
			-->
			<div class="elem">
				<label> Languages Known:</label>
				<form:select path="languagesList" items="${languages}" multiple="true" itemValue="id" itemLabel="lookupValue" class="multi-select" />
			</div>
			
			<div class="elem">
				<label> Mother Tongue:</label>
				<form:select id="motherTongue" path="motherTongue.id">
					<option value="">Select Mother Tongue</option>
					<c:if test="${not empty languages }">
					<c:forEach var="obj" items="${languages }">
						<option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</option>
					</c:forEach>
				</c:if>
				</form:select>
			</div>
			
			<div class="elem">
				<label> Disease:</label>
				<form:select id="diseases" path="disease.disease.id">
					<option value="">Select Disease</option>
					<c:if test="${not empty diseases }">
					<c:forEach var="obj" items="${diseases }">
						<option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</option>
					</c:forEach>
				</c:if>
				</form:select>
			</div>
			
			 <input type = "submit" value = "Submit"/>
		</form:form>	
	</div>
</body>
</html>
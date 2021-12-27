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
	<div class="page-title-bar">
		Basic Information
	</div>
	<div class="left side-nav" >
		<%@ include file="/WEB-INF/views/common/userSideNav.jspf" %>
	</div>
		
	<div class="left side-nav-content no-margin">
		<form:form method = "POST" action="${pageContext.request.contextPath}/register/save" modelAttribute="user">
			<span style="font-weight: bold;font-size: 25px;">Personal</span>
			<hr>
			<form:hidden path="id" />
			
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
			
			
			<!-- addresses -->
			 
			<span style="font-weight: bold;font-size: 25px;">Residential Address</span>
			<hr>
			<div class="elem">
				<label> Street Name:</label>
				<form:input type="text" path="addressList[0].streetName" />
			</div>
			
			<div class="elem">
				<label> Flat #:</label>
				<form:input type="text" path="addressList[0].flatPlotNo" />
			</div>
			
			<div class="elem">
				<label> Building Name:</label>
				<form:input type="text" path="addressList[0].buildingName"/>
			</div>
			
			<div class="elem">
				<label> Area Name:</label>
				<form:input type="text" path="addressList[0].area"/>
			</div>
			
			<div class="elem">
				<label> State: </label>
				<form:select id="resAddState" path="addressList[0].state.id">
					<option value="">Select State</option>
					<c:if test="${not empty states }">
						<c:forEach var="obj" items="${states }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.name}</form:option>
						</c:forEach>
					</c:if>
				</form:select>
			</div>
			
			<div class="elem">
				<label> City: </label>
				<form:select id="resAddCity" path="addressList[0].city.id">
					<option value="">Select City</option>
					<c:if test="${not empty cities }">
						<c:forEach var="obj" items="${cities }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.name}</form:option>
						</c:forEach>
					</c:if>
				</form:select>
			</div>
			
			<div class="elem">
				<label> Pincode: </label>
				<form:input type="text" path="addressList[0].zipCode"/>
			</div>
			
			<form:hidden path="addressList[0].id"/>
			<form:hidden path="addressList[0].country.id" value="1"/>
			<form:hidden path="addressList[0].addressType.id" value="9"/>
			
			<span style="font-weight: bold;font-size: 25px;">Postal/Office Address</span>
			<hr>
			<div class="elem">
				<label> Street Name:</label>
				<form:input type="text" path="addressList[1].streetName"  />
			</div>
			
			<div class="elem">
				<label> Flat #:</label>
				<form:input type="text" path="addressList[1].flatPlotNo" />
			</div>
			
			<div class="elem">
				<label> Building Name:</label>
				<form:input type="text" path="addressList[1].buildingName"/>
			</div>
			
			<div class="elem">
				<label> Area Name:</label>
				<form:input type="text" path="addressList[1].area"/>
			</div>
			
			<div class="elem">
				<label> State: </label>
				<form:select id="gender" path="addressList[1].state.id">
					<option value="">Select State</option>
					<c:if test="${not empty states }">
						<c:forEach var="obj" items="${states }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.name}</form:option>
						</c:forEach>
					</c:if>
				</form:select>
			</div>
			
			<div class="elem">
				<label> City: </label>
				<form:select id="gender" path="addressList[1].city.id">
					<option value="">Select City</option>
					<c:if test="${not empty cities }">
						<c:forEach var="obj" items="${cities }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.name}</form:option>
						</c:forEach>
					</c:if>
				</form:select>
			</div>
			
			<div class="elem">
				<label> Pincode: </label>
				<form:input type="text" path="addressList[1].zipCode"/>
			</div>
			
			<form:hidden path="addressList[1].id"/>
			<form:hidden path="addressList[1].country.id" value="1"/>
			<form:hidden path="addressList[1].addressType.id" value="10"/>
			
			<span style="font-weight: bold;font-size: 25px;">Others</span>
			<hr>
			<div class="elem">
				<label> Languages Known:</label>
				<form:select id="motherTongue" path="languagesList"  multiple="true" class="multi-select">
					<c:if test="${not empty languages }">
					<c:forEach var="obj" items="${languages }">
						<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
					</c:forEach>
				</c:if>
				</form:select>
			</div>
			
			<div class="elem">
				<label> Mother Tongue:</label>
				<form:select id="motherTongue" path="motherTongue.id">
					<option value="">Select Mother Tongue</option>
					<c:if test="${not empty languages }">
					<c:forEach var="obj" items="${languages }">
						<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
					</c:forEach>
				</c:if>
				</form:select>
			</div>
			
			<div class="elem">
				<label> Disease:</label>
				<form:hidden path="disease.id"/>
				<form:select id="diseases" path="disease.disease.id">
					<option value="">Select Disease</option>
					<c:if test="${not empty diseases }">
					<c:forEach var="obj" items="${diseases }">
						<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
					</c:forEach>
				</c:if>
				</form:select>
			</div>
			
			 <input type = "submit" value = "Submit"/>
		</form:form>
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet" type="">
</head>
<style>

input, select {
    height: 30px;
    width: 20%;
    border-radius: 5px;
    border: 1px solid black;
    margin-top: 100px;
    margin-left: -950px;
}
textarea {

    padding: 10px;
    width: 20%;
    line-height: 1.5;
    border-radius: 5px;
    border: 1px solid #ccc;
    box-shadow: 1px 1px 1px #999;
    margin-left: -950px;
}

label {
    display: block;
    margin-bottom: 10px;
    margin-top:70px;
    font-size:20px;
    
}
button {

	background-color: green;
    color: white;
    text-align: center;
    font-size: 20px;
    padding: 20px;
    width: 180px;
    cursor: pointer;
    margin-top: 20px;
	margin-left: 500px;

}

</style>
<body>
<div class="page-title-bar">
		Raise a Ticket
</div>
<form:form method = "POST"  action= "${pageContext.request.contextPath}/ticket/saveTicket" modelAttribute="ticketInfoForm">
    <input type="hidden" name="patientId"  value="<%=session.getAttribute("uid")%>" />
	<div class="elem">
	<label for="subject">Subject:</label>
  	<input type="text" id="illnessName" name="illnessName"><br><br>
	
	
 	<label> Description:</label>
	<textarea id="desc" name="desc" rows="5" cols="33"> </textarea>
	</div>
	
   	<button>Submit</button>
	
</form:form>
</body>
</html>
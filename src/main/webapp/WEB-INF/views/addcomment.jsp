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

textarea {
    height: 70px;
    width: 30%;
    border-radius: 5px;
    border: 1px solid black;
   
    margin-top: 200px;
    margin-left: -953px;
}
label {
    margin-top: 200px;
   font-size: 20px;
   font-weight: bold;
}
button {
	background-color: green;
	color: white;
	text-align: center;
	font-size: 15px;
	padding: 20px;
	width: 180px;
	cursor: pointer;
	margin-left: 200px;
	margin-top: 20px;
}

</style>
<body>

<div class="page-title-bar">Update Ticket</div>
 <form:form method = "POST" action="${pageContext.request.contextPath}/ticket/saveComments" modelAttribute="ticketcomments">
 
 <input type="hidden" name="ticketId"  value="<%=session.getAttribute("ticketId")%>" />
 <input type="hidden" name="userId"  value="<%=session.getAttribute("uid")%>" />
 <div class="elem">
	<label> Description:</label>
	<textarea id="content" name="content" rows="5" cols="33"> </textarea>
 </div>
			
  <div class="elem">
				
	<% 
		Date date = new Date();
	%>
	<input type="hidden" id="createdtime" name="createdDate"  value="<%= date.toString() %>" /> 
	<input type="hidden" id="createdUserId" name="createdUserId"  value="<%= "191" %>" />
  </div>
  
  <button>Submit</button>
     
  </form:form>
  
</body>
</html>
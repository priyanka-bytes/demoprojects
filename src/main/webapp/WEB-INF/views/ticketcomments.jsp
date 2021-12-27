<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chat Box</title>
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet" type="">
</head>
<style>

button {
	background-color: green;
	color: white;
	text-align: center;
	font-size: 15px;
	padding: 20px;
	width: 180px;
	cursor: pointer;
	margin-left: 900px;
	margin-top: 20px;
}
.filterDiv {
    background-color: #cecdcb;
    color: #ffffff;
    text-align: left;
    border-radius: 6px;
    /* display: none; */
    font-size: 20px;
  	width: 700px;
}
.filterDiv1 {
    background-color: #40E0D0;
    color: #ffffff;
    text-align: left;
    border-radius: 6px;
    /* display: none; */
    font-size: 20px;
    width: 700px;
}
p {
    font-family: verdana;
    font-size: 18px;
    margin-left: 20px;
}
</style>

<body>
<div class="page-title-bar">Ticket Comments</div>
 <h1>i am in chat box</h1>
 
 <a href="${pageContext.request.contextPath}/ticket/addcomment">
		<button>Add Comment</button>
</a>
	
	<c:if test="${not empty ticketcomments}">
		
	<ul>
		<c:if test="${not empty docticketcomments}">
		<c:forEach var="patientComments" items="${ticketcomments}">
		<div class= "filterDiv">
			<% String patientname=(String)session.getAttribute("tktpatientName");
				out.print(patientname);
			%>
 				<p>${patientComments.content}</p>
 		</div>
							   
		<c:forEach var="docComments" items="${docticketcomments}">
						   
		<fmt:parseDate value="${docComments.createdDate}" var="docTktDate" pattern="yyyy-MM-dd" />
        <fmt:formatDate var="docDate" pattern="dd-MM-yyyy" value="${docTktDate}" />
                           

 		<fmt:parseDate value="${patientComments.createdDate}" var="patientTktDate" pattern="yyyy-MM-dd" />
        <fmt:formatDate var="patientDate" pattern="dd-MM-yyyy" value="${patientTktDate}" />

		<c:if test ="${docDate gt patientDate}">
		<div class= "filterDiv1">
			<% String docname=(String)session.getAttribute("tktdoctorName");
				out.print(docname);
			%>
				<p>${docComments.content} </p>

		</div>
		</c:if>

							
		</c:forEach>
		</c:forEach>
		</c:if>
		
		<c:if test="${empty docticketcomments}">
		<c:forEach var="patientComments" items="${ticketcomments}">
		<div>
			<% String patientname=(String)session.getAttribute("tktpatientName");
				out.print(patientname);
			%>
 				<p>${patientComments.content}</p>
 		</div>
		</c:forEach>
						
		</c:if>
						
	</ul>
					
	</c:if>
				
</body>
</html>
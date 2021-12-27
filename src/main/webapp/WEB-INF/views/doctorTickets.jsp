<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet"
	type="">
</head>
<style>
.filterDiv {
	background-color: #cecdcb;
	color: #ffffff;
	text-align: left;
	border-radius: 10px;
	display: none;
}

.show {
	display: block;
}

div#myBtnContainer {
	height: 900px;
	background-color: #ccffff;
	width: 250px;
	margin-top: 0px;
}

.container {
	margin-top: 10px;
	overflow: hidden;
	margin-left: -610px;
}

.btn {
	margin-top: 20px;
	outline: none;
	padding: 12px 16px;
	background-color: #ccffff;
	cursor: pointer;
	margin-left: 10px;
}

.btn2 {
	margin-top: 20px;
	outline: none;
	padding: 20px 20px 20px 20px;
	background-color: green;
	cursor: pointer;
	margin-left: -300px;
	color: #ffffff;
}

.btn2.active {
	background-color: green;
	color: black;
	padding: 12px 20px;
	color: #ffffff;
}

.btn.active {
	background-color: #ccffff;
	color: black;
}

.column {
	float: left;
	width: 33.33%;
}

.row1:after {
	content: "";
	display: table;
	clear: both;
}

.row2:after {
	content: "";
	display: table;
	clear: both;
}

h2 {
	color: Blue;
	text-align: left;
	margin-left: 300px;
}

btn1 {
	color: Blue;
	text-align: left;
	margin-left: 268px;
}

button.btn1.active {
	margin-left: 268px;
	height: 50px;
	width: 100px;
	cursor: pointer;
	background-color: #20B2AA;
	color: white;
}
</style>
<body>
	<div class="page-title-bar">Doctor Ticket</div>


	<div class="row1">
		<div class="column">
			<div id="myBtnContainer">

				<c:forEach var="date" items="${model.dates}">
					<a
						href="${pageContext.request.contextPath}/ticket/byDate?date=${date.value}">
						<button class="btn1 active">${date.value}</button> <br>
					</a>
				</c:forEach>

			</div>
		</div>

		<div class="column">
			<div class="container">
				<c:if test="${not empty model.userList}">
					<ul>
						<c:forEach var="listValue" items="${model.usernamelist}">

							<a
								href="${pageContext.request.contextPath}/ticket/patientId?patientId=${listValue.id}">
								<button class="btn1 active">${listValue.firstName}</button> <br>
							</a>

						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>

		<div class="column">
			<div class="container">
				<c:if test="${not empty model.doctpatienttktdetails}">
					<ul>
						<c:forEach var="listValue" items="${model.doctpatienttktdetails}">
							<div class="filterDiv date1" onclick="redirect(${listValue.id})">
								<h1>${listValue.illnessName}</h1>
								<p>${listValue.desc}</p>
							</div>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>
	</div>



	<script>
filterSelection("all")
function filterSelection(c) {
  var x, i;
  x = document.getElementsByClassName("filterDiv");
  if (c == "all") c = "";
  for (i = 0; i < x.length; i++) {
    w3RemoveClass(x[i], "show");
    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
  }
}

function w3AddClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
  }
}

function w3RemoveClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);     
    }
  }
  element.className = arr1.join(" ");
}

// Add active class to the current button (highlight it)
var btnContainer = document.getElementById("myBtnContainer");
var btns = btnContainer.getElementsByClassName("btn");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function(){
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}

function redirect(ticketId){
	
	var context = "${pageContext.request.contextPath}";
	var url = context + '/ticket/doctorComments?ticketId='+ticketId;
	//var url = "ticketinfo";
	window.location.href = url;
}
</script>

</body>
</html>
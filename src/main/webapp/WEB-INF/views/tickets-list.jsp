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
<title></title>
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
	border-radius: 10px;
	display: none;
	font-size: 12px;
}

.show {
	display: block;
}

.container {
	margin-top: 10px;
	overflow: hidden;
	margin-left: -210px;
	margin-right: -270px;
}

.btn1 {
	margin-top: 70px;
	outline: none;
	padding: 12px 16px;
	background-color: #ccffff;
	cursor: pointer;
	margin-left: 10px;
	border-radius: 8px;
	color: green;
}

h1 {
	color: blue;
	margin-left: 20px;
}

p {
	margin-top: 2px;
	margin-left: 20px;
}

.btn {
	outline: none;
	padding: 12px 16px;
	background-color: #ccffff;
	cursor: pointer;
	margin-left: 10px;
	border-radius: 8px;
	color: green;
}

div#myBtnContainer {
	height: 900px;
	background-color: #ccffff;
	width: 250px;
	margin-top: -80px;
}

.btn.active {
	margin-top: 20px;
	background-color: #ccffff;
	color: black;
}

.column {
	float: left;
	width: 33.33%;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
<body>
	<div class="page-title-bar">Patient Ticket</div>

	<a href="${pageContext.request.contextPath}/ticket/new">
		<button>Raise a Ticket</button>
	</a>

	<div class="row">
		<div class="column">
			<div id="myBtnContainer">

				<c:if test="${not empty model.tickets}">
					<ul>
						<c:forEach var="date" items="${model.dates}">
							<a href="${pageContext.request.contextPath}/ticket/byDate?date=${date.value}">
								<button class="btn1 active">
									${date.value}</button> <br>
							</a>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>

		<div class="column">
			<div class="container">
				<c:if test="${not empty model.tickets}">
					<ul>
						<c:forEach var="listValue" items="${model.tickets}">
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
			if (c == "all")
				c = "";
			for (i = 0; i < x.length; i++) {
				w3RemoveClass(x[i], "show");
				if (x[i].className.indexOf(c) > -1)
					w3AddClass(x[i], "show");
			}
		}

		function w3AddClass(element, name) {
			var i, arr1, arr2;
			arr1 = element.className.split(" ");
			arr2 = name.split(" ");
			for (i = 0; i < arr2.length; i++) {
				if (arr1.indexOf(arr2[i]) == -1) {
					element.className += " " + arr2[i];
				}
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
			btns[i].addEventListener("click", function() {
				var current = document.getElementsByClassName("active");
				current[0].className = current[0].className.replace(" active",
						"");
				this.className += " active";
			});
		}

		function redirect(ticketId) {
			
			var context = "${pageContext.request.contextPath}";
			var url = context + '/ticket/ticketcomments?ticketId='+ticketId;
			//var url = "ticketinfo";
			window.location.href = url;
		}
	</script>

</body>
</html>

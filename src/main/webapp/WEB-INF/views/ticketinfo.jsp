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
<style>


textarea {
    
    padding: 10px;
    max-width: 80%;
    line-height: 1.5;
    border-radius: 5px;
    border: 1px solid #ccc;
    box-shadow: 1px 1px 1px #999;
    margin-left: -400px;
    margin-top:150px;
}
div.elem label, div.elem.input, div.elem.textarea {
    width: 40%;
    float: left !important;
    margin-top: 200px;
    margin-left: 200px;
    font-size:25px;
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
		 Ticket Update
</div>
				
	<div class="elem">
	<label>Description</label>
	

<textarea id="desc" name="desc" rows="5" cols="33"> </textarea>
     </div>
	
	
	
   <button>update</button>
</body>
</html>
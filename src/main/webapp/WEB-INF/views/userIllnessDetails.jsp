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
</head>
<body>
	<div class="page-title-bar">
		Illness Details
	</div>
	<div class="left side-nav" >
		<%@ include file="/WEB-INF/views/common/userSideNav.jspf" %>
	</div>
		
	<div class="left side-nav-content no-margin">
		<form:form method = "POST" action="${pageContext.request.contextPath}/patient/saveIllness" modelAttribute="illness" onsubmit="return submitIllnessForm()" >
		
	
			<div class="page-section">
			
				 
				<div class="elem">
					<label>Previous Stress:</label>
					<form:select id="prevStress" path="stressType.id">
						<option value="">Select Stress</option>
						<c:if test="${not empty stressTypes }">
						<c:forEach var="obj" items="${stressTypes }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
						</c:forEach>
					</c:if>
					</form:select>
				</div>
				
				<div class="elem">
					<label>Previous Stress Comments:</label>
					<form:textarea id="stressComments" path="stressComments" />
				</div>
				
				<div class="elem">
					<label>Current Treatment:</label>
					<form:select id="curTreatment" path="treatmentType.id">
						<option value="">Select Support</option>
						<c:if test="${not empty treatmentTypes }">
						<c:forEach var="obj" items="${treatmentTypes }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
						</c:forEach>
					</c:if>
					</form:select>
				</div>
				
				<div class="elem">
					<label>Current Treatment Comments:</label>
					<form:textarea id="treatmentComments" path="treatmentComments" />
				</div>
			
				<div class="elem">
					<label>Vegiterian:</label>
					<form:checkbox path="isVegetarian" />
				</div>
				<div class="elem ">
					<label>If Yes, Since:</label>
					<form:select id="vegetarianSinceMonths" path="vegetarianSinceMonths" class="col-3">
						<option value="">Select Month</option>
						<c:forEach var="obj" begin="0" end="12">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</form:select>
					<form:select id="vegetarianSinceYears" path="vegetarianSinceYears" class="col-3">
						<option value="">Select Year</option>
						<c:forEach var="obj" begin="0" end="100">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</form:select>
				</div>
				
				<div class="elem ">
					<label>Anapansati Medicine:</label>
					<form:select id="anapansatiMeditationSinceDays" path="anapansatiMeditationSinceDays" class="col-1">
						<option value="">Select Days</option>
						<c:forEach var="obj" begin="0" end="30">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</form:select>
					
					<form:select id="anapansatiMeditationSinceMonths" path="anapansatiMeditationSinceMonths" class="col-1">
						<option value="">Select Month</option>
						<c:forEach var="obj" begin="0" end="12">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</form:select>
					
					<form:select id="anapansatiMeditationSinceYears" path="anapansatiMeditationSinceYears" class="col-1">
						<option value="">Select Years</option>
						<c:forEach var="obj" begin="0" end="100">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</form:select>
				</div>
				<div class="elem ">
					<label>Maritial Status:</label>
					<form:select id="maritalStatus" path="maritalStatus.id" >
						<option value="">Select Married Status</option>
						<c:if test="${not empty marriedStatusTypes }">
						<c:forEach var="obj" items="${marriedStatusTypes }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
						</c:forEach>
					</c:if>
					</form:select>
				</div>
				<div class="elem ">
					<label>Family Type:</label>
					<form:select id="familyType" path="familyType.id" >
						<option value="">Select Family Type</option>
						<c:if test="${not empty familyTypes }">
						<c:forEach var="obj" items="${familyTypes }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
						</c:forEach>
					</c:if>
					</form:select>
				</div>
				<div class="elem ">
					<label>Class:</label>
					<form:select id="familyClass" path="familyClass.id" >
						<option value="">Select Faimly Class</option>
						<c:if test="${not empty familyClassTypes }">
						<c:forEach var="obj" items="${familyClassTypes }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
						</c:forEach>
					</c:if>
					</form:select>
				</div>
				<div class="elem ">
					<label>Support:</label>
					<form:select id="familySupport" path="familySupport.id">
						<option value="">Select Support</option>
						<c:if test="${not empty yesNoTypes }">
						<c:forEach var="obj" items="${yesNoTypes }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
						</c:forEach>
					</c:if>
					</form:select>
				</div>
			</div>
			
			<div class="page-section">
				<div class="elem">
					<label>Practices:</label>
					<form:select id="spiritualPracticeTypes" path="spiritualPracticeTypeStr" multiple="true" class="multi-select">
						<option value="">Select Practice</option>
						<c:if test="${not empty spiritualPracticeTypes }">
						<c:forEach var="obj" items="${spiritualPracticeTypes }">
							<form:option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</form:option>
						</c:forEach>
					</c:if>
					</form:select>
				</div>
				<div class="elem col-12">
					<label>Period:</label>
					<form:select id="spdDays" path="spiritualPracticeDuration.days" class="col-1">
						<option value="">Select Days</option>
						<c:forEach var="obj" begin="0" end="30">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</form:select>
					
					
					<form:select id="spdMonths" path="spiritualPracticeDuration.months" class="col-1">
						<option value="">Select Month</option>
						<c:forEach var="obj" begin="0" end="12">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</form:select>
					
					<form:select id="spdYears" path="spiritualPracticeDuration.years" class="col-1">
						<option value="">Select Years</option>
						<c:forEach var="obj" begin="0" end="100">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</form:select>
					</div>
				<div class="elem">
					<label>Current Treatment Comments:</label>
					<form:textarea id="spiritualPracticeDurationComments" path="spiritualPracticeDuration.comments" />
				</div>
			</div>
			<div class="page-section">	
				<div class="elem">
					<label>Pulse:</label>
					<form:input id="pulse" path="pulse" />
				</div>
				<div class="elem">
					<label>Blood Pressure:</label>
					<form:input id="bloodPressure" path="bloodPressure" />
				</div>
				<div class="elem">
					<label>Temperature:</label>
					<form:input id="temparature" path="temparature" />
				</div>
				<div class="elem">
					<label>Resparatory Rate:</label>
					<form:input id="respiratoryRate" path="respiratoryRate" />
				</div>
				<div class="elem">
					<label>Height:</label>
					<form:input id="height" path="height" />
				</div>
				 <div class="elem">
					<label>Weight:</label>
					<form:input id="weight" path="weight" />
				</div>
			</div>
			
			<div class="page-section">
				<div class="elem">
					<label>Illness Details:</label>
					<select id="illness" name="illness">
						<option value="">Select Support</option>
						<c:if test="${not empty spiritualPracticeTypes }">
							<c:forEach var="obj" items="${spiritualPracticeTypes }">
								<option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="elem">
					<label>Period</label>
					<select id="motherTongue" name="illness_period" class="col-3">
						<option value="">Select Month</option>
						<c:forEach var="obj" begin="0" end="12">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</select>
					<select id="motherTongue" path="weight" class="col-3">
						<option value="">Select Year</option>
						<c:forEach var="obj" begin="0" end="100">
							<option id="${obj}" value="${obj}">${obj}</option>
						</c:forEach>
					</select>
				</div>
				<div class="elem ">
					<label>Investigation Details:</label>
					<select id="motherTongue" class="col-3 multi-select" multiple="true" >
						<option value="">Select Investigation Details</option>
						<c:forEach var="obj" items="${treatmentTypes }">
							<option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="elem">
					<label>Description:</label>
					<textarea name="description"></textarea>
				</div>
				<div class="elem ">
					<label>Attachments:</label>
					<form:input type="file" path="weight" />
				</div>
				<input type="button" class="btn-success " value="Add More" onclick="addIllnessHistory()">
				
				
				<div id="dyn-ill-history" style="padding:20px;"></div>
				
				<form:hidden path="illnessHistoryJson" id="illHistory"/>
			</div>
			
			<input type="submit" class="btn-success " value="Save">
		</form:form>
	</div>
	
	<div id="tpls" style="display:none;">
		<div id="illnessHistoryTpl">
			<div class="illnessHistory" id="history___INDEX__" style="background-color:yellow;margin-top: 20px;">
			<div class="elem ">
				<label>Illness Details:</label>
				<select id="illHis___INDEX___details" >
					<option value="">Select Support</option>
					<c:if test="${not empty spiritualPracticeTypes }">
					<c:forEach var="obj" items="${spiritualPracticeTypes }">
						<option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</option>
					</c:forEach>
				</c:if>
				</select>
			</div>
			<div class="elem">
				<label>Period</label>
				<select id="illHis___INDEX___month" class="col-3">
					<option value="">Select Month</option>
					<c:forEach var="obj" begin="0" end="12">
						<option id="${obj}" value="${obj}">${obj}</option>
					</c:forEach>
				</select>
				<select id="illHis___INDEX___year"  class="col-3">
					<option value="">Select Year</option>
					<c:forEach var="obj" begin="0" end="100">
						<option id="${obj}" value="${obj}">${obj}</option>
					</c:forEach>
				</select>
			</div>
			<div class="elem ">
				<label>Investigation Details:</label>
				<select id="illHis___INDEX___investigation_details" class="col-3 multi-select" multiple="true">
					<c:forEach var="obj" items="${treatmentTypes }">
						<option id="${obj.id}" value="${obj.id}">${obj.lookupValue}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="elem">
				<label>Description:</label>
				<textarea id="illHis___INDEX___description"></textarea>
			</div>
			<div class="elem ">
				<label>Attachments:</label>
				<input type="file"  />
			</div>
			
			<input type="button" class="btn-danger right" value="Delete" onclick="deleteIllnessHistory(__INDEX__)">
		</div>
		</div>
	</div>
	
	<script type="text/javascript">
		var illHisIdx = 0;
		var illHisObj = {};
		var illnessInvestigationDtls = [];
		
		$(document).ready(function(){
			
		});
		
		function addIllnessHistory(){
			var illnessHisTpl = $('#illnessHistoryTpl').html();
			illnessHisTpl = illnessHisTpl.replace(/__INDEX__/g, illHisIdx++);
			$('#dyn-ill-history').append(illnessHisTpl);
		}
		
		function deleteIllnessHistory(idx) {
			$('#history_'+idx).remove();	
		}
		
		function submitIllnessForm() {
			prepareIllnessHistory()
			return true;
		}
		
		function prepareIllnessHistory() {
			var illHisCnt = $('#dyn-ill-history .illnessHistory').length;	
			var illHistory = [];
			
			for(var idx = 0; idx <  illHisCnt; idx++) {
				var illnessDetails = $('#illHis_'+ idx+'_details').val();
				var illnessMonth = $('#illHis_'+ idx+'_month').val();
				var illnessYear = $('#illHis_'+ idx+'_year').val();
				var illnessInvestigation = $('#illHis_'+ idx+'_investigation_details').val();
				var description = $('#illHis_'+ idx+'_description').val();
				
				_getHisInvDtls(illnessInvestigation);
				
				var obj = {
						illnessType							: {id: illnessDetails},
						months								: illnessMonth,
						years								: illnessYear,
						illnessHistoryInvestigationDetails	: illnessInvestigationDtls,
						comments							: description
				};
				
				illHistory.push(obj);
			}
			
			$('#illHistory').val(JSON.stringify(illHistory));
		}
		
		function _getHisInvDtls(invst) {
			illnessInvestigationDtls = [];
			
			for(i=0; i<invst.length; i++) {
				console.log(invst[i])
				illnessInvestigationDtls.push({investigationType:{id:invst[i]}});
			}
		}
		
	</script>
</body>
</html>
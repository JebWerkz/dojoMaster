
<%@ page import="com.jebwerkz.dojoMaster.attendance.AttendanceCard" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'attendanceCard.label', default: 'AttendanceCard')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-attendanceCard" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link action="renderAttendanceCard" id="${attendanceCardInstance.id}">Render as PDF</g:link></li>
			</ul>
		</div>
		<div id="show-attendanceCard" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

            <ol class="property-list attendanceCard">
			
				<g:if test="${attendanceCardInstance?.attendances}">
				<li class="fieldcontain">
					<span id="attendances-label" class="property-label"><g:message code="attendanceCard.attendances.label" default="Attendances" /></span>
					
						<g:each in="${attendanceCardInstance.attendances}" var="a">
						<span class="property-value" aria-labelledby="attendances-label"><g:link controller="attendance" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${attendanceCardInstance?.dateEarned}">
				<li class="fieldcontain">
					<span id="dateEarned-label" class="property-label"><g:message code="attendanceCard.dateEarned.label" default="Date Earned" /></span>
					
						<span class="property-value" aria-labelledby="dateEarned-label"><g:formatDate date="${attendanceCardInstance?.dateEarned}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${attendanceCardInstance?.rank}">
				<li class="fieldcontain">
					<span id="rank-label" class="property-label"><g:message code="attendanceCard.rank.label" default="Rank" /></span>
					
						<span class="property-value" aria-labelledby="rank-label"><g:link controller="rank" action="show" id="${attendanceCardInstance?.rank?.id}">${attendanceCardInstance?.rank?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${attendanceCardInstance?.student}">
				<li class="fieldcontain">
					<span id="student-label" class="property-label"><g:message code="attendanceCard.student.label" default="Student" /></span>
					
						<span class="property-value" aria-labelledby="student-label"><g:link controller="person" action="show" id="${attendanceCardInstance?.student?.id}">${attendanceCardInstance?.student?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:attendanceCardInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${attendanceCardInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>


<%@ page import="com.jebwerkz.dojoMaster.attendance.AttendanceCard" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'attendanceCard.label', default: 'AttendanceCard')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-attendanceCard" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-attendanceCard" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateEarned" title="${message(code: 'attendanceCard.dateEarned.label', default: 'Date Earned')}" />
					
						<th><g:message code="attendanceCard.student.label" default="Student" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${attendanceCardInstanceList}" status="i" var="attendanceCardInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${attendanceCardInstance.id}">${fieldValue(bean: attendanceCardInstance, field: "dateEarned")}</g:link></td>
					
						<td>${fieldValue(bean: attendanceCardInstance, field: "student")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${attendanceCardInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

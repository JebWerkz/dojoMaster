
<%@ page import="com.jebwerkz.dojoMaster.rank.Rank" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rank.label', default: 'Rank')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-rank" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-rank" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="rank.art.label" default="Art" /></th>
					
						<g:sortableColumn property="belt" title="${message(code: 'rank.belt.label', default: 'Belt')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'rank.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'rank.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="nameKr" title="${message(code: 'rank.nameKr.label', default: 'Name Kr')}" />
					
						<th><g:message code="rank.team.label" default="Team" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rankInstanceList}" status="i" var="rankInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rankInstance.id}">${fieldValue(bean: rankInstance, field: "art")}</g:link></td>
					
						<td>${fieldValue(bean: rankInstance, field: "belt")}</td>
					
						<td>${fieldValue(bean: rankInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: rankInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: rankInstance, field: "nameKr")}</td>
					
						<td>${fieldValue(bean: rankInstance, field: "team")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${rankInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

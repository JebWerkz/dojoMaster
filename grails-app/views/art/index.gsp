
<%@ page import="com.jebwerkz.dojoMaster.art.Art" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'art.label', default: 'Art')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-art" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-art" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'art.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'art.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="nameKr" title="${message(code: 'art.nameKr.label', default: 'Korean')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${artInstanceList}" status="i" var="artInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${artInstance.id}">${fieldValue(bean: artInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: artInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: artInstance, field: "nameKr")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${artInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

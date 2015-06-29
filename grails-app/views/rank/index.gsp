
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
					
						<th><g:message code="rank.topColor.label" default="Top Color" /></th>
					
						<th><g:message code="rank.topCollarColor.label" default="Top Collar Color" /></th>
					
						<th><g:message code="rank.topCollarStripeColor.label" default="Top Collar Stripe Color" /></th>
					
						<g:sortableColumn property="topCollarStripeCount" title="${message(code: 'rank.topCollarStripeCount.label', default: 'Top Collar Stripe Count')}" />
					
						<th><g:message code="rank.chevronColor.label" default="Chevron Color" /></th>
					
						<g:sortableColumn property="chevronCount" title="${message(code: 'rank.chevronCount.label', default: 'Chevron Count')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rankInstanceList}" status="i" var="rankInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rankInstance.id}">${fieldValue(bean: rankInstance, field: "topColor")}</g:link></td>
					
						<td>${fieldValue(bean: rankInstance, field: "topCollarColor")}</td>
					
						<td>${fieldValue(bean: rankInstance, field: "topCollarStripeColor")}</td>
					
						<td>${fieldValue(bean: rankInstance, field: "topCollarStripeCount")}</td>
					
						<td>${fieldValue(bean: rankInstance, field: "chevronColor")}</td>
					
						<td>${fieldValue(bean: rankInstance, field: "chevronCount")}</td>
					
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

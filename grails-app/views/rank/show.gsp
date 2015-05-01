
<%@ page import="com.jebwerkz.dojoMaster.rank.Rank" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rank.label', default: 'Rank')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-rank" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-rank" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list rank">
			
				<g:if test="${rankInstance?.art}">
				<li class="fieldcontain">
					<span id="art-label" class="property-label"><g:message code="rank.art.label" default="Art" /></span>
					
						<span class="property-value" aria-labelledby="art-label"><g:link controller="art" action="show" id="${rankInstance?.art?.id}">${rankInstance?.art?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.belt}">
				<li class="fieldcontain">
					<span id="belt-label" class="property-label"><g:message code="rank.belt.label" default="Belt" /></span>
					
						<span class="property-value" aria-labelledby="belt-label"><g:fieldValue bean="${rankInstance}" field="belt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="rank.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${rankInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="rank.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${rankInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.nameKr}">
				<li class="fieldcontain">
					<span id="nameKr-label" class="property-label"><g:message code="rank.nameKr.label" default="Name Kr" /></span>
					
						<span class="property-value" aria-labelledby="nameKr-label"><g:fieldValue bean="${rankInstance}" field="nameKr"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.team}">
				<li class="fieldcontain">
					<span id="team-label" class="property-label"><g:message code="rank.team.label" default="Team" /></span>
					
						<span class="property-value" aria-labelledby="team-label"><g:link controller="team" action="show" id="${rankInstance?.team?.id}">${rankInstance?.team?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="rank.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${rankInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:rankInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${rankInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

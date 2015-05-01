
<%@ page import="com.jebwerkz.dojoMaster.art.Art" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'art.label', default: 'Art')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-art" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-art" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list art">
			
				<g:if test="${artInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="art.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${artInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="art.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${artInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artInstance?.nameKr}">
				<li class="fieldcontain">
					<span id="nameKr-label" class="property-label"><g:message code="art.nameKr.label" default="Name Kr" /></span>
					
						<span class="property-value" aria-labelledby="nameKr-label"><g:fieldValue bean="${artInstance}" field="nameKr"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artInstance?.ranks}">
				<li class="fieldcontain">
					<span id="ranks-label" class="property-label"><g:message code="art.ranks.label" default="Ranks" /></span>
					
						<g:each in="${artInstance.ranks}" var="r">
						<span class="property-value" aria-labelledby="ranks-label"><g:link controller="rank" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:artInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${artInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

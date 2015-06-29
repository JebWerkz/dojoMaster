
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
			
				<g:if test="${rankInstance?.topColor}">
				<li class="fieldcontain">
					<span id="topColor-label" class="property-label"><g:message code="rank.topColor.label" default="Top Color" /></span>
					
						<span class="property-value" aria-labelledby="topColor-label"><g:link controller="color" action="show" id="${rankInstance?.topColor?.id}">${rankInstance?.topColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.topCollarColor}">
				<li class="fieldcontain">
					<span id="topCollarColor-label" class="property-label"><g:message code="rank.topCollarColor.label" default="Top Collar Color" /></span>
					
						<span class="property-value" aria-labelledby="topCollarColor-label"><g:link controller="color" action="show" id="${rankInstance?.topCollarColor?.id}">${rankInstance?.topCollarColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.topCollarStripeColor}">
				<li class="fieldcontain">
					<span id="topCollarStripeColor-label" class="property-label"><g:message code="rank.topCollarStripeColor.label" default="Top Collar Stripe Color" /></span>
					
						<span class="property-value" aria-labelledby="topCollarStripeColor-label"><g:link controller="color" action="show" id="${rankInstance?.topCollarStripeColor?.id}">${rankInstance?.topCollarStripeColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.topCollarStripeCount}">
				<li class="fieldcontain">
					<span id="topCollarStripeCount-label" class="property-label"><g:message code="rank.topCollarStripeCount.label" default="Top Collar Stripe Count" /></span>
					
						<span class="property-value" aria-labelledby="topCollarStripeCount-label"><g:fieldValue bean="${rankInstance}" field="topCollarStripeCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.chevronColor}">
				<li class="fieldcontain">
					<span id="chevronColor-label" class="property-label"><g:message code="rank.chevronColor.label" default="Chevron Color" /></span>
					
						<span class="property-value" aria-labelledby="chevronColor-label"><g:link controller="color" action="show" id="${rankInstance?.chevronColor?.id}">${rankInstance?.chevronColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.chevronCount}">
				<li class="fieldcontain">
					<span id="chevronCount-label" class="property-label"><g:message code="rank.chevronCount.label" default="Chevron Count" /></span>
					
						<span class="property-value" aria-labelledby="chevronCount-label"><g:fieldValue bean="${rankInstance}" field="chevronCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.pantsColor}">
				<li class="fieldcontain">
					<span id="pantsColor-label" class="property-label"><g:message code="rank.pantsColor.label" default="Pants Color" /></span>
					
						<span class="property-value" aria-labelledby="pantsColor-label"><g:link controller="color" action="show" id="${rankInstance?.pantsColor?.id}">${rankInstance?.pantsColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltColor}">
				<li class="fieldcontain">
					<span id="beltColor-label" class="property-label"><g:message code="rank.beltColor.label" default="Belt Color" /></span>
					
						<span class="property-value" aria-labelledby="beltColor-label"><g:link controller="color" action="show" id="${rankInstance?.beltColor?.id}">${rankInstance?.beltColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltStripeColor}">
				<li class="fieldcontain">
					<span id="beltStripeColor-label" class="property-label"><g:message code="rank.beltStripeColor.label" default="Belt Stripe Color" /></span>
					
						<span class="property-value" aria-labelledby="beltStripeColor-label"><g:link controller="color" action="show" id="${rankInstance?.beltStripeColor?.id}">${rankInstance?.beltStripeColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltStripeCount}">
				<li class="fieldcontain">
					<span id="beltStripeCount-label" class="property-label"><g:message code="rank.beltStripeCount.label" default="Belt Stripe Count" /></span>
					
						<span class="property-value" aria-labelledby="beltStripeCount-label"><g:fieldValue bean="${rankInstance}" field="beltStripeCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltRankStripeColor}">
				<li class="fieldcontain">
					<span id="beltRankStripeColor-label" class="property-label"><g:message code="rank.beltRankStripeColor.label" default="Belt Rank Stripe Color" /></span>
					
						<span class="property-value" aria-labelledby="beltRankStripeColor-label"><g:link controller="color" action="show" id="${rankInstance?.beltRankStripeColor?.id}">${rankInstance?.beltRankStripeColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltRankStripeCount}">
				<li class="fieldcontain">
					<span id="beltRankStripeCount-label" class="property-label"><g:message code="rank.beltRankStripeCount.label" default="Belt Rank Stripe Count" /></span>
					
						<span class="property-value" aria-labelledby="beltRankStripeCount-label"><g:fieldValue bean="${rankInstance}" field="beltRankStripeCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltEmbroideryLeft}">
				<li class="fieldcontain">
					<span id="beltEmbroideryLeft-label" class="property-label"><g:message code="rank.beltEmbroideryLeft.label" default="Belt Embroidery Left" /></span>
					
						<span class="property-value" aria-labelledby="beltEmbroideryLeft-label"><g:fieldValue bean="${rankInstance}" field="beltEmbroideryLeft"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltEmbbroideryRight}">
				<li class="fieldcontain">
					<span id="beltEmbbroideryRight-label" class="property-label"><g:message code="rank.beltEmbbroideryRight.label" default="Belt Embbroidery Right" /></span>
					
						<span class="property-value" aria-labelledby="beltEmbbroideryRight-label"><g:fieldValue bean="${rankInstance}" field="beltEmbbroideryRight"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltEmbroideryColor}">
				<li class="fieldcontain">
					<span id="beltEmbroideryColor-label" class="property-label"><g:message code="rank.beltEmbroideryColor.label" default="Belt Embroidery Color" /></span>
					
						<span class="property-value" aria-labelledby="beltEmbroideryColor-label"><g:link controller="color" action="show" id="${rankInstance?.beltEmbroideryColor?.id}">${rankInstance?.beltEmbroideryColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.beltBorderColor}">
				<li class="fieldcontain">
					<span id="beltBorderColor-label" class="property-label"><g:message code="rank.beltBorderColor.label" default="Belt Border Color" /></span>
					
						<span class="property-value" aria-labelledby="beltBorderColor-label"><g:link controller="color" action="show" id="${rankInstance?.beltBorderColor?.id}">${rankInstance?.beltBorderColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.skillStripeColor}">
				<li class="fieldcontain">
					<span id="skillStripeColor-label" class="property-label"><g:message code="rank.skillStripeColor.label" default="Skill Stripe Color" /></span>
					
						<span class="property-value" aria-labelledby="skillStripeColor-label"><g:link controller="color" action="show" id="${rankInstance?.skillStripeColor?.id}">${rankInstance?.skillStripeColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.skillStripeCoun}">
				<li class="fieldcontain">
					<span id="skillStripeCoun-label" class="property-label"><g:message code="rank.skillStripeCoun.label" default="Skill Stripe Coun" /></span>
					
						<span class="property-value" aria-labelledby="skillStripeCoun-label"><g:fieldValue bean="${rankInstance}" field="skillStripeCoun"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.attitudeStripeColor}">
				<li class="fieldcontain">
					<span id="attitudeStripeColor-label" class="property-label"><g:message code="rank.attitudeStripeColor.label" default="Attitude Stripe Color" /></span>
					
						<span class="property-value" aria-labelledby="attitudeStripeColor-label"><g:link controller="color" action="show" id="${rankInstance?.attitudeStripeColor?.id}">${rankInstance?.attitudeStripeColor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.attitudeStripeCount}">
				<li class="fieldcontain">
					<span id="attitudeStripeCount-label" class="property-label"><g:message code="rank.attitudeStripeCount.label" default="Attitude Stripe Count" /></span>
					
						<span class="property-value" aria-labelledby="attitudeStripeCount-label"><g:fieldValue bean="${rankInstance}" field="attitudeStripeCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="rank.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${rankInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.art}">
				<li class="fieldcontain">
					<span id="art-label" class="property-label"><g:message code="rank.art.label" default="Art" /></span>
					
						<span class="property-value" aria-labelledby="art-label"><g:link controller="art" action="show" id="${rankInstance?.art?.id}">${rankInstance?.art?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rankInstance?.level}">
				<li class="fieldcontain">
					<span id="level-label" class="property-label"><g:message code="rank.level.label" default="Level" /></span>
					
						<span class="property-value" aria-labelledby="level-label"><g:link controller="level" action="show" id="${rankInstance?.level?.id}">${rankInstance?.level?.encodeAsHTML()}</g:link></span>
					
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
					
						<span class="property-value" aria-labelledby="title-label"><g:link controller="rankTitle" action="show" id="${rankInstance?.title?.id}">${rankInstance?.title?.encodeAsHTML()}</g:link></span>
					
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

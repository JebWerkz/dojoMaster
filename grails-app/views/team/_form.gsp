<%@ page import="com.jebwerkz.dojoMaster.team.Team" %>



<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'color', 'error')} required">
	<label for="color">
		<g:message code="team.color.label" default="Color" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="color" required="" value="${teamInstance?.color}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="team.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${teamInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="team.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${teamInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teamInstance, field: 'ranks', 'error')} ">
	<label for="ranks">
		<g:message code="team.ranks.label" default="Ranks" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${teamInstance?.ranks?}" var="r">
    <li><g:link controller="rank" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="rank" action="create" params="['team.id': teamInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'rank.label', default: 'Rank')])}</g:link>
</li>
</ul>


</div>


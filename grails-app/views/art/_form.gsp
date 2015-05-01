<%@ page import="com.jebwerkz.dojoMaster.art.Art" %>



<div class="fieldcontain ${hasErrors(bean: artInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="art.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${artInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: artInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="art.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${artInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: artInstance, field: 'nameKr', 'error')} required">
	<label for="nameKr">
		<g:message code="art.nameKr.label" default="Name Kr" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nameKr" required="" value="${artInstance?.nameKr}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: artInstance, field: 'ranks', 'error')} ">
	<label for="ranks">
		<g:message code="art.ranks.label" default="Ranks" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${artInstance?.ranks?}" var="r">
    <li><g:link controller="rank" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="rank" action="create" params="['art.id': artInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'rank.label', default: 'Rank')])}</g:link>
</li>
</ul>


</div>


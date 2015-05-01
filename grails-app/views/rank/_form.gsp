<%@ page import="com.jebwerkz.dojoMaster.rank.Rank" %>



<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'art', 'error')} required">
	<label for="art">
		<g:message code="rank.art.label" default="Art" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="art" name="art.id" from="${com.jebwerkz.dojoMaster.art.Art.list()}" optionKey="id" required="" value="${rankInstance?.art?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'belt', 'error')} required">
	<label for="belt">
		<g:message code="rank.belt.label" default="Belt" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="belt" required="" value="${rankInstance?.belt}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="rank.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${rankInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="rank.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${rankInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'nameKr', 'error')} required">
	<label for="nameKr">
		<g:message code="rank.nameKr.label" default="Name Kr" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nameKr" required="" value="${rankInstance?.nameKr}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'team', 'error')} required">
	<label for="team">
		<g:message code="rank.team.label" default="Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="team" name="team.id" from="${com.jebwerkz.dojoMaster.team.Team.list()}" optionKey="id" required="" value="${rankInstance?.team?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="rank.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${rankInstance?.title}"/>

</div>


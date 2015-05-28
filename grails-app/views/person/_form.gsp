<%@ page import="com.jebwerkz.dojoMaster.person.Person" %>

<g:javascript>
$( document ).ready(function() {
    $('#authorizedAccounts').bootstrapDualListbox({
        nonSelectedListLabel: 'Non-selected',
        selectedListLabel: 'Selected',
        preserveSelectionOnMove: 'moved',
        moveOnSelect: false
    });
    
    $('#children').bootstrapDualListbox({
        nonSelectedListLabel: 'Non-selected',
        selectedListLabel: 'Selected',
        preserveSelectionOnMove: 'moved',
        moveOnSelect: false
    });
    
    $('#ranks').bootstrapDualListbox({
        nonSelectedListLabel: 'Non-selected',
        selectedListLabel: 'Selected',
        preserveSelectionOnMove: 'moved',
        moveOnSelect: false
    });
    
    $('.date-picker').datepicker({
        autoclose: true
    });
})
</g:javascript>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'cards', 'error')} ">
	<label for="cards">
		<g:message code="person.cards.label" default="Cards" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.cards?}" var="c">
    <li><g:link controller="attendanceCard" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="attendanceCard" action="create" params="['person': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'attendanceCard.label', default: 'AttendanceCard')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="person.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${personInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="person.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${personInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'dateOfBirth', 'error')} required">
	<label for="dateOfBirth">
		<g:message code="person.dateOfBirth.label" default="Date Of Birth" />
		<span class="required-indicator">*</span>
	</label>
    <g:textField name="dateOfBirth" required="" class="date-picker" value="${personInstance?.dateOfBirth}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'ranks', 'error')} ">
	<label for="ranks">
		<g:message code="person.ranks.label" default="Ranks" />
		
	</label>
	<g:select name="ranks" from="${com.jebwerkz.dojoMaster.rank.Rank.list()}" multiple="multiple" optionKey="id" size="5" value="${personInstance?.ranks*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'authorizedAccounts', 'error')} ">
	<label for="authorizedAccounts">
		<g:message code="person.authorizedAccounts.label" default="Authorized Accounts" />
		
	</label>
	<g:select name="authorizedAccounts" from="${com.jebwerkz.dojoMaster.person.Person.list()}" multiple="multiple" optionKey="id" size="5" value="${personInstance?.authorizedAccounts*.id}" class="many-to-many"/>

</div>

<g:if test="${personInstance?.children}">
	<div class="fieldcontain">
		<span id="children-label" class="property-label"><g:message code="person.children.label" default="Children" /></span>
			<g:each in="${personInstance.children}" var="c">
				<span class="property-value" aria-labelledby="children-label"><g:link controller="person" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
			</g:each>
	</div>
</g:if>
	


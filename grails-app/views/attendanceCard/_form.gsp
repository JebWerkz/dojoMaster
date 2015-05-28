<%@ page import="com.jebwerkz.dojoMaster.attendance.AttendanceCard" %>

</div>

<div class="fieldcontain ${hasErrors(bean: attendanceCardInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="attendanceCard.student.label" default="Student" />
	</label>
	<g:hiddenField id="student" name="student.id" value="${person}"/>
    <g:link controller="person" action="show" id="${person}">${com.jebwerkz.dojoMaster.person.Person.get(person).toString()}</g:link>

</div>

<div class="fieldcontain ${hasErrors(bean: attendanceCardInstance, field: 'rank', 'error')} required">
	<label for="rank">
		<g:message code="attendanceCard.rank.label" default="Rank" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="rank" name="rank.id" from="${com.jebwerkz.dojoMaster.person.Person.get(person)?.ranks}" optionKey="id" required="" value="${attendanceCardInstance?.rank?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: attendanceCardInstance, field: 'dateEarned', 'error')} required">
	<label for="dateEarned">
		<g:message code="attendanceCard.dateEarned.label" default="Date Earned" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateEarned" precision="day"  value="${attendanceCardInstance?.dateEarned}"  />

</div>



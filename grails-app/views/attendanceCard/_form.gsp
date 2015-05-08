<%@ page import="com.jebwerkz.dojoMaster.attendance.AttendanceCard" %>



<div class="fieldcontain ${hasErrors(bean: attendanceCardInstance, field: 'attendances', 'error')} ">
	<label for="attendances">
		<g:message code="attendanceCard.attendances.label" default="Attendances" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${attendanceCardInstance?.attendances?}" var="a">
    <li><g:link controller="attendance" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="attendance" action="create" params="['attendanceCard.id': attendanceCardInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'attendance.label', default: 'Attendance')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: attendanceCardInstance, field: 'dateEarned', 'error')} required">
	<label for="dateEarned">
		<g:message code="attendanceCard.dateEarned.label" default="Date Earned" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateEarned" precision="day"  value="${attendanceCardInstance?.dateEarned}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: attendanceCardInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="attendanceCard.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${com.jebwerkz.dojoMaster.person.Person.list()}" optionKey="id" required="" value="${attendanceCardInstance?.student?.id}" class="many-to-one"/>

</div>


<%@ page import="com.jebwerkz.dojoMaster.rank.Rank" %>



<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'topColor', 'error')} ">
	<label for="topColor">
		<g:message code="rank.topColor.label" default="Top Color" />
		
	</label>
	<g:select id="topColor" name="topColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.topColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'topCollarColor', 'error')} ">
	<label for="topCollarColor">
		<g:message code="rank.topCollarColor.label" default="Top Collar Color" />
		
	</label>
	<g:select id="topCollarColor" name="topCollarColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.topCollarColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'topCollarStripeColor', 'error')} ">
	<label for="topCollarStripeColor">
		<g:message code="rank.topCollarStripeColor.label" default="Top Collar Stripe Color" />
		
	</label>
	<g:select id="topCollarStripeColor" name="topCollarStripeColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.topCollarStripeColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'topCollarStripeCount', 'error')} required">
	<label for="topCollarStripeCount">
		<g:message code="rank.topCollarStripeCount.label" default="Top Collar Stripe Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="topCollarStripeCount" type="number" value="${rankInstance.topCollarStripeCount}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'chevronColor', 'error')} ">
	<label for="chevronColor">
		<g:message code="rank.chevronColor.label" default="Chevron Color" />
		
	</label>
	<g:select id="chevronColor" name="chevronColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.chevronColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'chevronCount', 'error')} required">
	<label for="chevronCount">
		<g:message code="rank.chevronCount.label" default="Chevron Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="chevronCount" type="number" value="${rankInstance.chevronCount}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'pantsColor', 'error')} ">
	<label for="pantsColor">
		<g:message code="rank.pantsColor.label" default="Pants Color" />
		
	</label>
	<g:select id="pantsColor" name="pantsColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.pantsColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltColor', 'error')} ">
	<label for="beltColor">
		<g:message code="rank.beltColor.label" default="Belt Color" />
		
	</label>
	<g:select id="beltColor" name="beltColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.beltColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltStripeColor', 'error')} ">
	<label for="beltStripeColor">
		<g:message code="rank.beltStripeColor.label" default="Belt Stripe Color" />
		
	</label>
	<g:select id="beltStripeColor" name="beltStripeColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.beltStripeColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltStripeCount', 'error')} required">
	<label for="beltStripeCount">
		<g:message code="rank.beltStripeCount.label" default="Belt Stripe Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="beltStripeCount" type="number" value="${rankInstance.beltStripeCount}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltRankStripeColor', 'error')} ">
	<label for="beltRankStripeColor">
		<g:message code="rank.beltRankStripeColor.label" default="Belt Rank Stripe Color" />
		
	</label>
	<g:select id="beltRankStripeColor" name="beltRankStripeColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.beltRankStripeColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltRankStripeCount', 'error')} required">
	<label for="beltRankStripeCount">
		<g:message code="rank.beltRankStripeCount.label" default="Belt Rank Stripe Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="beltRankStripeCount" type="number" value="${rankInstance.beltRankStripeCount}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltEmbroideryLeft', 'error')} ">
	<label for="beltEmbroideryLeft">
		<g:message code="rank.beltEmbroideryLeft.label" default="Belt Embroidery Left" />
		
	</label>
	<g:textField name="beltEmbroideryLeft" value="${rankInstance?.beltEmbroideryLeft}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltEmbbroideryRight', 'error')} ">
	<label for="beltEmbbroideryRight">
		<g:message code="rank.beltEmbbroideryRight.label" default="Belt Embbroidery Right" />
		
	</label>
	<g:textField name="beltEmbbroideryRight" value="${rankInstance?.beltEmbbroideryRight}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltEmbroideryColor', 'error')} ">
	<label for="beltEmbroideryColor">
		<g:message code="rank.beltEmbroideryColor.label" default="Belt Embroidery Color" />
		
	</label>
	<g:select id="beltEmbroideryColor" name="beltEmbroideryColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.beltEmbroideryColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'beltBorderColor', 'error')} ">
	<label for="beltBorderColor">
		<g:message code="rank.beltBorderColor.label" default="Belt Border Color" />
		
	</label>
	<g:select id="beltBorderColor" name="beltBorderColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.beltBorderColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'skillStripeColor', 'error')} ">
	<label for="skillStripeColor">
		<g:message code="rank.skillStripeColor.label" default="Skill Stripe Color" />
		
	</label>
	<g:select id="skillStripeColor" name="skillStripeColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.skillStripeColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'skillStripeCoun', 'error')} required">
	<label for="skillStripeCoun">
		<g:message code="rank.skillStripeCoun.label" default="Skill Stripe Coun" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="skillStripeCoun" type="number" value="${rankInstance.skillStripeCoun}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'attitudeStripeColor', 'error')} ">
	<label for="attitudeStripeColor">
		<g:message code="rank.attitudeStripeColor.label" default="Attitude Stripe Color" />
		
	</label>
	<g:select id="attitudeStripeColor" name="attitudeStripeColor.id" from="${com.jebwerkz.dojoMaster.rank.Color.list()}" optionKey="id" value="${rankInstance?.attitudeStripeColor?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'attitudeStripeCount', 'error')} required">
	<label for="attitudeStripeCount">
		<g:message code="rank.attitudeStripeCount.label" default="Attitude Stripe Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="attitudeStripeCount" type="number" value="${rankInstance.attitudeStripeCount}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="rank.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${rankInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'art', 'error')} required">
	<label for="art">
		<g:message code="rank.art.label" default="Art" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="art" name="art.id" from="${com.jebwerkz.dojoMaster.art.Art.list()}" optionKey="id" required="" value="${rankInstance?.art?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rankInstance, field: 'level', 'error')} required">
	<label for="level">
		<g:message code="rank.level.label" default="Level" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="level" name="level.id" from="${com.jebwerkz.dojoMaster.curriculum.Level.list()}" optionKey="id" required="" value="${rankInstance?.level?.id}" class="many-to-one"/>

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
	<g:select id="title" name="title.id" from="${com.jebwerkz.dojoMaster.rank.RankTitle.list()}" optionKey="id" required="" value="${rankInstance?.title?.id}" class="many-to-one"/>

</div>


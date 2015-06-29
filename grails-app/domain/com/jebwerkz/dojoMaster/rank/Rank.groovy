package com.jebwerkz.dojoMaster.rank

import com.jebwerkz.dojoMaster.art.Art
import com.jebwerkz.dojoMaster.team.Team
import com.jebwerkz.dojoMaster.curriculum.Level

class Rank {

    static belongsTo = [art:Art, team:Team, level:Level]

    String      name
    String      nameKr
    RankTitle   title
    
    Color		topColor
    Color		topCollarColor
    Color		topCollarStripeColor
    int			topCollarStripeCount
    
    Color		chevronColor
    int			chevronCount
    
    Color		pantsColor
    
    Color		beltColor
    Color		beltStripeColor
    int			beltStripeCount
    
    Color		beltRankStripeColor
    int			beltRankStripeCount
    
    Color		beltEmbroideryColor
    String		beltEmbroideryLeft
    String		beltEmbbroideryRight
    
    Color		beltBorderColor
    
    Color		skillStripeColor
    int			skillStripeCount
    Color		attitudeStripeColor
    int			attitudeStripeCount
    
    String      description

    String toString() {
        "$team/$art - $name"
    }

    static constraints = {
    	topColor nullable: true
    	topCollarColor nullable: true
    	topCollarStripeColor nullable: true
    	topCollarStripeCount  nullable: true
    	
    	chevronColor nullable: true
    	chevronCount nullable: true
    	
    	pantsColor nullable: true
    	
    	beltColor nullable: true
    	beltStripeColor nullable: true
    	beltStripeCount defaultValue: 0
    	
    	beltRankStripeColor nullable: true
    	beltRankStripeCount defaultValue: 0
    	
    	beltEmbroideryLeft nullable: true
    	beltEmbbroideryRight nullable: true
    	beltEmbroideryColor nullable: true
    	
    	beltBorderColor nullable: true
    	
    	skillStripeColor nullable: true
	    skillStripeCount defaultValue: 0
	    attitudeStripeColor nullable: true
	    attitudeStripeCount defaultValue: 0
     	
    	description nullable: true
    }
}

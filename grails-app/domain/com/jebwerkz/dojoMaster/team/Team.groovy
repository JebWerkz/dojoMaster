package com.jebwerkz.dojoMaster.team

import com.jebwerkz.dojoMaster.rank.Rank
import com.jebwerkz.dojoMaster.curriculum.Level

class Team {
    
    String name
    String color
    String description
    String chineseCharacter

    String toString() {
        "$name"
    }

    static hasMany = [ranks:Rank, levels:Level]

    static constraints = {
    }
}

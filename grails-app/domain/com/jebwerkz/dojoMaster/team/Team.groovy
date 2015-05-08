package com.jebwerkz.dojoMaster.team

import com.jebwerkz.dojoMaster.rank.Rank

class Team {
    
    String name
    String color
    String description
    String chinese_character

    String toString() {
        "$name"
    }

    static hasMany = [ranks:Rank]

    static constraints = {
    }
}

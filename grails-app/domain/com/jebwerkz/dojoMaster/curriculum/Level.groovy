package com.jebwerkz.dojoMaster.curriculum

import com.jebwerkz.dojoMaster.art.Art
import com.jebwerkz.dojoMaster.rank.Rank
import com.jebwerkz.dojoMaster.team.Team
import com.jebwerkz.dojoMaster.curriculum.technique.Technique
import com.jebwerkz.dojoMaster.curriculum.Stance
import com.jebwerkz.dojoMaster.curriculum.form.Form

class Level {

    static belongsTo = [art:Art, team:Team]
   
    String name

    static hasMany = [ranks:Rank, techniques:Technique, stances:Stance, forms:Form]

    static constraints = {
    }
}

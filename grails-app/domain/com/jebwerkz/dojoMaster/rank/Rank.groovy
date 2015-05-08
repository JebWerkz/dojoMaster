package com.jebwerkz.dojoMaster.rank

import com.jebwerkz.dojoMaster.art.Art
import com.jebwerkz.dojoMaster.team.Team
import com.jebwerkz.dojoMaster.curriculum.Level

class Rank {

    static belongsTo = [art:Art, team:Team, level:Level]

    String      name
    String      nameKr
    RankTitle   title
    String      belt
    String      uniform
    String      chevrons
    String      description

    String toString() {
        "$team/$art - $name"
    }

    static constraints = {
    }
}

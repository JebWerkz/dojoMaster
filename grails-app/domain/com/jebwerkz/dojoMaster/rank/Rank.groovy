package com.jebwerkz.dojoMaster.rank

import com.jebwerkz.dojoMaster.art.Art
import com.jebwerkz.dojoMaster.team.Team

class Rank {

    static belongsTo = [art:Art, team:Team]

    String name
    String nameKr
    String title
    String belt
    String description

    static constraints = {
    }
}

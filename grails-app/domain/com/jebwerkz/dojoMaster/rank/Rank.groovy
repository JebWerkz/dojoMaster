package com.jebwerkz.dojoMaster.rank

import com.jebwerkz.dojoMaster.art.Art
import com.jebwerkz.dojoMaster.team.Team

class Rank {

    static belongsTo = [art:Art, team:Team]

    String name
    String nameKr
    String title
    String belt
    String uniform
    String chevrons
    String description

    String toString() {
        "$team/$art - $name"
    }

    static constraints = {
    }
}

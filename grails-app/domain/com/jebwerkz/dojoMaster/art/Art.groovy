package com.jebwerkz.dojoMaster.art

import com.jebwerkz.dojoMaster.rank.Rank
import com.jebwerkz.dojoMaster.curriculum.Level

class Art {
    
    String name
    String nameKr
    String description

    static hasMany = [ranks:Rank, levels:Level]

    String toString() {
        "$nameKr - $name"
    }

    String getNameKr() {
        "${nameKr.encodeAsHTML()}"
    }

    static constraints = {
    }
}

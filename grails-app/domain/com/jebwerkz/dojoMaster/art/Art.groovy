package com.jebwerkz.dojoMaster.art

import com.jebwerkz.dojoMaster.rank.Rank

class Art {
    
    String name
    String nameKr
    String description

    static hasMany = [ranks:Rank]

    String toString() {
        "$nameKr - $name"
    }

    String getNameKr() {
        "${nameKr.encodeAsHTML()}"
    }

    static constraints = {
    }
}

package com.jebwerkz.dojoMaster.curriculum.technique

import com.jebwerkz.dojoMaster.curriculum.Level

class Technique {
    static belongsTo = [level:Level]
    
    String  name
    String  nameKr
    String  description

    static hasMany = [categories:TechniqueCategory]

    static constraints = {
    }
}

package com.jebwerkz.dojoMaster.curriculum.form

import com.jebwerkz.dojoMaster.curriculum.Stance
import com.jebwerkz.dojoMaster.curriculum.technique.Technique

class FormStep {

    static belongsTo = [form:Form]

    int     number
    char    part
    String  description

    static hasMany = [stances:Stance, techniques:Technique]

    static constraints = {
    }
}

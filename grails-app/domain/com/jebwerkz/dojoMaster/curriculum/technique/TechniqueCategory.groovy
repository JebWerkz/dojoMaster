package com.jebwerkz.dojoMaster.curriculum.technique

class TechniqueCategory {

    static belongsTo = Technique

    String  name
    String  nameKr 

    static hasMany = [techniques:Technique]

    static constraints = {
    }
}

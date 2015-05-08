package com.jebwerkz.dojoMaster.curriculum.form

class Form {
    String  name
    String  nameKr
    String  description

    static hasMany = [steps:FormStep]

    static constraints = {
    }
}

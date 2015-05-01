package com.jebwerkz.dojoMaster.person

import com.jebwerkz.dojoMaster.rank.Rank

class Person {

    String  lastName
    String  firstName
    Date    dateOfBirth

    static hasMany = [ranks:Rank]
    static constraints = {
    }
}

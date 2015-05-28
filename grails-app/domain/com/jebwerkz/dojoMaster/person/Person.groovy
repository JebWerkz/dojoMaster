package com.jebwerkz.dojoMaster.person

import com.jebwerkz.dojoMaster.rank.Rank
import com.jebwerkz.dojoMaster.attendance.AttendanceCard

class Person {

    String  lastName
    String  firstName
    Date    dateOfBirth

    static hasMany = [ranks:Rank, authorizedAccounts:Person, children:Person, cards:AttendanceCard]
   
    boolean isStudent(){
        ranks?.size() > 0
    }

    boolean hasChildren(){
        children?.size() > 0
    }

    String toString() {
        "$lastName, $firstName"
    }

    AttendanceCard getCard(Rank r){
        cards.find {
            it.rank.id = r.id
        }
    }

    static constraints = {
    }
}

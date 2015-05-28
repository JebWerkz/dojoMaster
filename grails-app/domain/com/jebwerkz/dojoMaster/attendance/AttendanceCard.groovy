package com.jebwerkz.dojoMaster.attendance

import com.jebwerkz.dojoMaster.person.Person
import com.jebwerkz.dojoMaster.rank.Rank

class AttendanceCard {
    
    static belongsTo = [student:Person]

    Date dateEarned
    Rank rank

    String toString() {
        return "${student.toString()} - ${rank.toString()}"
    }

    static hasMany = [attendances:Attendance]

    static constraints = {
    }
}

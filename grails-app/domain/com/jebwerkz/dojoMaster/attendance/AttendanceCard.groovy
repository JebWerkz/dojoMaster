package com.jebwerkz.dojoMaster.attendance

import com.jebwerkz.dojoMaster.person.Person

class AttendanceCard {
    
    static belongsTo = [student:Person]

    Date dateEarned

    static hasMany = [attendances:Attendance]

    static constraints = {
    }
}

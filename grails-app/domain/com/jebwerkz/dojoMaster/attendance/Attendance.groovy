package com.jebwerkz.dojoMaster.attendance

class Attendance {
    static belongsTo = [card:AttendanceCard]

    Date date

    static constraints = {
    }
}

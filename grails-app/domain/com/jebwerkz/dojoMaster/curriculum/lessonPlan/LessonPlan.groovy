package com.jebwerkz.dojoMaster.curriculum.lessonPlan

class LessonPlan {
    static belongsTo = [quarter:Quarter]

    int week

    static hasMany = [categories:LessonPlanCategory]
    
    static constraints = {
    }
}

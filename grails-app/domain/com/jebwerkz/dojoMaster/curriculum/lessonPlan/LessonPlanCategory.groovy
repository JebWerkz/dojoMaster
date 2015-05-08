package com.jebwerkz.dojoMaster.curriculum.lessonPlan

class LessonPlanCategory {
    static belongsTo = LessonPlan
    
    String name

    static hasMany = [lessonPlans:LessonPlan]

    static constraints = {
    }
}

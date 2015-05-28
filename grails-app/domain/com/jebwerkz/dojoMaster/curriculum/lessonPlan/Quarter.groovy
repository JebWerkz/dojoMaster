package com.jebwerkz.dojoMaster.curriculum.lessonPlan

class Quarter {

    int     sortOrder
    String  color

    static hasMany = [lessonPlans:LessonPlan]

    static constraints = {
    }
}

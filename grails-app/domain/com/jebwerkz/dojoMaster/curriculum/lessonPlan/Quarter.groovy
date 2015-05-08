package com.jebwerkz.dojoMaster.curriculum.lessonPlan

class Quarter {

    int     order
    String  color

    static hasMany = [lessonPlans:LessonPlan]

    static constraints = {
    }
}

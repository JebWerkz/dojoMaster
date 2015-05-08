package com.jebwerkz.dojoMaster.attendance



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AttendanceCardController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {

    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AttendanceCard.list(params), model:[attendanceCardInstanceCount: AttendanceCard.count()]
    }

    def show(AttendanceCard attendanceCardInstance) {
        respond attendanceCardInstance
    }

    def create() {
        respond new AttendanceCard(params)
    }

    @Transactional
    def save(AttendanceCard attendanceCardInstance) {
        if (attendanceCardInstance == null) {
            notFound()
            return
        }

        if (attendanceCardInstance.hasErrors()) {
            respond attendanceCardInstance.errors, view:'create'
            return
        }

        attendanceCardInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'attendanceCard.label', default: 'AttendanceCard'), attendanceCardInstance.id])
                redirect attendanceCardInstance
            }
            '*' { respond attendanceCardInstance, [status: CREATED] }
        }
    }

    def edit(AttendanceCard attendanceCardInstance) {
        respond attendanceCardInstance
    }

    @Transactional
    def update(AttendanceCard attendanceCardInstance) {
        if (attendanceCardInstance == null) {
            notFound()
            return
        }

        if (attendanceCardInstance.hasErrors()) {
            respond attendanceCardInstance.errors, view:'edit'
            return
        }

        attendanceCardInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AttendanceCard.label', default: 'AttendanceCard'), attendanceCardInstance.id])
                redirect attendanceCardInstance
            }
            '*'{ respond attendanceCardInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AttendanceCard attendanceCardInstance) {

        if (attendanceCardInstance == null) {
            notFound()
            return
        }

        attendanceCardInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AttendanceCard.label', default: 'AttendanceCard'), attendanceCardInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'attendanceCard.label', default: 'AttendanceCard'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

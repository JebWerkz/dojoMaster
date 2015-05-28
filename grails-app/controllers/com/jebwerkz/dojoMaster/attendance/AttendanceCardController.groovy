package com.jebwerkz.dojoMaster.attendance



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AttendanceCardController {

    def attendanceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {

    }

    def renderAttendanceCard() {
        // setting some response headers

        def attendanceCardInstance = AttendanceCard.get(params.id)

        def baos = attendanceService.createPdf(attendanceCardInstance)

        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control",
            "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        // setting the content type
        response.setContentType("application/pdf");
        // the contentlength
        response.setContentLength(baos.size());
        // write ByteArrayOutputStream to the ServletOutputStream
        OutputStream os = response.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();

        response
//        params.max = Math.min(max ?: 10, 100)
//        respond AttendanceCard.list(params), model:[attendanceCardInstanceCount: AttendanceCard.count()]
    }

    def show(AttendanceCard attendanceCardInstance) {
        [attendanceCardInstance: attendanceCardInstance, person:params.person]
    }

    def create() {
        [attendanceCardInstance: new AttendanceCard(params), person: params.person]
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
        
        [attendanceCardInstance: attendanceCardInstance, person: attendanceCardInstance.student.id]
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

    def renderCard() {
        renderPdf(template:'test')
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

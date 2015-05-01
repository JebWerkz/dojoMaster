package com.jebwerkz.dojoMaster.rank



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RankController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Rank.list(params), model:[rankInstanceCount: Rank.count()]
    }

    def show(Rank rankInstance) {
        respond rankInstance
    }

    def create() {
        respond new Rank(params)
    }

    @Transactional
    def save(Rank rankInstance) {
        if (rankInstance == null) {
            notFound()
            return
        }

        if (rankInstance.hasErrors()) {
            respond rankInstance.errors, view:'create'
            return
        }

        rankInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rank.label', default: 'Rank'), rankInstance.id])
                redirect rankInstance
            }
            '*' { respond rankInstance, [status: CREATED] }
        }
    }

    def edit(Rank rankInstance) {
        respond rankInstance
    }

    @Transactional
    def update(Rank rankInstance) {
        if (rankInstance == null) {
            notFound()
            return
        }

        if (rankInstance.hasErrors()) {
            respond rankInstance.errors, view:'edit'
            return
        }

        rankInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Rank.label', default: 'Rank'), rankInstance.id])
                redirect rankInstance
            }
            '*'{ respond rankInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Rank rankInstance) {

        if (rankInstance == null) {
            notFound()
            return
        }

        rankInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Rank.label', default: 'Rank'), rankInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rank.label', default: 'Rank'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package com.jebwerkz.dojoMaster.art



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ArtController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Art.list(params), model:[artInstanceCount: Art.count()]
    }

    def show(Art artInstance) {
        respond artInstance
    }

    def create() {
        respond new Art(params)
    }

    @Transactional
    def save(Art artInstance) {
        if (artInstance == null) {
            notFound()
            return
        }

        if (artInstance.hasErrors()) {
            respond artInstance.errors, view:'create'
            return
        }

        artInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'art.label', default: 'Art'), artInstance.id])
                redirect artInstance
            }
            '*' { respond artInstance, [status: CREATED] }
        }
    }

    def edit(Art artInstance) {
        respond artInstance
    }

    @Transactional
    def update(Art artInstance) {
        if (artInstance == null) {
            notFound()
            return
        }

        if (artInstance.hasErrors()) {
            respond artInstance.errors, view:'edit'
            return
        }

        artInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Art.label', default: 'Art'), artInstance.id])
                redirect artInstance
            }
            '*'{ respond artInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Art artInstance) {

        if (artInstance == null) {
            notFound()
            return
        }

        artInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Art.label', default: 'Art'), artInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'art.label', default: 'Art'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package com.jebwerkz.dojoMaster.error

import org.codehaus.groovy.grails.commons.GrailsApplication
import grails.util.GrailsUtil

class ErrorController {

    def index() {
        try {
        // "Do stuff" with the exception:
        Exception exception = request.exception
        println "Here's what happened: ${exception}"

        if ( GrailsApplication.ENV_PRODUCTION == GrailsUtil.environment ) {
        // Production: show a nice error message
            render(view:'production')
        } else {
        // Not it production? show an ugly, developer-focused error message
            render(view:'development')
        }

        } catch ( Exception e ) {
            render(view: 'unhandleable')
        }
    }
}

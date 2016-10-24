package demo

import grails.validation.Validateable

class Widget implements Validateable {
    String nullableProp
    String notNullableProp

    static constraints = {
        nullableProp nullable: true
    }
}


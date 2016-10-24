package demo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Person)
class PersonSpec extends Specification {


    void "test validation"() {
        when:
        def p = new Person()

        then:
        !p.validate()

        and:
        p.errors.errorCount == 2

        and:
        p.errors['firstName'].code == 'nullable'
        p.errors['firstName'].code == 'nullable'
    }

    void "test constraints"() {
        // this is really testing an impl detail but is here for demonstration purposes
        when:
        def constrainedProps = Person.constrainedProperties

        then:
        constrainedProps['firstName'].nullable == false
        constrainedProps['middleName'].nullable == true
        constrainedProps['lastName'].nullable == false
    }
}

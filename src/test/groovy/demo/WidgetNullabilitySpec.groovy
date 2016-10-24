package demo

import spock.lang.Specification

class WidgetNullabilitySpec extends Specification {

    void "test validation"() {
        when:
        def w = new Widget()

        then:
        !w.validate()

        and:
        w.errors.errorCount == 1

        and:
        w.errors['notNullableProp'].code == 'nullable'
    }

    void "test constraints"() {
        // this is really testing an impl detail but is here for demonstration purposes
        when:
        def constrainedProps = Widget.constraintsMap

        then:
        constrainedProps['notNullableProp'].nullable == false
        constrainedProps['nullableProp'].nullable == true
    }
}

package demo

class Person {
    String firstName
    String middleName
    String lastName

    static constraints = {
        middleName nullable: true
    }
}

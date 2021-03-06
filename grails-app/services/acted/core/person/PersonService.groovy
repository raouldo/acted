package acted.core.person

import grails.transaction.Transactional

@Transactional
class PersonService implements PersonInterface {

    Person createPerson(properties) {
        Person person = new Person()

        properties.each {
            person[it.key] = it.value
        }

        return person
    }
}

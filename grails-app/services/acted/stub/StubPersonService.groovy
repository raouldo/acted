package acted.stub

import acted.core.PersonInterface
import acted.core.person.Person
import grails.transaction.Transactional

@Transactional
class StubPersonService implements PersonInterface {

    Person createPerson(properties) {
        Person person = new Person()

        properties.each {
            person[it.key] = it.value
        }

        return person
    }
}

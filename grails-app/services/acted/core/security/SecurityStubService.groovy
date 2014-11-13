package acted.core.security

import acted.core.person.Person
import grails.transaction.Transactional

@Transactional
class SecurityStubService implements SecurityInterface {

    boolean hasRight(Person person, Object object) {
        return true
    }


}

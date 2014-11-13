package acted.core.security

import acted.core.person.Person
import grails.transaction.Transactional

@Transactional
class SecurityService implements SecurityInterface {

    boolean hasRight(Person person, Object object) {
        throw new SecurityException('This method is not ready now.')
    }

}

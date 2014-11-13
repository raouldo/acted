package acted.core.security

import acted.core.person.Person

/**
 * Created by raoul on 13/11/14.
 */
interface SecurityInterface {

    boolean hasRight(Person person, Object object)

}
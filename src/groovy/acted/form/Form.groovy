package acted.form

import acted.core.person.Person

/**
 * Created by raoul on 30/10/14.
 */
class Form {

    Long number

    // From FormEnum enum
    String type

    Date dateCreated

    ArrayList<Person> completedBy
    ArrayList<Person> signedBy
    ArrayList<Person> verifiedBy
    ArrayList<Person> inWitnessOf

}

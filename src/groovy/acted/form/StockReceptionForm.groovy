package acted.form

import acted.Item
import acted.core.person.Person
import acted.structure.Warehouse


/**
 * Created by raoul on 30/10/14.
 */
class StockReceptionForm extends Form {

    //Why this item should be delivered?
    Form contract

    String driverFirstName
    String driverLastName
    Long driverNumber

    Long vehiculeNumber

    Warehouse deliveryLocation

    ArrayList<Item> items

}

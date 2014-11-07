package acted.form

import acted.core.person.Person
import acted.process.stock.Article

/**
 * Created by raoul on 30/10/14.
 */
class StockReceptionForm extends Form {

	//Why this item should be delivered?
	Form contract

	String driverFirstName
	String driverLastName

	String consignorFirstName
	String consignorLastName

	Long driverNumber

	Long vehiculeNumber

	String deliveryLocation
	String receivingLocation

	ArrayList<Article> articles

	String status

}

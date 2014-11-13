package acted.utils

import acted.core.Project
import acted.core.person.Person
import acted.form.StockReceptionForm
import acted.process.stock.Article
import acted.structure.Warehouse

class ExamplesService {

	def stubProjectService
	def stubStockService
	def stubStructureService
	def stubPersonService

	def serviceMethod() {
	}

	def simuWarehouse(){
		Warehouse warehouse = stubStructureService.createWarehouse([
			id      : 1,
			name    : 'warehouse 007',
			location: 'Soudan'
		])
		return warehouse
	}
	def simuWarehouse2(){
		Warehouse warehouse = stubStructureService.createWarehouse([
			id      : 1,
			name    : 'warehouse 007',
			location: 'Soudan'
		])
		return warehouse
	}

	def simuProject(){
		Project project = stubProjectService.createProject([id: 2])
		return project
	}

	def simuArticle(){

		Article article = stubStockService.createArticle(
				[
					project : this.simuProject(),
					quantity: 2,
					unit    : 'l'
				])
		return article
	}

	def simuPerson(int k){
		String firstName="";
		String lastName="";
		if(k==0){
			firstName='Sylvain';
			lastName='Tenk';
		}else if (k==1){
			firstName='Otto';
			lastName='Rastapopoulos';
		}else if (k==2){
			firstName='Tommy';
			lastName='Hanks';
		}
		Person person = stubPersonService.createPerson(
				[
					firstName: firstName,
					lastName: lastName,
				])
		return person
	}

	def simuStockReceptionForm(){
		Person consignor = simuPerson(2)
		StockReceptionForm stockReceptionForm = stubStockService.createStockReceptionForm(
				[	id              : 12,
					//type            : FormEnum.STOCK_RECEPTION.toString(),
					dateCreated     : new Date(),
					completedBy     : [simuPerson(0)],
					driverFirstName : 'Felipe',
					driverLastName  : 'Felipe',
					driverNumber    : 265439,

					consignorFirstName    : consignor.getFirstName(),
					consignorLastName    : consignor.getLastName(),

					vehiculeNumber  : 21584,
					deliveryLocation: 'Soudan',
					receivingLocation: 'France',

					articles        : [this.simuArticle(), this.simuArticle(), this.simuArticle()]]
				)
		return stockReceptionForm
	}
}

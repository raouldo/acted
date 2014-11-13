package acted.stock

import acted.core.Project
import acted.core.person.Person
import acted.form.StockReceptionForm
import acted.process.stock.Article
import acted.structure.Warehouse

class StoreInspectionController {

	def projectStubService
	def stockStubService
	def structureStubService
	def personStubService

	def index() {
		Warehouse warehouse = structureStubService.createWarehouse([
			id      : 1,
			name    : 'warehouse 007',
			location: 'Soudan'
		])

		Project project = projectStubService.createProject([id: 2])

		Article article01 = stockStubService.createArticle(
				[
					project : project,
					quantity: 2,
					unit    : 'l'
				])

		Article article02 = stockStubService.createArticle(
				[
					project : project,
					quantity: 2,
					unit    : 'l'
				])
		Article article03 = stockStubService.createArticle(
				[
					project : project,
					quantity: 2,
					unit    : 'l'
				])

		Person person = personStubService.createPerson(
				[
					firstName: 'Sylvain',
					lastName: 'Tenk',
					//role: RoleEnum.CAPITAL_LOGISTICS_OFFICER.toString()
				])

		StockReceptionForm stockReceptionForm = stockStubService.createStockReceptionForm(
				[
					id              : 12,
					//type            : FormEnum.STOCK_RECEPTION.toString(),
					dateCreated     : new Date(),
					completedBy     : [person],
					driverFirstName : 'Felipe',
					driverLastName  : 'Felipe',
					driverNumber    : 48541,

					vehiculeNumber  : 21584,
					deliveryLocation: warehouse,

					articles        : [article01, article02, article03]]
				)

		Person person02 = personStubService.createPerson(
				[
					firstName: 'Otto',
					lastName: 'Rastapopoulos',
					//role: RoleEnum.CAPITAL_LOGISTICS_OFFICER.toString()
				])

		stockReceptionForm = stockStubService.updateStockReceptionForm(stockReceptionForm,
				[
					signedBy: [person02]]
				)

		if (stockReceptionForm.signedBy.contains(person02)) {
			// Validation of the form
			stockStubService.validateReceptionForm(stockReceptionForm)

			// Adding articles to the physical stock
			stockStubService.stockIn(stockReceptionForm)
		}

		//Ici affichage, on retourne la variable : stockReceptionForm
		render(view:'/STO/storeInspectionSheet', model:[stockReceptionForm:stockReceptionForm])
	}
}

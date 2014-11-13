package acted.stock

import acted.core.Project
import acted.core.person.Person
import acted.form.StockReceptionForm
import acted.process.stock.Article
import acted.structure.Warehouse



class StockReceptionController {

	def stubProjectService
	def stubStockService
	def stubStructureService
	def stubPersonService

	def examplesService

	//Pour y accéder : http://localhost:8080/acted/test/warehouse
	def warehouse() {
		//Création d'un warehouse
		Warehouse warehouse = examplesService.simuWarehouse()

		//Affichage de la vue
		//On passe l'objet warehouse à la vue
		render(view:'/test/warehouse', model:[warehouse:warehouse])
	}

	//Pour y accéder : http://localhost:8080/acted/test/project
	def project() {
		//Création d'un project
		Project project = examplesService.simuProject()

		//Affichage de la vue
		//On passe l'objet projet à la vue
		render(view:'/test/project', model:[project:project])
	}

	//Pour y accéder : http://localhost:8080/acted/test/stockReceptionForm
	def index() {
		Warehouse warehouse = examplesService.simuWarehouse()

		Project project = examplesService.simuProject()

		Article article01 = examplesService.simuArticle()
		Article article02 = examplesService.simuArticle()
		Article article03 = examplesService.simuArticle()

		Person person = examplesService.simuPerson(0)

		StockReceptionForm stockReceptionForm = examplesService.simuStockReceptionForm()

		Person person02 = examplesService.simuPerson(1)


		stockReceptionForm = stubStockService.updateStockReceptionForm(stockReceptionForm,
				[
					signedBy: [person02]]
				)

		if (stockReceptionForm.signedBy.contains(person02)) {
			// Validation of the form
			stubStockService.validateReceptionForm(stockReceptionForm)

			// Adding articles to the physical stock
			stubStockService.stockIn(stockReceptionForm)
		}

		//Ici affichage, on retourne la variable : stockReceptionForm
		render(view:'/STO/stockReceptionForm', model:[stockReceptionForm:stockReceptionForm])
	}

	def createStockReceptionForm() {

		Warehouse warehouse = examplesService.simuWarehouse()

		Project project = examplesService.simuProject()

		Article article01 = examplesService.simuArticle()
		Article article02 = examplesService.simuArticle()
		Article article03 = examplesService.simuArticle()

		Person person = examplesService.simuPerson(0)

		StockReceptionForm stockReceptionForm = examplesService.simuStockReceptionForm()

		Person person02 = examplesService.simuPerson(1)


		stockReceptionForm = stubStockService.updateStockReceptionForm(stockReceptionForm,
				[
					signedBy: [person02]]
				)

		if (stockReceptionForm.signedBy.contains(person02)) {
			// Validation of the form
			stubStockService.validateReceptionForm(stockReceptionForm)

			// Adding articles to the physical stock
			stubStockService.stockIn(stockReceptionForm)
		}

		render "${stockReceptionForm.properties}"
	}

	def readStockReceptionForm() {
		StockReceptionForm stockReceptionForm = stubStockService.readStockReceptionForm(13)

		render stockReceptionForm.properties
	}

	def updateStockReceptionForm() {
		StockReceptionForm stockReceptionForm = stubStockService.createStockReceptionForm([id: 12])
		stockReceptionForm = stubStockService.updateStockReceptionForm(stockReceptionForm, [id: 15])

		render stockReceptionForm.properties
	}

	def deleteStockReceptionForm() {
		render stubStockService.deleteStockReceptionForm(18)
	}

}

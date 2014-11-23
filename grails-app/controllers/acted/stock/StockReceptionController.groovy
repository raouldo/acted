package acted.stock

import grails.converters.JSON
import acted.core.Project
import acted.core.person.Person
import acted.form.StockReceptionForm
import acted.process.stock.Article
import acted.structure.Warehouse



class StockReceptionController {

	//	def beforeInterceptor = [action:this.&checkUser,except:
	//		['index', 'list', 'show']]
	//	def scaffold = true
	//	def checkUser() {
	//		if(!session.user) {
	//			// i.e. user not logged in
	//			redirect(controller:'user',action:'login')
	//			return false
	//		}
	//	}


	//	def authenticationService
	//	def onlyLoggedInUsers = {
	//		if (!authenticationService.isLoggedIn(request)) {
	//			// Redirect or return Forbidden
	//			response.sendError(403)
	//		} else {
	//			// do something
	//		}
	//	}


	def projectStubService
	def stockStubService
	def structureStubService
	def personStubService

	def examplesService

	def warehouse() {
		//Création d'un warehouse
		Warehouse warehouse = examplesService.simuWarehouse()

		//Affichage de la vue
		//On passe l'objet warehouse à la vue
		render(view:'/test/warehouse', model:[warehouse:warehouse])
	}

	def project() {
		//Création d'un project
		Project project = examplesService.simuProject()

		//Affichage de la vue
		//On passe l'objet projet à la vue
		render(view:'/test/project', model:[project:project])
	}

	def index() {

		StockReceptionForm stockReceptionForm = examplesService.simuStockReceptionForm()

		Person person02 = examplesService.simuPerson(1)

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

		String listLineTableSRF = stockReceptionForm.getListLineTableSRF()

		//Ici affichage, on retourne la variable : stockReceptionForm
		render(view:'/STO/stockReceptionForm', model:[stockReceptionForm:stockReceptionForm])
	}

	def indexJSON() {
		render examplesService.simuListLineTableSRF() as JSON
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

		render "${stockReceptionForm.properties}"
	}

	def readStockReceptionForm() {
		StockReceptionForm stockReceptionForm = stockStubService.readStockReceptionForm(13)

		render stockReceptionForm.properties
	}

	def updateStockReceptionForm() {
		StockReceptionForm stockReceptionForm = stockStubService.createStockReceptionForm([id: 12])
		stockReceptionForm = stockStubService.updateStockReceptionForm(stockReceptionForm, [id: 15])

		render stockReceptionForm.properties
	}

	def deleteStockReceptionForm() {
		render stockStubService.deleteStockReceptionForm(18)
	}
}

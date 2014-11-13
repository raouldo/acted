package acted

import acted.command.CreateProjectCommand
import acted.core.Project
import acted.core.person.Person
import acted.form.StockReceptionForm
import acted.process.stock.Article
import acted.structure.Warehouse

class TestController {

	def projectStubService
	def stockStubService
	def structureStubService
	def personStubService

	//Pour y accéder : http://localhost:8080/acted/test/warehouse
	def warehouse() {
		//Création d'un warehouse
		Warehouse warehouse = structureStubService.createWarehouse([
			id      : 1,
			name    : 'warehouse 007',
			location: 'Soudan'
		])

		//Affichage de la vue
		//On passe l'objet warehouse à la vue
		render(view:'/test/warehouse', model:[warehouse:warehouse])
	}

	//Pour y accéder : http://localhost:8080/acted/test/project
	def project() {
		//Création d'un project
		Project project = projectStubService.createProject([id: 2])

		//Affichage de la vue
		//On passe l'objet projet à la vue
		render(view:'/test/project', model:[project:project])
	}

	//Pour y accéder : http://localhost:8080/acted/test/stockReceptionForm
	def stockReceptionForm() {
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
		render(view:'/STO/index', model:[stockReceptionForm:stockReceptionForm])
	}

	def createStockReceptionForm() {

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

	def createProject(CreateProjectCommand cmd) {
		// il faut que chaque élément de formulaire dans la vue possède la propriété "name" avec le noms de la propriété correspondante
		// pour que le binding automatique fonctionne.

		Project project

		if (cmd.hasErrors()) {

			// Ici on traite les erreurs...

		} else {

			// S'il n'y a pas d'erreur, on créé l'objet.
			project = projectStubService.createProject([id: cmd.id])
		}

		render project.id
	}

	def readProject() {
		Project project = projectStubService.readProject(15)

		render project.id
	}

	def updateProject() {
		Project project = projectStubService.createProject([id: 12])
		project = projectStubService.updateProject(project, [id: 15])

		render project.id
	}

	def deleteProject() {
		render projectStubService.deleteProject(18)
	}
}

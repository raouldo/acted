package acted

import acted.core.Project
import acted.core.person.Person
import acted.core.security.RoleEnum
import acted.form.FormEnum
import acted.form.StockReceptionForm
import acted.process.stock.Article
import acted.structure.Warehouse

class TestController {

    def stubProjectService
    def stubStockService
    def stubStructureService
    def stubPersonService

    //Pour y accéder : http://localhost:8080/acted/test/warehouse
    def warehouse() {
        //Création d'un warehouse
        Warehouse warehouse = stubStructureService.createWarehouse([
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
        Project project = stubProjectService.createProject([id: 2])

        //Affichage de la vue
        //On passe l'objet projet à la vue
        render(view:'/test/project', model:[project:project])
    }

    //Pour y accéder : http://localhost:8080/acted/test/stockReceptionForm
    def stockReceptionForm() {
        Warehouse warehouse = stubStructureService.createWarehouse([
                id      : 1,
                name    : 'warehouse 007',
                location: 'Soudan'
        ])

        Project project = stubProjectService.createProject([id: 2])

        Article article01 = stubStockService.createArticle(
                [
                        project : project,
                        quantity: 2,
                        unit    : 'l'
                ])

        Article article02 = stubStockService.createArticle(
                [
                        project : project,
                        quantity: 2,
                        unit    : 'l'
                ])
        Article article03 = stubStockService.createArticle(
                [
                        project : project,
                        quantity: 2,
                        unit    : 'l'
                ])

        Person person = stubPersonService.createPerson(
                [
                        firstName: 'Sylvain',
                        lastName: 'Tenk',
                        //role: RoleEnum.CAPITAL_LOGISTICS_OFFICER.toString()
                ])

        StockReceptionForm stockReceptionForm = stubStockService.createStockReceptionForm(
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

                        articles        : [article01, article02, article03]
                ]
        )

        Person person02 = stubPersonService.createPerson(
                [
                        firstName: 'Otto',
                        lastName: 'Rastapopoulos',
                        //role: RoleEnum.CAPITAL_LOGISTICS_OFFICER.toString()
                ])

        stockReceptionForm = stubStockService.updateStockReceptionForm(stockReceptionForm,
                [
                        signedBy: [person02]
                ]
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

        Warehouse warehouse = stubStructureService.createWarehouse([
                id      : 1,
                name    : 'warehouse 007',
                location: 'Soudan'
        ])

        Project project = stubProjectService.createProject([id: 2])

        Article article01 = stubStockService.createArticle(
                [
                        project : project,
                        quantity: 2,
                        unit    : 'l'
                ])

        Article article02 = stubStockService.createArticle(
                [
                        project : project,
                        quantity: 2,
                        unit    : 'l'
                ])
        Article article03 = stubStockService.createArticle(
                [
                        project : project,
                        quantity: 2,
                        unit    : 'l'
                ])

        Person person = stubPersonService.createPerson(
                [
                        firstName: 'Sylvain',
                        lastName: 'Tenk',
                        //role: RoleEnum.CAPITAL_LOGISTICS_OFFICER.toString()
                ])

        StockReceptionForm stockReceptionForm = stubStockService.createStockReceptionForm(
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

                        articles        : [article01, article02, article03]
                ]
        )

        Person person02 = stubPersonService.createPerson(
                [
                        firstName: 'Otto',
                        lastName: 'Rastapopoulos',
                        //role: RoleEnum.CAPITAL_LOGISTICS_OFFICER.toString()
                ])

        stockReceptionForm = stubStockService.updateStockReceptionForm(stockReceptionForm,
                [
                        signedBy: [person02]
                ]
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

    def createProject() {
        Project project = stubProjectService.createProject([id: 12])

        render project.id
    }

    def readProject() {
        Project project = stubProjectService.readProject(15)

        render project.id
    }

    def updateProject() {
        Project project = stubProjectService.createProject([id: 12])
        project = stubProjectService.updateProject(project, [id: 15])

        render project.id
    }

    def deleteProject() {
        render stubProjectService.deleteProject(18)
    }
}

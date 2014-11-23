package acted.utils

import grails.converters.*
import acted.core.Project
import acted.core.person.Person
import acted.form.StockReceptionForm
import acted.process.stock.Article
import acted.process.stock.LineTableSRF
import acted.structure.Warehouse

class ExamplesService {

	def projectStubService
	def stockStubService
	def structureStubService
	def personStubService

	def serviceMethod() {
	}

	def simuWarehouse(){
		Warehouse warehouse = structureStubService.createWarehouse([
			id      : 1,
			name    : 'warehouse 007',
			location: 'Soudan'
		])
		return warehouse
	}
	def simuWarehouse2(){
		Warehouse warehouse = structureStubService.createWarehouse([
			id      : 1,
			name    : 'warehouse 007',
			location: 'Soudan'
		])
		return warehouse
	}

	def simuProject(){
		Project project = projectStubService.createProject([id: 2])
		return project
	}

	def simuArticle(){

		Article article = stockStubService.createArticle(
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
		Person person = personStubService.createPerson(
				[
					firstName: firstName,
					lastName: lastName,
				])
		return person
	}

	def simuStockReceptionForm(){
		Person consignor = simuPerson(2)
		StockReceptionForm stockReceptionForm = stockStubService.createStockReceptionForm(
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

					articles        : [this.simuArticle(), this.simuArticle(), this.simuArticle()],
					status        : 'ok',
					listLineTableSRF: simuListLineTableSRF() as JSON
				]


				)
		return stockReceptionForm
	}

	def simuListLineTableSRF(){
		List<LineTableSRF> listLineTableSRF

		//		listLineTableSRF.add(new LineTableSRF(1, "J7", "353K33", "55", "euros", "1", "in stock"))
		//		listLineTableSRF.add(new LineTableSRF(2, "H6", "GZE1ZZ", "476", "euros", "2", "Ok"))
		//		listLineTableSRF.add(new LineTableSRF(3, "G2", "EZT523", "400", "euros", "1", ""))
		//		listLineTableSRF.add(new LineTableSRF(4, "TT", "TEZ32X", "700", "euros", "2", "in stock"))
		//		listLineTableSRF.add(new LineTableSRF(5, "0B", "J59LL3", "4545", "euros", "4", "in stock"))
		//		listLineTableSRF.add(new LineTableSRF(6, "5H", "ZGEZN3", "40", "euros", "1", "OUT stock"))
		//		listLineTableSRF.add(new LineTableSRF(7, "D2", "353K33", "436", "euros", "2", "in stock"))
		//		listLineTableSRF.add(new LineTableSRF(8, "4G", "89LL89", "5470", "euros", "5", "in stock"))
		//		listLineTableSRF.add(new LineTableSRF(9, "V4", "7TK5KT", "546", "euros", "4", "ok"))
		//		listLineTableSRF.add(new LineTableSRF(10, "F3", "4HY45H", "23", "euros", "2", "verified"))
		//		listLineTableSRF.add(new LineTableSRF(11, "B6", "4H4C0D", "98", "euros", "1", "in stock"))
		//		listLineTableSRF.add(new LineTableSRF(12, "K8", "G45M54", "666", "euros", "2", "in stock"))

		//		LineTableSRF lineTableSRF11 = stockStubService.createLineTableSRF([
		//			id : 11,
		//			date : "B6",
		//			name : "4H4C0D",
		//			note : "98",
		//			amount : "euros",
		//			taxe : "1",
		//			total : "in stock"])
		//		LineTableSRF lineTableSRF12 = stockStubService.createLineTableSRF([
		//			id : 12,
		//			date : "K8",
		//			name : "G45M54",
		//			note : "666",
		//			amount : "euros",
		//			taxe : "2",
		//			total : "in stock"])
		LineTableSRF lineTableSRF11 = stockStubService.createLineTableSRF([
			lineId : 11,
			itemDescription : 'B6',
			projectCode : '4H4C0D',
			quantity : '98',
			unit : 'euros',
			weightOrVolume : '1',
			remarks : 'in stock'])
		LineTableSRF lineTableSRF12 = stockStubService.createLineTableSRF([
			lineId : 12,
			itemDescription : "K8",
			projectCode : "G45M54",
			quantity : "666",
			unit : "euros",
			weightOrVolume : "2",
			remarks : "in stock"])
		return [lineTableSRF11, lineTableSRF12]
	}

	def simuLineTableSRF(int lineId){
		LineTableSRF lineTableSRF

		lineTableSRF.setLineId(lineId)
		lineTableSRF.setItemDescription("G2")
		lineTableSRF.setProjectCode("353K33")
		lineTableSRF.setQuantity("55")
		lineTableSRF.setUnit("euros")
		lineTableSRF.setWeightOrVolume("100")
		lineTableSRF.setRemarks("in stock")

		return lineTableSRF
	}
}

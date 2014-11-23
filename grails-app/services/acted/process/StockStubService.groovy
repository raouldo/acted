package acted.process

import grails.transaction.Transactional
import acted.exception.StockException
import acted.form.StockReceptionForm
import acted.process.stock.Article
import acted.process.stock.LineTableSRF

@Transactional
class StockStubService implements StockInterface {

	boolean testMethod() {
		return true
	}

	StockReceptionForm createStockReceptionForm(Map properties) {
		StockReceptionForm stockReceptionForm = new StockReceptionForm()

		properties.each {
			stockReceptionForm[it.key] = it.value
		}

		return stockReceptionForm
	}

	// Return the Stock Reception Form
	StockReceptionForm readStockReceptionForm(Long id) {
		StockReceptionForm stockReceptionForm = new StockReceptionForm(
				id:id
				)

		return stockReceptionForm
	}

	// Return the updated Stock Reception Form
	StockReceptionForm updateStockReceptionForm(StockReceptionForm stockReceptionForm, Map properties) {
		properties.each {
			stockReceptionForm[it.key] = it.value
		}

		return stockReceptionForm
	}

	// Return true if Stock Reception Form has been deleted properly
	boolean deleteStockReceptionForm(Long id) {
		return true
	}

	StockReceptionForm validateReceptionForm(StockReceptionForm stockReceptionForm) {

		//Check pre-conditions here...

		stockReceptionForm.status = 'Validated'

		return stockReceptionForm
	}

	Article createArticle(Map properties) {
		Article article = new Article()

		properties.each {
			article[it.key] = it.value
		}

		return article
	}

	Article readArticle(Long id) {
		Article article = new Article(
				id:id
				)

		return article

	}

	Article updateArticle(Article article, Map properties) {
		properties.each {
			article[it.key] = it.value
		}

		return article
	}

	boolean deleteArticle(Long id) {
		return true
	}

	LineTableSRF createLineTableSRF(Map properties) {
		LineTableSRF lineTableSRF = new LineTableSRF()

		properties.each {
			lineTableSRF[it.key] = it.value
		}

		return lineTableSRF
	}

	LineTableSRF readLineTableSRF(Long id) {
		LineTableSRF lineTableSRF = new LineTableSRF(
				id:id
				)

		return article

	}

	LineTableSRF updateLineTableSRF(LineTableSRF lineTableSRF, Map properties) {
		properties.each {
			lineTableSRF[it.key] = it.value
		}

		return article
	}

	boolean deleteLineTableSRF(Long id) {
		return true
	}

	boolean stockIn(StockReceptionForm validatedReceptionForm) {
		return true
	}

	boolean stockOut(Article article) {
		return true
	}

	StockException testError() {
		throw new StockException ('Error Message')
	}
}

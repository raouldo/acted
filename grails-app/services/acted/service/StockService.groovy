package acted.service

import acted.core.StockInterface
import acted.exception.StockException
import acted.form.StockReceptionForm
import acted.process.stock.Article
import grails.transaction.Transactional

@Transactional
class StockService implements StockInterface {

    boolean testMethod() {
        return true
    }

    StockReceptionForm createStockReceptionForm(Map properties) {

    }

    // Return the Stock Reception Form
    StockReceptionForm readStockReceptionForm(Long id) {

    }

    // Return the updated Stock Reception Form
    StockReceptionForm updateStockReceptionForm(StockReceptionForm stockReceptionForm, Map properties) {

    }

    Article createArticle(Map properties) {

    }

    Article readArticle(Long id) {

    }

    Article updateArticle(Article article, Map properties) {

    }

    boolean deleteArticle(Long id) {

    }


    // Return true if Stock Reception Form has been deleted properly
    boolean deleteStockReceptionForm(Long id) {
        return true
    }

    boolean stockIn(Article article) {
        return true
    }

    boolean stockOut(Article article) {
        return true
    }

    StockException testError() {
        throw new StockException ('Error Message')
    }
}

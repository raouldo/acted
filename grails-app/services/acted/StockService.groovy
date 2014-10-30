package acted

import grails.transaction.Transactional

@Transactional
class StockService implements StockInterface {

    boolean testMethod() {
	 true
    }

    def createStockReceptionForm() {
        log.info 'Enter the creation Stock Reception Form Method'

    }

    def readStockReceptionForm() {
        log.info 'Enter the read Stock Reception Form Method'

    }

    def updateStockReceptionForm() {
        log.info 'Enter the update Stock Reception Form Method'

    }

    def deleteStockReceptionForm() {
        log.info 'Enter the delete Stock Reception Form Method'

    }
}

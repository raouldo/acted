package acted

import grails.transaction.Transactional

@Transactional
class StubStockService implements StockInterface {

    boolean serviceMethod() {

	return true
    }
}

package acted

import grails.transaction.Transactional

@Transactional
class StockService implements StockInterface {

    boolean serviceMethod() {

	return true

    }
}

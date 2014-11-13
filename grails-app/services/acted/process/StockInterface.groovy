package acted.process

import acted.exception.StockException
import acted.form.StockReceptionForm
import acted.process.stock.Article


/**
 * Created by raoul on 30/10/14.
 *
 * This interface defines all actions to manage stock.
 *
 */

interface StockInterface {

	boolean testMethod()

	StockReceptionForm createStockReceptionForm(Map properties)

	// Return the Stock Reception Form
	StockReceptionForm readStockReceptionForm(Long id)

	// Return the updated Stock Reception Form
	StockReceptionForm updateStockReceptionForm(StockReceptionForm stockReceptionForm, Map properties)

	// Return true if Stock Reception Form has been deleted properly
	boolean deleteStockReceptionForm(Long id)

	StockReceptionForm validateReceptionForm(StockReceptionForm stockReceptionForm)

	boolean stockIn(StockReceptionForm validatedReceptionForm)

	boolean stockOut(Article article)

	Article createArticle(Map properties)

	Article readArticle(Long id)

	Article updateArticle(Article article, Map properties)

	boolean deleteArticle(Long id)

	StockException testError()

}

package acted.process.stock

import acted.core.Project

/**
 * Created by raoul on 30/10/14.
 *
 * Article is also known as stock item.
 *
 */
class Article {

    // Name of the article
    StockCard stockCard

    String packaging
    String weightOrVolume
    String quantity
    String unit

    String remarks

    Project project

    ArrayList<Specification> specifications

    // Standard item designation format
    public String designation() {
        return "${name}, ${specifications.each{ it }}"
    }
}

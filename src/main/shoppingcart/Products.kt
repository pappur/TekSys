package main.shoppingcart

import java.util.ArrayList

class Products {
    val products: MutableList<Product> = ArrayList()

    private fun initProducts() {
        val productNames = arrayOf("apple", "orange")
        val productPrice = arrayOf(0.60, 0.25)
        val prodMinCount = arrayOf(2, 3)

        for (i in productNames.indices) {
            products.add(Product(productNames[i], productPrice[i], prodMinCount[i], 0))
        }
    }

    init {
        initProducts()
    }
}

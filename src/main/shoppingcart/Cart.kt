package main.shoppingcart

import java.util.ArrayList

class Cart {
    var cartItems: MutableList<Product?> = ArrayList()
    var totalPrice = 0.0
    fun addProductToCartByName(name: String) {
        val product = getProductByProductName(name)
        addToCart(product)
    }

    private fun getProductByProductName(pid: String): Product? {
        var product: Product? = null
        val products = Products().products
        for (prod in products) {
            if (prod.name.equals(pid, ignoreCase = true)) {
                product = prod
                break
            }
        }
        return product
    }

    private fun addToCart(product: Product?) {
        cartItems.add(product)
    }

    fun calculateCartItemPrice(): Double {
        for (prod in cartItems) {
            totalPrice += prod!!.price
        }
        return totalPrice
    }
}

package main.shoppingcart

import java.util.ArrayList
import java.util.HashMap

class Cart {
    var cartItems: MutableList<Product?> = ArrayList()
    var totalPrice = 0.0
    var totalDiscountedPrice = 0.0
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

    fun printCartItems() {
        for (prod in cartItems) {
            println(prod!!.name)
        }
    }

    fun calculateCartItemPrice(): Double {
        for (prod in cartItems) {
            totalPrice += prod!!.price
        }
        return totalPrice
    }

    fun calculateDiscountedCartItemPrice(): Double {
        val totalWithNoDiscount = calculateCartItemPrice()
        val prodCount: MutableMap<String, Int> = HashMap()

        for (prod in cartItems) {
            val occurence = prodCount[prod?.name]
            if (prod != null) {
                prodCount[prod.name] = if (occurence == null) 1 else occurence + 1
            }
        }
        for (prod in prodCount) {
            val product = getProductByProductName(prod.key)
            if (product != null) {
                if (prod.value < product.quantity) {


                    val deduction = prod.value / (product?.minCount ?: 0) * product?.price!!
                    if (deduction != null) {
                        totalDiscountedPrice += deduction
                    }
                    product.quantity = product.quantity - prod.value
                } else {
                    System.out.println("ordered item is out of stock")
                }
            }
        }
        return totalWithNoDiscount - totalDiscountedPrice
    }
}


package main.shoppingcart

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.function.Consumer
import java.util.stream.Collectors

class ServicesProvided {
    var cart = Cart()
    fun getUserInput() {
        var userInput = BufferedReader(InputStreamReader(System.`in`))
                .lines().collect(Collectors.toList())
        addProductToCart(userInput)
    }
    fun addProductToCart(userInput: MutableList<String>) {
        userInput.forEach(Consumer { temp: String? -> cart.addProductToCartByName(temp!!) })
    }

    fun calculatePrice(): Double {
        return cart.calculateCartItemPrice()
    }
}

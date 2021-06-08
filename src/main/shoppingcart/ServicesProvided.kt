package main.shoppingcart

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.function.Consumer
import java.util.stream.Collectors
import kotlin.reflect.KClass

object Channel {

    val subscribers: MutableMap<KClass<*>, (Any) -> Unit> = mutableMapOf()

    inline fun <reified T> publish(event: T) {
        subscribers[T::class]?.invoke(event as Any)
    }

    inline fun <reified T> subscribe(noinline subscriber: (T) -> Unit) {
        subscribers[T::class] = subscriber as (Any) -> Unit
    }

}


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

    fun calculateDiscountedPrice(): Double {
        Channel.publish(TransactionEvent("Success", cart.calculateDiscountedCartItemPrice()))
        return cart.calculateDiscountedCartItemPrice()
    }

    fun calculatePrice(): Double {
        return cart.calculateCartItemPrice()
    }
}


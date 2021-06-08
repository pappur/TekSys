package main.shoppingcart

import kotlin.jvm.JvmStatic

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val servicesProvided = ServicesProvided()
        servicesProvided.getUserInput()
        servicesProvided.calculateDiscountedPrice()
        KotlinConsumer.processMessage()
    }
}

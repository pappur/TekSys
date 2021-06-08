package main.shoppingcart

import kotlin.jvm.JvmStatic

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val servicesProvided = ServicesProvided()
        servicesProvided.getUserInput()
        println("total discounted price is $"+ servicesProvided.calculateDiscountedPrice())
    }
}

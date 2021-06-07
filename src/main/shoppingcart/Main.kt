package main.shoppingcart

import kotlin.jvm.JvmStatic

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val servicesProvided = ServicesProvided()
        servicesProvided.getUserInput()
        System.out.println("total price is $"+ servicesProvided.calculatePrice())
    }
}

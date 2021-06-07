package test.shoppingcart

import main.shoppingcart.ServicesProvided
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ServicesProvidedTest {
    private val servicesProvided = ServicesProvided()

    @Test
    fun `The price for user input items is calculated properly` () {
        val userInput = listOf("apple", "apple", "orange", "apple")
        servicesProvided.addProductToCart(userInput as MutableList<String>)
        assertEquals(servicesProvided.calculatePrice(),2.05)
    }
}

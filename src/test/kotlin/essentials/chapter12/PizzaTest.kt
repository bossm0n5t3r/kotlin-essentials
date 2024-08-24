package essentials.chapter12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PizzaTest {
    @Test
    fun testHawaiian() {
        val expected = listOf("ham", "pineapple")
        assertEquals(expected, Pizza.hawaiian().toppings)
    }

    @Test
    fun testMargherita() {
        val expected = listOf("tomato", "mozzarella")
        assertEquals(expected, Pizza.margherita().toppings)
    }
}

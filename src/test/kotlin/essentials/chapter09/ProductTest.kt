package essentials.chapter09

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProductTest {
    @Test
    fun test() {
        val laptop = Product("Laptop", 999.99, 5)

        assertEquals("Laptop", laptop.name)
        assertEquals(5, laptop.quantity)
        assertEquals(4999.95, laptop.calculateTotalValue())

        laptop.restock(3)

        assertEquals(8, laptop.quantity)
        assertEquals(7999.92, laptop.calculateTotalValue())

        laptop.quantity = -2

        assertEquals(0, laptop.quantity)
        assertEquals(0.0, laptop.calculateTotalValue())

        laptop.quantity = 10

        assertEquals(10, laptop.quantity)
        assertEquals(9999.9, laptop.calculateTotalValue())
    }
}

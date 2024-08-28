package essentials.chapter18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InventoryTest {
    private lateinit var inventory: Inventory
    private val apple = Product("1", "Apple", 0.5, "Fruit")
    private val banana = Product("2", "Banana", 0.3, "Fruit")

    @BeforeEach
    fun setup() {
        inventory = Inventory()
    }

    @Test
    fun `addProduct should increase product count and set producer`() {
        inventory.addProduct(apple, "FruitCorp")

        assertEquals(1, inventory.getProductsCount())
        assertTrue(inventory.hasProduct(apple))
        assertEquals("FruitCorp", inventory.getProducer(apple))
    }

    @Test
    fun `removeProduct should decrease product count and remove producer`() {
        inventory.addProduct(apple, "FruitCorp")
        inventory.removeProduct(apple)

        assertEquals(0, inventory.getProductsCount())
        assertFalse(inventory.hasProduct(apple))
        assertNull(inventory.getProducer(apple))
    }

    @Test
    fun `addSeller should add seller to the inventory`() {
        inventory.addSeller("SellerA")

        assertTrue(inventory.produceInventoryDisplay().contains("SellerA"))
    }

    @Test
    fun `removeSeller should remove seller from the inventory`() {
        inventory.addSeller("SellerA")
        inventory.removeSeller("SellerA")

        assertFalse(inventory.produceInventoryDisplay().contains("SellerA"))
    }

    @Test
    fun `produceInventoryDisplay should display products and sellers correctly`() {
        inventory.addProduct(apple, "FruitCorp")
        inventory.addProduct(banana, "TropicalFruitCorp")
        inventory.addSeller("SellerA")
        inventory.addSeller("SellerB")

        val expectedDisplay =
            """
            Inventory:
            Apple (Fruit) - 0.5
            Produced by: FruitCorp
            Banana (Fruit) - 0.3
            Produced by: TropicalFruitCorp
            Sellers: [SellerA, SellerB]
            """.trimIndent()

        assertEquals(expectedDisplay, inventory.produceInventoryDisplay())
    }

    @Test
    fun `hasProducts should return true when there are products`() {
        inventory.addProduct(apple, "FruitCorp")

        assertTrue(inventory.hasProducts())
    }

    @Test
    fun `hasProducts should return false when there are no products`() {
        assertFalse(inventory.hasProducts())
    }

    @Test
    fun `getProducer should return null for nonexistent product`() {
        assertNull(inventory.getProducer(apple))
    }
}

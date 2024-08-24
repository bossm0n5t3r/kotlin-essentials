package essentials.chapter09

class Product(
    val name: String,
    private val price: Double,
    initialQuantity: Int,
) {
    var quantity = initialQuantity.coerceAtLeast(0)
        set(value) {
            field = value.coerceAtLeast(0)
        }

    fun calculateTotalValue() = price * quantity

    fun restock(diff: Int) {
        this.quantity += diff
    }
}

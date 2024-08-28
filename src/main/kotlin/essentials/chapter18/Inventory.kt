package essentials.chapter18

class Inventory {
    private val products = mutableListOf<Product>()
    private val productIdToProducer = mutableMapOf<String, String>()
    private val sellers = mutableSetOf<String>()

    fun addProduct(
        product: Product,
        producer: String,
    ) {
        products.add(product)
        productIdToProducer[product.id] = producer
    }

    fun removeProduct(product: Product) {
        products.remove(product)
        productIdToProducer.remove(product.id)
    }

    fun getProductsCount(): Int = products.size

    fun hasProduct(product: Product): Boolean = products.contains(product)

    fun hasProducts(): Boolean = products.isNotEmpty()

    fun getProducer(product: Product): String? = productIdToProducer[product.id]

    fun addSeller(seller: String) {
        sellers.add(seller)
    }

    fun removeSeller(seller: String) {
        sellers.remove(seller)
    }

    fun produceInventoryDisplay(): String {
        var result = "Inventory:\n"
        for (product in products) {
            result += "${product.name} (${product.category}) - ${product.price}\n"
            result += "Produced by: ${productIdToProducer[product.id]}\n"
        }
        result += "Sellers: $sellers"
        return result
    }
}

class Product(
    val id: String,
    val name: String,
    val price: Double,
    val category: String,
)

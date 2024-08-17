package essentials.chapter06

fun main() {
    fun Iterable<Number>.product(): Long =
        this.fold(1) { acc, number ->
            acc * number.toLong()
        }

    @Suppress("EmptyRange")
    require(1L == (0..-1).product())

    val rangeToProduct =
        mapOf(
            2..4 to 24L,
            1..4 to 24L,
            3..4 to 12L,
            100..100 to 100L,
        )
    for ((range, product) in rangeToProduct) {
        require(product == range.product())
    }

    val collectionToProduct =
        mapOf(
            listOf(1, 2, 3) to 6L,
            listOf(2, 3) to 6L,
            listOf(3) to 3L,
            listOf(10, 10, 10) to 1000L,
        )
    for ((collection, product) in collectionToProduct) {
        require(product == collection.product())
    }
}

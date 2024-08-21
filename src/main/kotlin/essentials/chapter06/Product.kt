package essentials.chapter06

object Product {
    fun Iterable<Number>.product(): Long =
        this.fold(1) { acc, number ->
            acc * number.toLong()
        }
}

package essentials.chapter06

fun main() {
    fun factorial(n: Int): Long {
        if (n == 0) return 1
        return n * factorial(n - 1)
    }

    val numberWithFactorial =
        mapOf(
            0 to 1L,
            1 to 1L,
            2 to 2L,
            3 to 6L,
            4 to 24L,
            10 to 3628800L,
            15 to 1307674368000L,
            20 to 2432902008176640000L,
        )
    for ((i, factorialResult) in numberWithFactorial) {
        require(factorialResult == factorial(i))
    }
}

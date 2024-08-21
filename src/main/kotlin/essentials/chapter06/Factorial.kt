package essentials.chapter06

object Factorial {
    fun factorial(n: Int): Long {
        if (n == 0) return 1
        return n * factorial(n - 1)
    }
}

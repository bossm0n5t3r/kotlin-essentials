package essentials.chapter07

object Loops {
    fun calculateSumOfSquares(n: Int): Int = (0..n).fold(0) { acc, i -> acc + i * i }

    fun calculateSumOfSquaresAnother(n: Int): Int = (0..n).sumOf { it * it }

    fun calculateSumOfEven(n: Int): Int = (0..n).filter { it % 2 == 0 }.sum()

    fun countDownByStep(
        start: Int,
        end: Int,
        step: Int,
    ): String = (start downTo end step step).joinToString()
}

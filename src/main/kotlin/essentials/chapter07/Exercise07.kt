package essentials.chapter07

fun main() {
    fun calculateSumOfSquares(n: Int): Int = (0..n).fold(0) { acc, i -> acc + i * i }

    fun calculateSumOfSquaresAnother(n: Int): Int = (0..n).sumOf { it * it }

    fun calculateSumOfEven(n: Int): Int = (0..n).filter { it % 2 == 0 }.sum()

    fun countDownByStep(
        start: Int,
        end: Int,
        step: Int,
    ): String = (start downTo end step step).joinToString()

    // Examples for calculateSumOfSquares
    require(0 == calculateSumOfSquares(0))
    require(1 == calculateSumOfSquares(1))
    require(5 == calculateSumOfSquares(2))
    require(14 == calculateSumOfSquares(3))
    require(30 == calculateSumOfSquares(4))
    require(385 == calculateSumOfSquares(10))
    require(0 == calculateSumOfSquares(0))
    require(0 == calculateSumOfSquares(-1))
    require(0 == calculateSumOfSquares(-1))
    require(0 == calculateSumOfSquares(-3))

    // Examples for calculateSumOfSquaresAnother
    require(0 == calculateSumOfSquaresAnother(0))
    require(1 == calculateSumOfSquaresAnother(1))
    require(5 == calculateSumOfSquaresAnother(2))
    require(14 == calculateSumOfSquaresAnother(3))
    require(30 == calculateSumOfSquaresAnother(4))
    require(385 == calculateSumOfSquaresAnother(10))
    require(0 == calculateSumOfSquaresAnother(0))
    require(0 == calculateSumOfSquaresAnother(-1))
    require(0 == calculateSumOfSquaresAnother(-1))
    require(0 == calculateSumOfSquaresAnother(-3))

    // Example for calculateSumOfEven
    require(0 == calculateSumOfEven(0))
    require(0 == calculateSumOfEven(1))
    require(2 == calculateSumOfEven(2))
    require(2 == calculateSumOfEven(3))
    require(6 == calculateSumOfEven(5))
    require(30 == calculateSumOfEven(10))
    require(42 == calculateSumOfEven(12))
    require(110 == calculateSumOfEven(20))
    require(240 == calculateSumOfEven(30))
    require(0 == calculateSumOfEven(-1))

    // Example for countDownByStep
    require("1" == countDownByStep(1, 1, 1))
    require("5, 3, 1" == countDownByStep(5, 1, 2))
    require("10, 7, 4, 1" == countDownByStep(10, 1, 3))
    require("15, 10, 5" == countDownByStep(15, 5, 5))
    require("20, 17, 14, 11, 8, 5, 2" == countDownByStep(20, 2, 3))
    require("10, 7, 4" == countDownByStep(10, 4, 3))
    require("-1" == countDownByStep(-1, -1, 1))
    require("-5, -7, -9" == countDownByStep(-5, -9, 2))
    require("0" == countDownByStep(0, 0, 1))
    require("0" == countDownByStep(0, 0, 2))
}

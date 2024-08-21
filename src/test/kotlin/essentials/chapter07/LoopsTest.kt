package essentials.chapter07

import essentials.chapter07.Loops.calculateSumOfEven
import essentials.chapter07.Loops.calculateSumOfSquares
import essentials.chapter07.Loops.calculateSumOfSquaresAnother
import essentials.chapter07.Loops.countDownByStep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LoopsTest {
    @Test
    fun testCalculateSumOfSquares() {
        assertEquals(1, calculateSumOfSquares(1))
        assertEquals(5, calculateSumOfSquares(2))
        assertEquals(14, calculateSumOfSquares(3))
        assertEquals(30, calculateSumOfSquares(4))
        assertEquals(385, calculateSumOfSquares(10))
        assertEquals(0, calculateSumOfSquares(0))
        assertEquals(0, calculateSumOfSquares(-1))
        assertEquals(0, calculateSumOfSquares(-2))
        assertEquals(0, calculateSumOfSquares(-3))
    }

    @Test
    fun testCalculateSumOfSquaresAnother() {
        assertEquals(1, calculateSumOfSquaresAnother(1))
        assertEquals(5, calculateSumOfSquaresAnother(2))
        assertEquals(14, calculateSumOfSquaresAnother(3))
        assertEquals(30, calculateSumOfSquaresAnother(4))
        assertEquals(385, calculateSumOfSquaresAnother(10))
        assertEquals(0, calculateSumOfSquaresAnother(0))
        assertEquals(0, calculateSumOfSquaresAnother(-1))
        assertEquals(0, calculateSumOfSquaresAnother(-2))
        assertEquals(0, calculateSumOfSquaresAnother(-3))
    }

    @Test
    fun testCalculateSumOfEven() {
        assertEquals(0, calculateSumOfEven(0))
        assertEquals(0, calculateSumOfEven(1))
        assertEquals(2, calculateSumOfEven(2))
        assertEquals(2, calculateSumOfEven(3))
        assertEquals(6, calculateSumOfEven(5))
        assertEquals(30, calculateSumOfEven(10))
        assertEquals(42, calculateSumOfEven(12))
        assertEquals(110, calculateSumOfEven(20))
        assertEquals(240, calculateSumOfEven(30))
        assertEquals(0, calculateSumOfEven(-1))
    }

    @Test
    fun testCountDownByStep() {
        assertEquals("1", countDownByStep(1, 1, 1))
        assertEquals("5, 3, 1", countDownByStep(5, 1, 2))
        assertEquals("10, 7, 4, 1", countDownByStep(10, 1, 3))
        assertEquals("15, 10, 5", countDownByStep(15, 5, 5))
        assertEquals("20, 17, 14, 11, 8, 5, 2", countDownByStep(20, 2, 3))
        assertEquals("10, 7, 4", countDownByStep(10, 4, 3))
        assertEquals("-1", countDownByStep(-1, -1, 1))
        assertEquals("-5, -7, -9", countDownByStep(-5, -9, 2))
        assertEquals("0", countDownByStep(0, 0, 1))
        assertEquals("0", countDownByStep(0, 0, 2))
    }
}

package essentials.chapter13

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.ByteArrayInputStream
import kotlin.test.assertEquals

class HandleExceptionsTest {
    private val sut = HandleExceptions()

    private fun <T> mockUserInput(
        vararg input: String,
        block: () -> T,
    ): T {
        val testIn = ByteArrayInputStream(input.joinToString("\n").toByteArray())
        System.setIn(testIn)

        return block.invoke()
    }

    private fun String.withPrintResult(): String {
        println("\nresult: `$this`")
        return this
    }

    @Test
    fun wrongNumberTest() {
        val result =
            mockUserInput("NaN", "/", "NaN") {
                assertDoesNotThrow {
                    sut.handleInputWithoutExceptions()
                }
            }.withPrintResult()

        assertThat(result).startsWith("Invalid input: ")
    }

    @Test
    fun divisionByZeroTest() {
        val result =
            mockUserInput("0", "/", "0") {
                assertDoesNotThrow {
                    sut.handleInputWithoutExceptions()
                }
            }.withPrintResult()

        assertEquals("Division by zero", result)
    }

    @Test
    fun illegalOperatorExceptionTest() {
        val result =
            mockUserInput("0", "//", "0") {
                assertDoesNotThrow {
                    sut.handleInputWithoutExceptions()
                }
            }.withPrintResult()

        assertThat(result).startsWith("Illegal operator: ")
    }

    @ParameterizedTest
    @CsvSource(
        "1,+,1,2",
        "1,-,2,-1",
        "2,*,3,6",
        "4,/,2,2",
        "4,/,3,1",
    )
    fun withoutAnyExceptionsTest(
        num1: String,
        operator: String,
        num2: String,
        expected: String,
    ) {
        val result =
            mockUserInput(num1, operator, num2) {
                assertDoesNotThrow {
                    sut.handleInputWithoutExceptions()
                }
            }.withPrintResult()

        assertEquals("Result: $expected", result)
    }
}

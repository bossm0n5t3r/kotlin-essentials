package essentials.chapter13

class HandleExceptions {
    fun handleInputWithoutExceptions() =
        try {
            handleInput()
        } catch (e: NumberFormatException) {
            "Invalid input: ${e.message}"
        } catch (e: ArithmeticException) {
            "Division by zero"
        } catch (e: IllegalOperatorException) {
            "Illegal operator: ${e.message}"
        }

    private fun handleInput(): String {
        print("Enter the first number: ")
        val num1 = readln().toInt()
        print("Enter an operator (+, -, *, /): ")
        val operator = readln()
        print("Enter the second number: ")
        val num2 = readln().toInt()

        val result =
            when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> throw IllegalOperatorException(operator)
            }

        return "Result: $result"
    }

    class IllegalOperatorException(
        operator: String,
    ) : Exception("Unknown operator: $operator")
}

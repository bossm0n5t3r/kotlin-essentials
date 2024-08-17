package essentials.chapter06

fun main() {
    fun formatPersonDisplay(
        name: String? = null,
        surname: String? = null,
        age: Int? = null,
    ): String {
        val sb = StringBuilder()
        if (name != null) {
            sb.append("$name ")
        }
        if (surname != null) {
            sb.append("$surname ")
        }
        if (age != null) {
            sb.append("($age)")
        }
        return sb.toString().trim()
    }

    require(formatPersonDisplay("John", "Smith", 42) == "John Smith (42)")
    require(formatPersonDisplay("Alex", "Simonson") == "Alex Simonson")
    require(formatPersonDisplay("Peter", age = 25) == "Peter (25)")
    require(formatPersonDisplay(surname = "Johnson", age = 18) == "Johnson (18)")
    require(formatPersonDisplay(age = 18) == "(18)")
    require(formatPersonDisplay() == "")
}

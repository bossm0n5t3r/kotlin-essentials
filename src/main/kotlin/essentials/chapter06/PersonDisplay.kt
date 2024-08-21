package essentials.chapter06

object PersonDisplay {
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
}

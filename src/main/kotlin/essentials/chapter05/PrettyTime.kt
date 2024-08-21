package essentials.chapter05

object PrettyTime {
    fun secondsToPrettyTime(seconds: Int): String {
        if (seconds < 0) return "Invalid input"
        return listOf(seconds / (60 * 60), (seconds % (60 * 60)) / 60, seconds % 60)
            .zip(listOf("h", "min", "sec"))
            .filter { it.first != 0 }
            .joinToString(" ") { "${it.first} ${it.second}" }
    }
}

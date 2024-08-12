package essentials.chapter05

fun main() {
    fun secondsToPrettyTime(seconds: Int): String {
        if (seconds < 0) return "Invalid input"
        return listOf(seconds / (60 * 60), (seconds % (60 * 60)) / 60, seconds % 60)
            .zip(listOf("h", "min", "sec"))
            .filter { it.first != 0 }
            .joinToString(" ") { "${it.first} ${it.second}" }
    }

    require(secondsToPrettyTime(-1).also(::println) == "Invalid input")
    require(secondsToPrettyTime(0).also(::println) == "")
    require(secondsToPrettyTime(45).also(::println) == "45 sec")
    require(secondsToPrettyTime(60).also(::println) == "1 min")
    require(secondsToPrettyTime(150).also(::println) == "2 min 30 sec")
    require(secondsToPrettyTime(1410).also(::println) == "23 min 30 sec")
    require(secondsToPrettyTime(60 * 60).also(::println) == "1 h")
    require(secondsToPrettyTime(3665).also(::println) == "1 h 1 min 5 sec")
}

package essentials.chapter05

fun main() {
    val magicNumbers = listOf(7, 13)

    fun name(a: Any?): String =
        when (a) {
            null -> "Nothing"
            1, 2, 3 -> "Small number"
            in magicNumbers -> "Magic number"
            in 4..100 -> "Big number"
            is String -> "String: $a"
            is Int, is Long -> "Int or Long: $a"
            else -> "No idea, really"
        }

    require(name(1) == "Small number")
    require(name("A") == "String: A")
    require(name(null) == "Nothing")
    require(name(5) == "Big number")
    require(name(100) == "Big number")
    require(name('A') == "No idea, really")
    require(name("1") == "String: 1")
    require(name(-1) == "Int or Long: -1")
    require(name(101) == "Int or Long: 101")
    require(name(1L) == "Int or Long: 1")
    require(name(-1) == "Int or Long: -1")
    require(name(7) == "Magic number")
    require(name(3) == "Small number")
    require(name(3.0) == "No idea, really")
    require(name(100L) == "Int or Long: 100")
}

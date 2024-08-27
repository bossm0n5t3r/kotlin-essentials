package essentials.chapter17

data class Rational(
    val numerator: Int,
    val denominator: Int,
)

fun Int.r(): Rational = Rational(this, 1)

fun Pair<Int, Int>.r(): Rational = Rational(this.first, this.second)

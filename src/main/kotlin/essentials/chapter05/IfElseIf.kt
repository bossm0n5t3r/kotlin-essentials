package essentials.chapter05

private fun Any?.print() = print(this)

private fun printNumberSign(num: Int) {
    if (num < 0) {
        "negative" // The expression is unused
    } else if (num > 0) {
        "positive"
    } else {
        "zero"
    }.print()
}

fun main() {
    printNumberSign(-2)
    print(",")
    printNumberSign(0)
    print(",")
    printNumberSign(2) // ,zero,positive
}

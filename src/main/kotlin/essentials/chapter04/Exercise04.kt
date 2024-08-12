package essentials.chapter04

fun main() {
    require(1 + 2 * 3 == 7)
    require(10 % 3 == 1)
    require(-1 % 3 == -1)

    require(8.8 / 4 == 2.2)
    require(10 / 3 == 3)

    require(11.toFloat() == 11.0f)
    require(10.10.toInt() == 10)

    var a = 10
    a += 5
    require(a == 15)
    a -= 3
    require(a == 12)
    a++
    require(a == 13)
    require(a++ == 13)
    require(a == 14)
    require(--a == 13)
    require(a == 13)

    require(true && false == false)
    require(true || false == true)
    require(!!!!true == true)

    require('A'.code == 65)
    require('A' + 1 == 'B')
    require('C'.code == 67)

    require("A + B" == "A + B")
    require("A" + "B" == "AB")
    require("A" + 1 == "A1")
    require("A" + 1 + 2 == "A12")
}

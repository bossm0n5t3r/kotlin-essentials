package essentials.chapter11

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun test() {
        val john = Person("John", 30)

        println(john)

        val janeFromCopy = john.copy(name = "Jane")
        val janeNew = Person("Jane", 30)

        assertEquals(janeFromCopy, janeNew)

        println(john.hashCode())
        println(janeFromCopy.hashCode())
        println(janeNew.hashCode())

        val (janeName, janeAge) = janeNew
        println(janeName)
        println(janeAge)
    }
}

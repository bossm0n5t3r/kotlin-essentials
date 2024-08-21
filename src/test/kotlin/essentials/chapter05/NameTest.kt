package essentials.chapter05

import essentials.chapter05.Name.name
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NameTest {
    @Test
    fun nameTest() {
        assertEquals(name(1), "Small number")
        assertEquals(name("A"), "String: A")
        assertEquals(name(null), "Nothing")
        assertEquals(name(5), "Big number")
        assertEquals(name(100), "Big number")
        assertEquals(name('A'), "No idea, really")
        assertEquals(name("1"), "String: 1")
        assertEquals(name(-1), "Int or Long: -1")
        assertEquals(name(101), "Int or Long: 101")
        assertEquals(name(1L), "Int or Long: 1")
        assertEquals(name(-1), "Int or Long: -1")
        assertEquals(name(7), "Magic number")
        assertEquals(name(3), "Small number")
        assertEquals(name(3.0), "No idea, really")
        assertEquals(name(100L), "Int or Long: 100")
    }
}

package essentials.chapter10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun businessmanImplementsPerson() {
        assertTrue(Businessman("AAA", 30) is Person, "Businessman needs to be a person")
    }

    @Test
    fun studentImplementsPerson() {
        assertTrue(Student("AAA", 30) is Person, "Student needs to be a person")
    }

    @Test
    fun personCanBuyAlcoholIfOver21() {
        assertTrue(Businessman("AAA", 30).canBuyAlcohol, "Adult businessman can buy alcohol")
        assertTrue(Businessman("AAA", 21).canBuyAlcohol, "Adult businessman can buy alcohol")
        assertTrue(!Businessman("AAA", 19).canBuyAlcohol, "Young businessman can' buy alcohol")
        assertTrue(!Businessman("AAA", 17).canBuyAlcohol, "Young businessman can' buy alcohol")
        assertTrue(Student("AAA", 30).canBuyAlcohol, "Adult student can buy alcohol")
        assertTrue(Student("AAA", 21).canBuyAlcohol, "Adult student can buy alcohol")
        assertTrue(!Student("AAA", 19).canBuyAlcohol, "Young student can' buy alcohol")
        assertTrue(!Student("AAA", 17).canBuyAlcohol, "Young student can' buy alcohol")
    }

    @Test
    fun testBusinessmanHelloText() {
        assertEquals("Good morning", Businessman("AAA", 30).helloText())
    }

    @Test
    fun testStudentHelloText() {
        assertEquals("Hi", Student("AAA", 30).helloText())
    }

    @Test
    fun testStudentGreetText() {
        val name1 = "Some name"
        val name2 = "Another name"
        val student = Student(name1, 12)
        val businessman = Businessman(name2, 12)
        assertEquals("Hey $name2, I am $name1", Student(name1, 30).cheerText(businessman))
        assertEquals("Hey $name1, I am $name2", Student(name2, 30).cheerText(student))
    }

    @Test
    fun testBusinessmanGreetText() {
        val name1 = "Some name"
        val name2 = "Another name"
        val student = Student(name1, 12)
        val businessman = Businessman(name2, 12)
        assertEquals("Hello, my name is $name1, nice to see you $name2", Businessman(name1, 30).cheerText(businessman))
        assertEquals("Hello, my name is $name2, nice to see you $name1", Businessman(name2, 30).cheerText(student))
    }
}

package essentials.chapter10

interface Person {
    val name: String
    val age: Int
    val canBuyAlcohol: Boolean

    fun helloText(): String

    fun cheerText(person: Person): String
}

data class Businessman(
    override val name: String,
    override val age: Int,
) : Person {
    override val canBuyAlcohol = age > 20

    override fun helloText(): String = "Good morning"

    override fun cheerText(person: Person): String = "Hello, my name is ${this.name}, nice to see you ${person.name}"
}

data class Student(
    override val name: String,
    override val age: Int,
) : Person {
    override val canBuyAlcohol = age > 20

    override fun helloText(): String = "Hi"

    override fun cheerText(person: Person): String = "Hey ${person.name}, I am ${this.name}"
}

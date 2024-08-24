package essentials.chapter12

class Pizza(
    val toppings: List<String>,
) {
    companion object {
        fun hawaiian() = Pizza(listOf("ham", "pineapple"))

        fun margherita() = Pizza(listOf("tomato", "mozzarella"))
    }
}

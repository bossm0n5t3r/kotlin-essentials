package essentials.chapter21

class Stack<T> {
    private val items: MutableList<T> = mutableListOf()

    fun push(item: T) {
        items.add(item)
    }

    fun pop() = if (items.isNotEmpty()) items.removeAt(items.lastIndex) else null

    fun peek() = items.lastOrNull()

    fun isEmpty() = items.isEmpty()

    fun size() = items.size
}

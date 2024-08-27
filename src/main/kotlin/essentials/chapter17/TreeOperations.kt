package essentials.chapter17

object TreeOperations {
    sealed class Tree<T> {
        override fun toString(): String =
            when (this) {
                is Leaf -> value.toString()
                is Node -> "($left, $right)"
            }

        operator fun plus(other: Tree<T>): Tree<T> = Node(this, other)
    }

    data class Leaf<T>(
        val value: T,
    ) : Tree<T>()

    data class Node<T>(
        val left: Tree<T>,
        val right: Tree<T>,
    ) : Tree<T>()

    fun <T> Tree<T>.count(): Int =
        when (this) {
            is Leaf -> 1
            is Node -> this.left.count() + this.right.count()
        }

    fun <T> Tree<T>.countAll(): Int =
        when (this) {
            is Leaf -> 1
            is Node -> 1 + this.left.countAll() + this.right.countAll()
        }

    fun <T> Tree<T>.height(): Int =
        when (this) {
            is Leaf -> 1
            is Node -> 1 + this.left.height()
        }

    fun <T : Comparable<T>> Tree<T>.biggest(): T =
        when (this) {
            is Leaf -> this.value
            is Node -> maxOf(this.left.biggest(), this.right.biggest())
        }

    fun Tree<Int>.sum(): Int =
        when (this) {
            is Leaf -> this.value
            is Node -> this.left.sum() + this.right.sum()
        }

    operator fun <T> Tree<T>.contains(value: String): Boolean =
        when (this) {
            is Leaf -> this.value == value
            is Node -> this.left.contains(value) || this.right.contains(value)
        }
}

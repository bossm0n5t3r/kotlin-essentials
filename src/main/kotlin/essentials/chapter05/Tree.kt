package essentials.chapter05

abstract class Tree {
    override fun toString(): String = treeToString(this, StringBuilder()).toString()
}

class Leaf(
    val value: String,
) : Tree()

class Node(
    val left: Tree,
    val right: Tree,
) : Tree()

private fun treeToString(
    tree: Tree,
    sb: StringBuilder,
): StringBuilder =
    when (tree) {
        is Leaf -> {
            sb.append(tree.value)
        }
        is Node -> {
            treeToString(tree.left, sb)
            sb.append(", ")
            treeToString(tree.right, sb)
        }
        else -> sb
    }

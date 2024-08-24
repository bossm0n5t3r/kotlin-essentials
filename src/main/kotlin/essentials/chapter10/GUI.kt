package essentials.chapter10

object GUI {
    open class View(
        val id: String,
        var isVisible: Boolean,
    ) {
        fun show() {
            isVisible = true
        }

        fun hide() {
            isVisible = false
        }
    }

    class TextView(
        id: String,
        var text: String,
    ) : View(id, true)

    class Toggle(
        id: String,
    ) : View(id, true) {
        var isOn: Boolean = false

        fun click() {
            isOn = !isOn
        }
    }
}

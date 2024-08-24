package essentials.chapter10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GUITest {
    @Test
    fun `view show should set isVisible to true`() {
        val view = GUI.View("view1", false)
        view.show()
        assertTrue(view.isVisible)
    }

    @Test
    fun `view hide should set isVisible to false`() {
        val view = GUI.View("view2", true)
        view.hide()
        assertFalse(view.isVisible)
    }

    @Test
    fun `toggle click should toggle isOn state`() {
        val toggle = GUI.Toggle("toggle1")
        toggle.click()
        assertTrue(toggle.isOn)
        toggle.click()
        assertFalse(toggle.isOn)
    }

    @Test
    fun `text view setText should update text property`() {
        val textView = GUI.TextView("textView1", "Hello")
        textView.text = "World"
        assertEquals("World", textView.text)
    }

    @Test
    fun `toggle should inherit properties from view`() {
        val toggle = GUI.Toggle("toggle2")
        assertTrue(toggle.isVisible)
        toggle.hide()
        assertFalse(toggle.isVisible)
    }

    @Test
    fun `text view should inherit properties from view`() {
        val textView = GUI.TextView("textView2", "Hello")
        assertTrue(textView.isVisible)
    }

    @Test
    fun `toggle should start with isOn set to false`() {
        val toggle = GUI.Toggle("toggle3")
        assertFalse(toggle.isOn)
    }

    @Test
    fun `toggle should toggle isOn state correctly`() {
        val toggle = GUI.Toggle("toggle4")
        toggle.click()
        assertTrue(toggle.isOn)
        toggle.click()
        assertFalse(toggle.isOn)
        toggle.click()
        assertTrue(toggle.isOn)
    }

    @Test
    fun `view show and hide interactions`() {
        val view = GUI.View("view3", false)
        view.show()
        assertTrue(view.isVisible)
        view.hide()
        assertFalse(view.isVisible)
    }

    @Test
    fun `text view setText and visibility interactions`() {
        val textView = GUI.TextView("textView3", "Hello")
        textView.text = "World"
        assertEquals("World", textView.text)
        textView.hide()
        assertFalse(textView.isVisible)
    }
}

package essentials.chapter17

import essentials.chapter17.DataConversion.Email
import essentials.chapter17.DataConversion.User
import essentials.chapter17.DataConversion.UserJson
import essentials.chapter17.DataConversion.cm
import essentials.chapter17.DataConversion.toUser
import essentials.chapter17.DataConversion.toUserJson
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DataConversionTest {
    @Test
    fun `test User to UserJson conversion`() {
        val user =
            User(
                username = "alex",
                email = Email("alex@example.com"),
                registrationDate = LocalDateTime.now(),
                height = 170.cm,
            )

        val userJson = user.toUserJson()

        assertEquals("alex", userJson.username)
        assertEquals("alex@example.com", userJson.email)
        assertEquals(user.registrationDate.toString(), userJson.registrationDate)
        assertEquals(user.height.value, userJson.heightCm)
    }

    @Test
    fun `test UserJson to User conversion`() {
        val userJson =
            UserJson(
                username = "alex",
                email = "alex@example.com",
                registrationDate = LocalDateTime.now().toString(),
                heightCm = 170,
            )

        val user = userJson.toUser()

        assertEquals("alex", user.username)
        assertEquals("alex@example.com", user.email.value)
        assertEquals(userJson.registrationDate, user.registrationDate.toString())
        assertEquals(userJson.heightCm.cm, user.height)
    }

    @Test
    fun `test cm extension property`() {
        val value = 150
        val cm = value.cm

        assertEquals(value, cm.value)
    }
}

package essentials.chapter08

import essentials.chapter08.UserInformation.processUserInformation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserInformationTest {
    @Test
    fun `null user information`() {
        val result = processUserInformation(null)
        val expected = "Missing user information"
        assertEquals(expected, result)
    }

    @Test
    fun `valid user information`() {
        val user = UserInformation.User("John Doe", 30, UserInformation.EmailAddress("john@example.com"))
        val result = processUserInformation(user)
        val expected = "User John Doe is 30 years old, email: john@example.com"
        assertEquals(expected, result)
    }

    @Test
    fun `user with missing age should have age 0`() {
        val user = UserInformation.User("Alice", null, UserInformation.EmailAddress("alice@example.com"))
        val result = processUserInformation(user)
        val expected = "User Alice is 0 years old, email: alice@example.com"
        assertEquals(expected, result)
    }

    @Test
    fun `user with blank email`() {
        val user = UserInformation.User("Bob", 25, UserInformation.EmailAddress(""))
        val result = processUserInformation(user)
        val expected = "Missing email"
        assertEquals(expected, result)
    }

    @Test
    fun `user with null email address`() {
        val user = UserInformation.User("Bob", 25, UserInformation.EmailAddress(null))
        val result = processUserInformation(user)
        val expected = "Missing email"
        assertEquals(expected, result)
    }

    @Test
    fun `user with null email information`() {
        val user = UserInformation.User("Bob", 25, null)
        val result = processUserInformation(user)
        val expected = "Missing email"
        assertEquals(expected, result)
    }

    @Test
    fun `user with missing name should throw exception`() {
        val user = UserInformation.User(null, 40, UserInformation.EmailAddress("email@example.com"))
        assertThrows<IllegalArgumentException> {
            processUserInformation(user)
        }
    }
}

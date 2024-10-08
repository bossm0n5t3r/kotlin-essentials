package essentials.chapter08

import essentials.chapter08.SendMessage.sendMessageToClient
import kotlin.test.Test
import kotlin.test.assertEquals

class NullabilityTests {
    class MailCollector : SendMessage.Mailer {
        data class Mail(
            val email: String,
            val message: String,
        )

        var emails = listOf<Mail>()

        override fun sendMessage(
            email: String,
            message: String,
        ) {
            emails += Mail(email, message)
        }
    }

    @Test
    fun `When client is null, email we do not send email`() {
        val mailer = MailCollector()
        sendMessageToClient(null, "AAA", mailer)
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When message is null, we do not send email`() {
        val mailer = MailCollector()
        sendMessageToClient(SendMessage.Client(SendMessage.PersonalInfo("AAA")), null, mailer)
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When personal info is null, we do not send email`() {
        val mailer = MailCollector()
        sendMessageToClient(SendMessage.Client(null), "AAA", mailer)
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When email address is null, we do not send email`() {
        val mailer = MailCollector()
        sendMessageToClient(SendMessage.Client(SendMessage.PersonalInfo(null)), null, mailer)
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `Sends messages correctly for correct values`() {
        val mailer = MailCollector()
        sendMessageToClient(SendMessage.Client(SendMessage.PersonalInfo("AAA")), "BBB", mailer)
        assertEquals(listOf(MailCollector.Mail("AAA", "BBB")), mailer.emails)
    }
}

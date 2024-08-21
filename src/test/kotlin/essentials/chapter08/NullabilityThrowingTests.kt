package essentials.chapter08

import essentials.chapter08.SendMessage.sendMessageToClientOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals

class NullabilityThrowingTests {
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
    fun `When client is null, email is not sent`() {
        val mailer = MailCollector()
        val res = runCatching { sendMessageToClientOrThrow(null, "AAA", mailer) }
        val exception = res.exceptionOrNull()
        assert(exception != null) { "Exception not thrown" }
        assert(exception is IllegalArgumentException) { "Exception is $exception, and it should be of type IllegalArgumentException" }
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When message is null, email is not sent`() {
        val mailer = MailCollector()
        val res = runCatching { sendMessageToClientOrThrow(SendMessage.Client(SendMessage.PersonalInfo("AAA")), null, mailer) }
        val exception = res.exceptionOrNull()
        assert(exception != null) { "Exception not thrown" }
        assert(exception is IllegalArgumentException) { "Exception is $exception, and it should be of type IllegalArgumentException" }
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When personal info is null, email is not sent`() {
        val mailer = MailCollector()
        val res = runCatching { sendMessageToClientOrThrow(SendMessage.Client(null), "AAA", mailer) }
        val exception = res.exceptionOrNull()
        assert(exception != null) { "Exception not thrown" }
        assert(exception is IllegalArgumentException) { "Exception is $exception, and it should be of type IllegalArgumentException" }
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `When email is null, email is not sent`() {
        val mailer = MailCollector()
        val res = runCatching { sendMessageToClientOrThrow(SendMessage.Client(SendMessage.PersonalInfo(null)), null, mailer) }
        val exception = res.exceptionOrNull()
        assert(exception != null) { "Exception not thrown" }
        assert(exception is IllegalArgumentException) { "Exception is $exception, and it should be of type IllegalArgumentException" }
        assertEquals(emptyList(), mailer.emails)
    }

    @Test
    fun `Sends messages correctly`() {
        val mailer = MailCollector()
        sendMessageToClientOrThrow(SendMessage.Client(SendMessage.PersonalInfo("AAA")), "BBB", mailer)
        assertEquals(listOf(MailCollector.Mail("AAA", "BBB")), mailer.emails)
    }
}

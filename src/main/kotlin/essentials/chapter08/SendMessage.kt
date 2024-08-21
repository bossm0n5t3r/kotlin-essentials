package essentials.chapter08

object SendMessage {
    class PersonalInfo(
        val email: String?,
    )

    class Client(
        val personalInfo: PersonalInfo?,
    )

    interface Mailer {
        fun sendMessage(
            email: String,
            message: String,
        )
    }

    // Sends a message if message and client's personal info email are not null
    fun sendMessageToClient(
        client: Client?,
        message: String?,
        mailer: Mailer,
    ) {
        val email = client?.personalInfo?.email
        if (email != null && message != null) {
            mailer.sendMessage(email, message)
        }
    }

    // Sends a message if message and client's personal info email are not null or throw
    fun sendMessageToClientOrThrow(
        client: Client?,
        message: String?,
        mailer: Mailer,
    ) {
        val email = client?.personalInfo?.email
        requireNotNull(message)
        requireNotNull(email)
        mailer.sendMessage(email, message)
    }
}

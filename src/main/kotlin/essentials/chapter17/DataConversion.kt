package essentials.chapter17

import java.time.LocalDateTime

object DataConversion {
    data class User(
        val username: String,
        val email: Email,
        val registrationDate: LocalDateTime,
        val height: Centimeters,
    )

    data class Email(
        val value: String,
    )

    data class Centimeters(
        val value: Int,
    )

    data class UserJson(
        val username: String,
        val email: String,
        val registrationDate: String,
        val heightCm: Int,
    )

// TODO: Implement extensions to convert User to UserJson and vice versa,
    fun User.toUserJson(): UserJson =
        UserJson(
            this.username,
            this.email.value,
            this.registrationDate.toString(),
            this.height.value,
        )

    fun UserJson.toUser(): User =
        User(
            this.username,
            Email(this.email),
            LocalDateTime.parse(this.registrationDate),
            this.heightCm.cm,
        )

    val Int.cm: Centimeters
        get() = Centimeters(this)
}

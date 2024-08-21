package essentials.chapter08

object UserInformation {
    fun processUserInformation(user: User?): String {
        if (user == null) {
            return "Missing user information"
        }
        val name = requireNotNull(user.name)
        val age = user.age ?: 0
        val email = user.email?.email?.takeIf { it.isNotBlank() } ?: return "Missing email"
        return "User $name is $age years old, email: $email"
    }

    data class EmailAddress(
        val email: String?,
    )

    data class User(
        val name: String?,
        val age: Int?,
        val email: EmailAddress?,
    )
}

package essentials.chapter14

enum class DayOfWeek(
    val dayName: String,
    val isWeekend: Boolean,
) {
    SUNDAY("Sunday", true),
    MONDAY("Monday", false),
    TUESDAY("Tuesday", false),
    WEDNESDAY("Wednesday", false),
    THURSDAY("Thursday", false),
    FRIDAY("Friday", false),
    SATURDAY("Saturday", true),
    ;

    fun nextDay(): DayOfWeek {
        val totalSize = DayOfWeek.entries.size
        return DayOfWeek.entries[(ordinal + 1) % totalSize]
    }
}

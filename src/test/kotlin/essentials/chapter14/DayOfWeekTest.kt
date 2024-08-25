package essentials.chapter14

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DayOfWeekTest {
    @Test
    fun test() {
        val friday: DayOfWeek = DayOfWeek.FRIDAY
        assertEquals("Friday", friday.dayName)
        assertEquals(false, friday.isWeekend)

        val saturday: DayOfWeek = friday.nextDay()
        assertEquals("Saturday", saturday.dayName)
        assertEquals(true, saturday.isWeekend)
    }
}

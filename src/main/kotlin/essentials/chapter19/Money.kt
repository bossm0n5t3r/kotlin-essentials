package essentials.chapter19

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
    val currency: Currency,
) {
    operator fun plus(other: Money): Money {
        require(this.currency == other.currency)

        return Money(this.amount + other.amount, this.currency)
    }

    operator fun minus(other: Money): Money {
        require(this.currency == other.currency)

        return Money(this.amount - other.amount, this.currency)
    }

    operator fun unaryMinus(): Money = this.copy(amount = -amount)

    operator fun times(other: Int): Money = Money(this.amount * other.toBigDecimal(), this.currency)

    companion object {
        fun eur(amount: String) = Money(BigDecimal(amount), Currency.EUR)
    }
}

enum class Currency {
    EUR,
    USD,
    GBP,
}

import java.math.BigDecimal

fun BigDecimal?.isSafetyBigger(other: BigDecimal): Boolean {
    return this != null && this > other
}

fun BigDecimal?.isNullOrZero(): Boolean {
    return this == null || this == BigDecimal.ZERO
}

fun BigDecimal?.isNotNullOrNotZero(): Boolean {
    return !this.isNullOrZero()
}

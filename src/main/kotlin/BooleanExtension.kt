import java.util.function.Supplier

/**
 * throw given Exception when the value is false
 */
infix fun <X : Throwable> Boolean.isFalseThrow(exceptionSupplier: Supplier<out X>) {
    if (!this) {
        exceptionSupplier.get()
    }
}

/**
 * executed supplier when given value is true
 */
infix fun <X> Boolean.isTrue(supplier: Supplier<out X>) {
    if (this) {
        supplier.get()
    }
}

/**
 * executed supplier when given value is false
 */
infix fun <X> Boolean.isFalse(supplier: Supplier<out X>) {
    if (!this) {
        supplier.get()
    }
}

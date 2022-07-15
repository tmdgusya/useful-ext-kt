/**
 * I think `!in` is not useful (it's just my opinion)
 * So i created notContains method
 */
infix fun <T> Collection<T>.notContains(ele: T): Boolean {
    return !this.contains(ele)
}
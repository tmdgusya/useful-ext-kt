/**
 * @return The return value is a Boolean value that determines whether it is null or not.
 */
fun Any?.isNull(): Boolean {
    return this == null
}

/**
 * @return The return value is a Boolean value that determines whether it is not null or not.
 */
fun Any?.isNotNull(): Boolean {
    return this != null
}
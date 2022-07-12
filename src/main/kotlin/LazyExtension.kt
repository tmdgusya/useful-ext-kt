fun <T> Lazy<T>.throwOrElseNull(): T? {
    return try {
        this.value
    } catch (e: Exception) {
        null
    }
}

import kotlinx.coroutines.Deferred

suspend fun <T : Any> Deferred<T>.interceptException(
    handler: (e: Exception) -> Unit
): T? {
    return try {
        this.await()
    } catch (e: Exception) {
        handler(e)
        null
    }
}

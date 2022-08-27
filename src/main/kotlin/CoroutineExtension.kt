import kotlinx.coroutines.Deferred
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Destructuring Result Of Deferred
 * It doesn't need explicit Type cast
 * Example
 * val (resul1, result2, resul3) = tripleAwaitAll(async {1}, async {"User"}, async {User()})
 */
suspend fun <A, B, C> tripleAwaitAll(
    defer1: Deferred<A>,
    defer2: Deferred<B>,
    defer3: Deferred<C>,
    dispatcher: CoroutineContext
): Triple<A, B, C> = withContext(dispatcher) {
    return@withContext Triple(
        defer1.await(),
        defer2.await(),
        defer3.await()
    )
}

/**
 * Destructuring Result Of Deferred
 * It doesn't need explicit Type cast
 * Example
 * val (resul1, result2) = tripleAwaitAll(async {1}, async {"User"}})
 */
suspend fun <A, B> pairAwaitAll(
    defer1: Deferred<A>,
    defer2: Deferred<B>,
    dispatcher: CoroutineContext
): Pair<A, B> = withContext(dispatcher) {
    return@withContext Pair(
        defer1.await(),
        defer2.await(),
    )
}

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * I think `!in` is not useful (it's just my opinion)
 * So i created notContains method
 */
infix fun <T> Collection<T>.notContains(ele: T): Boolean {
    return !this.contains(ele)
}

/**
 * @chunkSize Splits this collection into a list of lists each not exceeding the given size.
 * @coroutineContext Inject Coroutine Context which you want use it
 * @supplier Inject Supplier that is want to execute work
 *
 */
fun <I, O> Collection<I>.parallelExecuteWithChunk(
    chunkSize: Int,
    coroutineContext: CoroutineContext,
    supplier: (Collection<I>) -> O,
    coroutineStartMethod: CoroutineStart = CoroutineStart.LAZY
) = runBlocking {
    return@runBlocking this@parallelExecuteWithChunk.chunked(chunkSize).map { chunkedIds ->
        async(start = coroutineStartMethod) {
            withContext(context = coroutineContext) {
                supplier.invoke(chunkedIds)
            }
        }
    }.awaitAll()
}

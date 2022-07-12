import io.kotest.core.spec.style.FunSpec
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class DeferredExtensionKtTest : FunSpec() {
    init {
        test("exception progation").config(testCoroutineDispatcher = true) {
            val job = async {
                throwExceptionFunc()
            }

            assertThrows<Exception> { runBlocking { job.await() } }
        }

        test("handle exception when throw exception suspend fun").config(testCoroutineDispatcher = true) {
            val job = async {
                throwExceptionFunc()
            }

            assertDoesNotThrow { runBlocking { job.interceptException { e -> println(e) } } }
        }
    }
}

private fun throwExceptionFunc(): String {
    throw Exception("test")
    return "test"
}

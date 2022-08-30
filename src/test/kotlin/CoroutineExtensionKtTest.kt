import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import org.junit.jupiter.api.assertAll

class CoroutineExtensionKtTest : FunSpec({

    test("executed tripleAwaitAll") {
        val (
            intValue,
            StringValue,
            User
        ) = tripleAwaitAll(
            defer1 = async { 1 },
            defer2 = async { "Hello" },
            defer3 = async { User(name = "roach") },
            dispatcher = Dispatchers.Default
        )

        assertAll(
            { intValue shouldBe 1 },
            { StringValue shouldBe "Hello" },
            { User shouldBe User(name = "roach") }
        )
    }

    test("executed pairAwaitAll") {
        val (
            intValue,
            StringValue,
        ) = pairAwaitAll(
            defer1 = async { 1 },
            defer2 = async { "Hello" },
            dispatcher = Dispatchers.Default
        )

        assertAll(
            { intValue shouldBe 1 },
            { StringValue shouldBe "Hello" },
        )
    }

})

private data class User(
    val name: String
)

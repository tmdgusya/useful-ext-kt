import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LazyExtensionKtTest : FunSpec({
    test("return null if throw exception from executed function") {
        val lazyFunc = lazy { throwFunction() }

        lazyFunc.throwOrElseNull() shouldBe null
    }

    test("return value if succeed executed function") {
        val lazyFunc = lazy { succeedFunction() }

        lazyFunc.throwOrElseNull() shouldBe "test"
    }
})

private fun throwFunction(): String {
    throw RuntimeException("test")
    return "test"
}

private fun succeedFunction(): String {
    return "test"
}

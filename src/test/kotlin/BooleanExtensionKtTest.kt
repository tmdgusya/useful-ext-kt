import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class BooleanExtensionKtTest : BehaviorSpec({

    given("throw RuntimeException when given false value") {
        val falseValue = false

        `when`("executed func with isFalseThow") {
            val exception =
                assertThrows<RuntimeException> { falseValue isFalseThrow { throw RuntimeException("TEST") } }
            then("assert Throw exception") {
                exception.message shouldBe "TEST"
            }
        }
    }

    given("given the true value") {
        val trueValue = true
        var exectued = 0
        val someFunc = { exectued = 1 }

        `when`("executed someFunc with isTrue") {
            trueValue isTrue  { someFunc() }
            then("assert executed someFunc") {
                exectued shouldBe 1
            }
        }
    }

    given("given the false value") {
        val falseValue = false
        var exectued = 0
        val someFunc = { exectued = 1 }

        `when`("executed someFunc with isTrue") {
            falseValue isTrue  { someFunc() }
            then("assert not executed someFunc") {
                exectued shouldBe 0
            }
        }
    }

    given("given false value") {
        val falseValue = false
        var exectued = 0
        val someFunc = { exectued = 1 }

        `when`("executed someFunc with isFalse") {
            falseValue isFalse   { someFunc() }
            then("assert executed someFunc") {
                exectued shouldBe 1
            }
        }
    }

    given("given true value") {
        val trueValue = true
        var exectued = 0
        val someFunc = { exectued = 1 }

        `when`("executed someFunc with isFalse") {
            trueValue isFalse   { someFunc() }
            then("assert not executed someFunc") {
                exectued shouldBe 0
            }
        }
    }
})

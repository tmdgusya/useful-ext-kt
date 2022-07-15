import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CollectionExtensionKtTest : BehaviorSpec({

    given("give list of not contains number of 2") {
        val list = listOf<Int>(1, 3, 5)
        `when`("check list not contains 2") {
            val result = list.notContains(2)

            then("result is true (list not contains 2)") {
                result shouldBe true
            }
        }
    }

    given("give list of contains number of 2") {
        val list = listOf<Int>(1, 2, 3, 5)
        `when`("check list not contains 2") {
            val result = list.notContains(2)

            then("result is false (list contains 2)") {
                result shouldBe false
            }
        }
    }

})

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class AnyExtensionKtTest : WordSpec({

    "The Object is Null?" When {
        "If Given value is Null" should {
            val given = null
            "Return True when execute isNull Method" should {
                given.isNull() shouldBe true
            }
        }

        "If Given value is NotNull" should {
            val given = listOf(1,2)
            "Return False when execute isNull Method" should {
                given.isNull() shouldBe false
            }
        }

    }

    "The Object is Not Null?" When {
        "If Given value is Null" should {
            val given = null
            "Return False when execute isNull Method" should {
                given.isNotNull() shouldBe false
            }
        }

        "If Given value is NotNull" should {
            val given = listOf(1,2)
            "Return True when execute isNull Method" should {
                given.isNotNull() shouldBe true
            }
        }

    }

})

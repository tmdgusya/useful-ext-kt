import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class BigDecimalExtensionTest : FunSpec({

    test("return false if this is null") {
        val a: BigDecimal? = null

        val result = a.isSafetyBigger(BigDecimal.ZERO)

        result shouldBe false
    }

    test("return true if this is not null and bigger than other") {
        val a = BigDecimal.valueOf(10L)
        val other = BigDecimal.ZERO

        val result = a.isSafetyBigger(other)

        result shouldBe true
    }

    test("return true if this is null") {
        val a: BigDecimal? = null

        val result = a.isNullOrZero()

        result shouldBe true
    }

    test("return true if this is ZERO") {
        val a = BigDecimal.ZERO

        val result = a.isNullOrZero()

        result shouldBe true
    }

    test("return false if this is not null and not zero") {
        val a = BigDecimal.TEN

        val result = a.isNullOrZero()

        result shouldBe false
    }

    test("return true if this is not null and not zero") {
        val a = BigDecimal.TEN

        val result = a.isNotNullOrNotZero()

        result shouldBe true
    }
})

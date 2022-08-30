import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

/**
 * @author Heli
 * Created on 2022. 08. 30
 */
class LocalDateTimeExtensionTest : BehaviorSpec({

    given("return EpochMillis when given LocalDateTime") {
        val stub = LocalDateTime.of(2000, 1, 1, 0, 0)
        `when`("executed toEpochMillis with stub") {
            val actual = stub.toEpochMillis()
            then("assert executed toEpochMillis") {
                actual shouldBe 946684800000L
            }
        }
    }

    given("return LocalDateTime when given EpochMillis") {
        val stub = 946684800000L
        `when`("executed toLocalDateTime with stub") {
            val actual = stub.toLocalDateTime()
            then("assert executed toLocalDateTime") {
                actual shouldBe LocalDateTime.of(2000, 1, 1, 0, 0)
            }
        }
    }
})

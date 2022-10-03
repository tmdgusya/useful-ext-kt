import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * @return The return value is a Boolean value that determines whether it is null or not.
 */
@OptIn(ExperimentalContracts::class)
fun Any?.isNull(): Boolean {
    contract {
        returns(true) implies (this@isNull == null)
    }
    return this == null
}

/**
 * @return The return value is a Boolean value that determines whether it is not null or not.
 */
@OptIn(ExperimentalContracts::class)
fun Any?.isNotNull(): Boolean {
    contract {
        returns(true) implies (this@isNotNull != null)
    }
    return this != null
}

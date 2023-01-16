package ex4.exceptions

/*
 * by group 14
 * Exception if a dealer don't have enough money for buying a car
 * Status: finished
 */
class InsufficientBalanceException(message: String? = null, cause: Throwable? = null) :Exception(message, cause){
    constructor(cause:Throwable):this(null, cause)
}
package ex4.exceptions

class InsufficientBalanceException(message: String? = null, cause: Throwable? = null) :Exception(message, cause){
    constructor(cause:Throwable):this(null, cause)
}
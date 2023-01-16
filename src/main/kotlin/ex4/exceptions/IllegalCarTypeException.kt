package ex4.exceptions

/*
 * by group 14
 * Exception if a car is created with a wrong carType
 * Status: finished
 */
class IllegalCarTypeException(message: String? = null, cause: Throwable? = null) :Exception(message, cause){
    constructor(cause:Throwable):this(null, cause)
}
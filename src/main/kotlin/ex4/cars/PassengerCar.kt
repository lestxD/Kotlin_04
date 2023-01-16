package ex4.cars

import ex4.exceptions.IllegalCarTypeException

/*
 * by group 14
 * Class for representing Passenger Cars
 * Status: finished
 */
open class PassengerCar (type: CarType, price: Int, seats: Byte, performance: Short): Car(type, price, seats,
    performance){

    //check if CarType is correct
    init {
        if (type != PassengerCarType.SPORTSCAR && type != PassengerCarType.HATCHBACK && type != PassengerCarType.SUV &&
            type != PassengerCarType.SEDAN)
            throw IllegalCarTypeException("PassengerCar was created with invalid CarType")
    }

    //override toString to print all parameters
    override fun toString(): String {
        return ("$type - ${price / 100},${price % 100}€: Seats: $seats, Performance: ${performance}kw")
    }
}
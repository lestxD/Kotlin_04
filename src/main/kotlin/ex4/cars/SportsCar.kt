package ex4.cars

import ex4.exceptions.IllegalCarTypeException

/*
 * by group 14
 * Class for representing Sports Cars
 * Status: TODO finish this class
 */
class SportsCar(type: CarType, price: Int, seats: Byte, performance: Short, val suspension : Float) : PassengerCar(type,
    price, seats, performance,){

    //check if CarType is correct
    init {
        if (type != PassengerCarType.SPORTSCAR)
            throw IllegalCarTypeException("SportsCar was created with invalid CarType")
    }

    //override toString to print all parameters
    override fun toString(): String {
        return ("$type - $price€: Seats: $seats, Performance: ${performance}kw, Suspension Travel ${suspension}cm")
    }
}
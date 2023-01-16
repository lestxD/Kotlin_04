package ex4.dealership

import ex4.cars.*

/*
 * by group 14
 * Type-safe Builder for the Dealership.kt class
 * Status: finished
 */

//call the Type-safe Builder for Dealership
fun dealership(initialize: DealerBuilder.() -> Unit) = DealerBuilder().apply { initialize()}.build()

//class which builds a Dealership
class DealerBuilder {

    //default values to avoid lateinit, Delegates.notNull and !!
    var name : String = ""
    var balance : Long = 0
    var vehicles : MutableMap<String,MutableList<Car>> = mutableMapOf("SportsCars" to mutableListOf(),
        "Cars" to mutableListOf(), "Lorries" to mutableListOf())

    //create new Dealership
    fun build(): Dealership = Dealership(name, vehicles, balance)


    //add instance of SportsCar to the map
    fun addSportsCar(initialize: SportsCarBuilder.() -> Unit) = SportsCarBuilder().also {
            sportsCar -> sportsCar.initialize()
        vehicles["SportsCars"]?.add(sportsCar.build())
    }

    //add instance of PassengerCar to the map
    fun addPassengerCar(initialize: CarBuilder.() -> Unit) = CarBuilder().also {
            passengerCar -> passengerCar.initialize()
        vehicles["Cars"]?.add(passengerCar.build())
    }

    //add instance of Lorry to the map
    fun addLorry(initialize: LorryBuilder.() -> Unit) = LorryBuilder().also {
            lorry -> lorry.initialize()
        vehicles["Lorries"]?.add(lorry.build())
    }
}

//class which builds a SportsCars
class SportsCarBuilder{
    //default values to avoid lateinit, Delegates.notNull and !!
    var type : PassengerCarType = PassengerCarType.SPORTSCAR
    var price: Int = 0
    var seats: Byte = 0
    var performance: Short = 0
    var suspension: Float = 0f

    //create new SportsCar
    fun build() : SportsCar = SportsCar(type, price, seats, performance, suspension)
}

//class which builds a car
class CarBuilder{

    //default values to avoid lateinit, Delegates.notNull and !!
    var type : PassengerCarType = PassengerCarType.SUV
    var price: Int = 0
    var seats: Byte = 0
    var performance: Short = 0

    //create new car
    fun build() : PassengerCar = PassengerCar(type, price, seats, performance)
}

//class which builds a Lorry
class LorryBuilder{
    //default values to avoid lateinit, Delegates.notNull and !!
    var type : LorryType = LorryType.COVERED
    var price: Int = 0
    var seats: Byte = 0
    var performance: Short = 0
    var maxWeight : Short = 0

    //create new Lorry
    fun build() : Lorry =Lorry(type, price, seats, performance, maxWeight)
}





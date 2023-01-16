package ex4.dealership

import ex4.cars.Car
import ex4.cars.PassengerCar
import ex4.cars.PassengerCarType

/*
 * by group 14
 * Type-safe Builder for the Dealership.kt class
 * Status: //TODO not finished
 */

//call the Type-safe Builder for Dealership
fun dealership(initialize: DealerBuilder.() -> Unit) = DealerBuilder().apply { initialize()}.build()

//class which builds the Dealership
class DealerBuilder {

    /*
     * Tutorial notices:
     * Class Person = Dealership
     * (Data class) address = (Non Data class??) car or Lorry or sport car
     * buildPerson = dealership
     */

    //default values to avoid lateinit, Delegates.notNull and !!
    private var name : String = ""
    private var balance : Long = 0
    private var vehicles : MutableMap<String,MutableList<Car>> = mutableMapOf("SportsCars" to mutableListOf(),
        "Cars" to mutableListOf(), "Lorries" to mutableListOf())

    //build new Dealership without any instance of car
    fun build(): Dealership = Dealership(name, vehicles, balance)


    //add instance of SportsCar to the map
    fun addSportsCar(initialize: DealerBuilder.() -> Unit) = DealerBuilder().also {
            sportsCar -> sportsCar.initialize()
        vehicles["SportsCars"]?.add(PassengerCar(PassengerCarType.SUV, 0, 0, 0)) //TODO
    }

    //add instance of PassengerCar to the map
    fun addPassengerCar(initialize: DealerBuilder.() -> Unit) = DealerBuilder().also {
            passengerCar -> passengerCar.initialize()
        vehicles["Cars"]?.add(PassengerCar(PassengerCarType.SUV, 0, 0, 0)) //TODO
    }

    //add instance of Lorry to the map
    fun addLorry(initialize: DealerBuilder.() -> Unit) = DealerBuilder().also {
            lorry -> lorry.initialize()
        vehicles["Lorries"]?.add(PassengerCar(PassengerCarType.SUV, 0, 0, 0)) //TODO
    }
}






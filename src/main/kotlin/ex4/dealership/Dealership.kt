package ex4.dealership

import ex4.cars.Car
import ex4.cars.CarType
import ex4.cars.PassengerCarType
import ex4.exceptions.InsufficientBalanceException

/*
 * by group 14
 * Class for TODO
 * Status: TODO finish this class
 */
class Dealership(private val name : String, private var vehicles : MutableMap<String, MutableList<Car>> = mutableMapOf(), private var balance : Long) {

    //check if given vehicles map contains the three lists
    init {
        if (vehicles["SportsCars"] == null)
            vehicles["SportsCars"] = mutableListOf()

        if (vehicles["Cars"] == null)
            vehicles["Cars"] = mutableListOf()

        if (vehicles["Lorries"] == null)
            vehicles["Lorries"] = mutableListOf()
    }

    //The method sellVehicle sells a car and removes it from the vehicles map //TODO implement
    //updates balance + price of car //TODO implement
    //optional discount, optional carType //TODO implement
    //TODO ask what do with carType
    fun sellVehicle(car : Car, carType : CarType = PassengerCarType.SUV, discount : Short) : Triple<Car, Long, Int>{
        //Todo check if car avaible

        return Triple(car, balance, car.price)
    }

    //The method buyVehicle buys a car and add it to the vehicles map
    //updates balance - price of car
    //updates price depending on height of cost
    fun buyVehicle(car : Car): Pair<Long, Int>{
        if(balance - car.price >= 0)
            balance -= car.price
        else
            throw InsufficientBalanceException("The balance of the dealer $name is insufficient")

        if(car.price < 1000000)
            car.price = (car.price * 1.3F).toInt()
        else if (car.price < 4000000)
            car.price = (car.price * 1.2F).toInt()
        else
            car.price = (car.price * 1.1F).toInt()

        when(car.type){
            PassengerCarType.SPORTSCAR ->{
                vehicles["SportsCars"]?.add(car)
            }
            PassengerCarType.SEDAN ->{
                vehicles["Cars"]?.add(car)
            }
            PassengerCarType.HATCHBACK ->{
                vehicles["Cars"]?.add(car)
            }
            PassengerCarType.SUV ->{
                vehicles["Cars"]?.add(car)
            }
            else ->{
                vehicles["Lorries"]?.add(car)
            }
        }

        return Pair(balance, car.price)
    }

    //override toString to print all cars the dealer owns
    override fun toString(): String {
        var output = """
        Name: $name
        Balance: ${balance / 100},${balance % 100}
        Vehicles: ${"\n"}
        """.trimIndent()

        val listSportCars = vehicles["SportsCars"]
        val listCars = vehicles["Cars"]
        val listLorries = vehicles["Lorries"]

        if (listCars != null) {
            output += "\tCars:\n"
            for (car in listCars) {
                output += "\t\t$car\n"
            }
        }

        if (listSportCars != null) {
            output += "\tSportsCars:\n"
            for (sportCar in listSportCars) {
                output += "\t\t$sportCar\n"
            }
        }

        if (listLorries != null) {
            output += "\tLorries:\n"
            for (lorries in listLorries) {
                output += "\t\t$lorries\n"
            }
        }

        return output
    }
}


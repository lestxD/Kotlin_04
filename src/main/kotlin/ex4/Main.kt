package ex4

import ex4.cars.*
import ex4.dealership.Dealership
import ex4.dealership.dealership

fun main(args: Array<String>) {
    val passengerCar = PassengerCar(PassengerCarType.HATCHBACK, 10000, 4, 300)
    println(passengerCar.sellVehicle(1000))
    println(passengerCar.sellVehicle())
    println(passengerCar.sellVehicle(500))
    println(passengerCar.sellVehicle(50))
    println(passengerCar.sellVehicle(5))

    Lorry(LorryType.BOX, 1000000000, 4, 300, 5000)

    val dealership = Dealership("dealer", mutableMapOf(), 10000000000000)
    val sport01 = SportsCar(PassengerCarType.SPORTSCAR, 30012, 2, 400, 10F)
    val sport02 = SportsCar(PassengerCarType.SPORTSCAR, 40000, 3, 200, 8F)
    val sport03 = SportsCar(PassengerCarType.SPORTSCAR, 80000, 4, 300, 5F)
    val cars01 = PassengerCar(PassengerCarType.HATCHBACK, 123000, 3, 343)
    val cars02 = PassengerCar(PassengerCarType.SUV, 104500, 4, 120)
    val cars03 = PassengerCar(PassengerCarType.SEDAN, 10000, 4, 300)
    val cars04 = PassengerCar(PassengerCarType.SEDAN, 10000, 4, 300)

    val lorrie = Lorry(LorryType.COVERED, 10000, 4, 600, 4000)
    dealership.buyVehicle(sport01)
    dealership.buyVehicle(sport02)
    dealership.buyVehicle(sport03)
    dealership.buyVehicle(cars01)
    dealership.buyVehicle(cars02)
    dealership.buyVehicle(cars03)
    dealership.buyVehicle(cars04)
    dealership.buyVehicle(lorrie)
    dealership.sellVehicle(lorrie)

    println(dealership)


    //vipe builder tests
    println("check ur vipes")
    val naDuKleinerBuidler = dealership{
        name = "hyperHyper"
        balance = 823838932091

    }
    println(naDuKleinerBuidler)

    println("krass sogar cars alter")
    val brumm = dealership {
        name = "brr"
        balance = 12956757824

        addSportsCar{
            name = "ich bin schnell"
            suspension = 5f
        }

        addPassengerCar{
            name = "ich habe viel platz"
            price = 420
        }

        addLorry{
            name = "dööödDöööd"
            maxWeight = 187
        }
    }
    println(brumm)
}
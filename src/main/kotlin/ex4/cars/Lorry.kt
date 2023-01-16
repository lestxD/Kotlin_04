package ex4.cars

import ex4.exceptions.IllegalCarTypeException

/*
 * by group 14
 * Class for representing Lorries
 * Status: finished
 */
class Lorry (type : CarType, price : Int, seats : Byte, performance : Short, private var maxWeight : Short) : Car(type, price,
    seats, performance){

    //check if CarType is correct
    init {
        if (type != LorryType.BOX && type != LorryType.COVERED && type != LorryType.DUMP && type != LorryType.OPENHULL)
            throw IllegalCarTypeException("Lorry was created with invalid CarType")
    }

    //method changeType changes the LorryType of an existing Lorry and weight
    //returns extra charge
    private fun changeType(lorryType : LorryType) : Int{
        val rememberType = type
        type = lorryType

        when(rememberType){
            LorryType.DUMP -> {
                when(lorryType){
                    LorryType.OPENHULL -> {
                        maxWeight = (maxWeight + 3000).toShort()
                        return 300000
                    }
                    LorryType.COVERED -> {
                        maxWeight = (maxWeight + 2500).toShort()
                        return 350000
                    }
                    LorryType.BOX -> {
                        maxWeight = (maxWeight + 1500).toShort()
                        return 500000
                    }
                    else -> {}
                }
            }
            LorryType.OPENHULL -> {
                when(lorryType){
                    LorryType.DUMP -> {
                        maxWeight = (maxWeight - 3000).toShort()
                        return 400000
                    }
                    LorryType.COVERED -> {
                        maxWeight = (maxWeight - 500).toShort()
                        return 100000
                    }
                    LorryType.BOX -> {
                        maxWeight = (maxWeight - 1500).toShort()
                        return 200000
                    }
                    else -> {}
                }
            }
            LorryType.COVERED -> {
                when(lorryType){
                    LorryType.DUMP -> {
                        maxWeight = (maxWeight - 2500).toShort()
                        return 400000
                    }
                    LorryType.OPENHULL -> {
                        maxWeight = (maxWeight + 500).toShort()
                        return 0
                    }
                    LorryType.BOX -> {
                        maxWeight = (maxWeight -1000).toShort()
                        return 30000
                    }
                    else -> {}
                }
            }
            LorryType.BOX -> {
                when(lorryType){
                    LorryType.DUMP -> {
                        maxWeight = (maxWeight - 1500).toShort()
                        return 40000
                    }
                    LorryType.OPENHULL -> {
                        maxWeight = (maxWeight + 1500).toShort()
                        return 15000
                    }
                    LorryType.COVERED -> {
                        maxWeight = (maxWeight + 1000).toShort()
                        return 20000
                    }
                    else -> {}
                }
            }
        }
        return 0
    }

    //The method giveDiscount returns the (price + changeCost) - discount
    //if absolut Value of Discount > 10.000€ change Cost are for free
    private fun giveDiscount(discount : Short, changeCost : Int) : Int{
        if(discount > 1000 || discount < 0)
            throw IllegalArgumentException("IllegalArgumentException at giveDiscount")

        //Convert the format 1234% to the absolute amount of the discount
        //use toLong() so we get no bit overflow with big cost values-> Short not enough for some calculation
        var absolutValueDiscount = (discount.toLong() * (price + changeCost).toLong()) / 10000
        if (absolutValueDiscount > 1000000)
            absolutValueDiscount = (discount.toLong() * price.toLong()) / 10000
        return price - absolutValueDiscount.toInt()
    }

    //The method sellVehicle returns the actual price to pay
    fun sellVehicle(discount: Short, lorryType: LorryType) : Int{
        return giveDiscount(discount , changeType(lorryType))
    }

    //override toString to print all parameters
    override fun toString(): String {
        return ("$type - ${price / 100},${price % 100}€: Seats: $seats, Performance: ${performance}kw, Max Weight: ${maxWeight}kg")
    }
}
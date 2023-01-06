package ex4.cars

/*
 * by group 14
 * abstract Class for representing cars
 * Status: finished
 */
abstract class Car (var type : CarType, var price : Int, val seats : Byte, val performance : Short) {

    //The method giveDiscount returns the price - discount
    fun giveDiscount(discount: Short): Int {
        if(discount > 1000 || discount < 0 || (type == PassengerCarType.SPORTSCAR && discount > 400))
            throw IllegalArgumentException("IllegalArgumentException at giveDiscount")

        //Convert the format 12,34% to the absolute amount of the discount
        //use toLong() so we get no bit overflow with big cost values-> Short not enough for some calculations
        val absolutValueDiscount = (discount.toLong() * price.toLong()) / 10000
        return price - absolutValueDiscount.toInt()
    }

    //The method sellVehicle returns the actual price to pay
    fun sellVehicle(discount: Short = 0) : Int{
        return giveDiscount(discount)
    }
}
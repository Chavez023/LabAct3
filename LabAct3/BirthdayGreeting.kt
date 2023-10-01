fun main() {
    val border = "="
    val timesToRepeat = 3
    val name = "Charles"
    val age = 21
    val ageD = age * 365

    
    println("Happy Birthday $name!")
    println(" $name, your age is $age")
    println("You are already $ageD days old, $name")
    

    // Print cake
    println("     ,,,,    ")
    println("     ||||    ")
    println("=============")
    println("@@@@@@@@@@@@@")
    println("{~@~@~@~@~@~@}")
    println("@@@@@@@@@@@@@")
    println(" ")
}

fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        println(border)
    }
}

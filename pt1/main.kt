

fun main(){
    firstOpt()
    secondOpt()
}

fun firstOpt() {
    println("======First  Option=======")
    for (i in 1..100) {
        when {
            i % 3 == 0 && i % 5 == 0 -> println("$i Piff Paff")
            i % 3 == 0 -> println("$i Piff")
            i % 5 == 0 -> println("$i Paff")
            else -> println(i)
        }
    }
    println("==========================")
    println()
    println()
}

fun secondOpt() {
    println("======Second Option=======")
    var i = 1

    while (i<=100){
        if (i%3==0 && i%5==0){
            println("$i Piff Paff")
        } else if (i%3==0){
            println("$i Piff")
        } else if (i%5==0){
            println("$i Paff")
        } else {
            println(i)
        }
        i++
    }
    println("==========================")
    println()
    println()
}
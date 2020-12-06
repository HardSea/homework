//Є список, деякі елементи якого повторюються кілька разів. Знайти елемент, який повторюється найчастіше. 

fun main() {

    var listInt = mutableListOf<Int>()

    for(i in 1..20) listInt.add((1..4).random())
    println(listInt)
    getOftenElement(listInt)
    
    println()
    println()
    
    val listString = listOf<String>("a","b","c","d","a","d","c","d","a","d","c","a","d","c","c","c","d","c","d","a",)
    
    println(listString)
    getOftenElement(listString)
    
}

fun getOftenElement(list: List<*>) {
    val oftenPair = list.groupingBy{it}.eachCount().maxByOrNull{it.value}
    println("Element ${oftenPair?.key} is repeated ${oftenPair?.value} times")
}

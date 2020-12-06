//Відсортувати map<Int, String> по зростанню значення ключа. 

fun main() {
    
    var map = mapOf<Int, String>(2 to "second", 6 to "sixth", 1 to "first", 4 to "fourth", 3 to "third", 5 to "fifth")
    println(map)
    map = map.toSortedMap()
    println(map)
    
}
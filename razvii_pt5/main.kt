import java.io.File
import com.google.gson.Gson
import java.io.InputStream

data class Person(val name: String, var age: Int, val mother: Person? = null, val father: Person? = null) {
    var adult: Boolean = age > 18
    val familyCount = familyCnt

    companion object {
        var familyCnt: Int = 1
    }

    init {
        familyCnt++
    }

    override fun toString(): String {
        return "| Name — $name | Age — $age | Adult — ${if (adult) "Yes" else "No"} |"
    }
}

fun main() {

    exampleOne()
    secondExample()

}

//  Приклад реалізації з вже заповненими данними. Спочатку серіалізація, потім десеріалізація
fun exampleOne() {
    println("——————————First Example——————————")
    val grandmaMother = Person("Lyba", 61)
    val grandfaMother = Person("Vitaliy", 63)

    val grandmaFather = Person("Anna", 73)
    val grandfaFather = Person("Anatoliy", 75)

    val mother = Person("Maria", 41, grandmaMother, grandfaMother)
    val father = Person("Oleksandr", 42, grandmaFather, grandfaFather)

    val me = Person("Artem", 20, mother, father)

    val gson = Gson()
    val toJson = gson.toJson(me).toString()

    println("Приклад серіалізації з заповненими дата класами: $toJson")


    val meDeserialized = gson.fromJson<Person>(toJson, Person::class.java)
    println(meDeserialized.toString())
    println("Mother's mother's name — " + meDeserialized.mother?.mother?.name)
    println("Father's mother's name — " + meDeserialized.father?.mother?.age)
    println("—————————————————————————————————")
    println()
    println()

}

//  Приклад реалізації з файлу з заповненими данними, тобто десеріалізація з файлу

fun secondExample() {
    println("——————————Second Example——————————")
    val gson = Gson()

    try {
        val inputStream: InputStream = File("person.json").inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }.toString()

        val meDeserialized: Person = gson.fromJson<Person>(inputString, Person::class.java)

        println(meDeserialized.toString())
        println("Mother's mother's name — " + meDeserialized.mother?.mother?.name)
        println("Father's mother's name — " + meDeserialized.father?.mother?.age)
    } catch (e: Exception){
        println("Need to change the project settings")
    }

    println("—————————————————————————————————")
    println()
    println()
}
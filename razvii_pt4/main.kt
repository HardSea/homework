class Person(
        val name: String,
        val age: Int,
        val mother: Person? = null,
        val father: Person? = null,
        var brotherssisters: Map<Person, String>? = null
) {

    val familyCount get() = familyCnt - 1

    fun setNewBrotherSisters(newlist: Map<Person, String>) {
        if (this.brotherssisters == null) this.brotherssisters = newlist
    }

    companion object {
        var familyCnt: Int = 0
    }

    init {
        familyCnt++
    }

    fun getBroothersSistersInfo(): String {
        val string = brotherssisters?.keys.toString()
        return string.substring(1, string.length - 1)
    }

    override fun toString(): String {
        return "Name – $name Age – $age"
    }

}

fun getMe(): Person {
    val grandmaMother = Person("Lyba", 61)
    val grandfaMother = Person("Vitaliy", 63)

    val grandmaFather = Person("Anna", 73)
    val grandfaFather = Person("Anatoliy", 75)

    val motherBrother = Person("Nikolay", 37, grandmaMother, grandmaFather)
    val fatherSister = Person("Tetyana", 48, grandfaMother, grandfaFather)

    val mother = Person("Maria", 41, grandmaMother, grandfaMother, mapOf(motherBrother to "Brother"))
    val father = Person("Oleksandr", 42, grandmaFather, grandfaFather, mapOf(fatherSister to "Sister"))
    motherBrother.setNewBrotherSisters(mapOf(mother to "Sister"))
    fatherSister.setNewBrotherSisters(mapOf(father to "Brother"))

    val myBrother = Person("Denis", 9, mother, father)
    val mySister = Person("Anastasia", 12, mother, father)
    val me = Person("Artem", 20, mother, father, mapOf(myBrother to "Brother", mySister to "Sister"))
    myBrother.setNewBrotherSisters(mapOf(mySister to "Sister", me to "Brother"))
    mySister.setNewBrotherSisters(mapOf(myBrother to "Brother", me to "Brother"))

    return me
}


fun main() {

    val me = getMe()

    println("My brothers and sisters info: " + me.getBroothersSistersInfo())
    println("The number of all my known relatives: " + me.familyCount)
    println("My father's mother's name: " + me.father?.mother?.name)
    println("Information about my mother brother: " + me.mother?.brotherssisters?.filter { it.value == "Brother" }?.keys.toString())

}
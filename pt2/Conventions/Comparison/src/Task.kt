

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        when {
            year != other.year -> return year - other.year
            month != other.month -> return month - other.month
            else -> return dayOfMonth - other.dayOfMonth
        }
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}

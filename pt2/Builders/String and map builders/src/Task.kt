import java.util.HashMap

fun <K,V> buildMap(build: HashMap<K,V>.() -> Unit): Map<K, V> {
    val m = HashMap<K, V>()
    m.build()
    return m
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

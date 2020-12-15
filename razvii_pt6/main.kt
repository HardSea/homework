import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.atomic.AtomicLong


const val millisadd: Long = 10
const val millisprint: Long = 1000


// Не нашёл лучшего решения для меньшего отклонения
// При millisadd — 10 и millisprint — 1000 отклонение от нормы(400), примерно 6-7%, у меня
// А при millisadd — 100 и millisprint — 10000 уже стабильно 1% отклонения
// Через Executors отклонение ещё больше


fun main() {
    println("Print q to exit..")
    val counter = AtomicLong(0)
    var run = true
    val sdf = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())

    fun increaseCounter() {
        counter.incrementAndGet()
    }

    val runnable = Runnable {
        while (run) {
            increaseCounter()
            Thread.sleep(millisadd)
        }
    }

    Thread(runnable).start()
    Thread(runnable).start()
    Thread(runnable).start()
    Thread(runnable).start()

    Thread {
        while (run) {
            Thread.sleep(millisprint)
            if (run) println("${sdf.format(Date())} Counter = $counter")
            //print current time + current counter value
        }
    }.start()

    if (readLine()!! == "q") {
        run = false
        println("Wait..")
    }
}
package multithreading

import java.util.concurrent.Semaphore
import kotlin.concurrent.thread
import kotlin.test.Test
import kotlin.test.assertTrue
/*
Guarantee that a1 happens before b2 and b1 happens before a2
 */
class Rendezvous {
    val aArrived = Semaphore(1)
    val bArrived = Semaphore(1)

    fun perform() {
        thread(start = true) {
            aArrived.acquire()
            println("Thread A - a1")
            aArrived.release()
            bArrived.acquire()
            println("Thread A - a2")
            println("Thread A - finish")

        }

        thread(start = true) {
            bArrived.acquire()
            println("Thread B - b1")
            bArrived.release()
            aArrived.acquire()
            println("Thread B - b2")
            println("Thread B - finish")
        }
    }

    @Test
    fun rendezvous() {
        val rendezous = Rendezvous()
        rendezous.perform()
        assertTrue { true }
    }
}
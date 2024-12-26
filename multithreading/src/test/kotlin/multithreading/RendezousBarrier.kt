package multithreading

import java.util.concurrent.CyclicBarrier
import kotlin.concurrent.thread
import kotlin.test.Test
import kotlin.test.assertTrue

class RendezvousCyclicBarrier {
    val n: Int = 5
    val barrier = CyclicBarrier(n)

    fun perform() {
        for (i in 0 until n) {
            thread(start = true) {
                println("Thread ${i} - rendezvous")
                barrier.await()
                println("Thread ${i} - critical point")
            }
        }
    }

    @Test
    fun rendezvous() {
        val rendezous = RendezvousCyclicBarrierSemaphore()
        for (i in 0..100){
            rendezous.perform()
            Thread.sleep(10)
        }
        assertTrue { true }
    }
}
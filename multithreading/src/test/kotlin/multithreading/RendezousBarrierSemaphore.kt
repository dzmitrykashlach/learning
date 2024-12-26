package multithreading

import java.util.concurrent.Semaphore
import kotlin.concurrent.thread
import kotlin.test.Test
import kotlin.test.assertTrue

class RendezvousCyclicBarrierSemaphore {
    val n: Int = 5
    val mutex = Semaphore(1)
    var count = 0
    val turnstile = Semaphore(0)

    fun perform() {
        for (i in 0 until n) {
            thread(start = true) {

                println("Thread ${i} - rendezvous")
                mutex.acquire()
                    count += 1
                mutex.release()
                if (count == n) {
                    turnstile.release()
                }
                turnstile.acquire()
                turnstile.release()
                println("Thread ${i} - critical point")

                mutex.acquire ()
                count -= 1
                mutex.release ()

                if(count == 0) {
                    turnstile.acquire()
                }
            }
        }
    }

    @Test
    fun rendezvous() {
        val rendezous = RendezvousCyclicBarrierSemaphore()
        for (i in 0..100) {
            rendezous.perform()
            Thread.sleep(10)
        }
        assertTrue { true }
    }
}
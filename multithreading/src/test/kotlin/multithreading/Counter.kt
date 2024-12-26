package multithreading

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.Test

class Counter {

    val atomicCounter = AtomicInteger()
    val mutex = Mutex()

    @Volatile
    var counter: Int = 0
    fun increment(): () -> Int = {
        counter++
    }

    @Test
    fun testSyncCounter() {
        val start = System.currentTimeMillis()
        val duration = 50
        runBlocking {
            GlobalScope.launch {
                while (System.currentTimeMillis() < start + duration) {
                    mutex.withLock {
                        increment().invoke()
                            .also {
                                println(counter)
                            }
                    }
                }
            }
        }

        runBlocking {
            GlobalScope.launch {
                while (System.currentTimeMillis() < start + duration) {
                    mutex.withLock {
                        increment().invoke()
                            .also {
                                println(counter)
                            }
                    }
                }
            }.join()
        }
    }

    @Test
    fun testAtomicCounter() {
        val start = System.currentTimeMillis()
        val duration = 50
        runBlocking {
            GlobalScope.launch {
                while (System.currentTimeMillis() < start + duration) {
                    println(atomicCounter.getAndIncrement())
                }
            }
        }

        runBlocking {
            GlobalScope.launch {
                while (System.currentTimeMillis() < start + duration) {
                    println(atomicCounter.getAndIncrement())
                }
            }.join()
        }
    }
}
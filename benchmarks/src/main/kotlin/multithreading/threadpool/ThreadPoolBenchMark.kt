package multithreading.threadpool

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import java.util.concurrent.atomic.AtomicInteger

@State(Scope.Benchmark)
open class ThreadPoolBenchMark {
    @Param("200000000")
    var numOfTasks = 0

    @Benchmark
    fun atomic() {
        val concurrentLinkedQueuePool = ConcurrentLinkedQueuePool(10)
        val counter = AtomicInteger()

        for (i in 0 until numOfTasks) {
            val t = Runnable {
                counter.getAndIncrement()
            }
            concurrentLinkedQueuePool.execute(t)
        }
        Thread.sleep(1)
        concurrentLinkedQueuePool.stop()
    }

    @Benchmark
    fun blocking() {
        val concurrentQueueThreadPool = LinkedBlockingQueuePool(10)
        val counter = AtomicInteger()

        for (i in 0 until numOfTasks) {
            val t = Runnable {
                counter.getAndIncrement()
            }
            concurrentQueueThreadPool.execute(t)
        }
        Thread.sleep(1)
        concurrentQueueThreadPool.stop()
    }
}
package multithreading.threadpool

import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.LinkedBlockingQueue

class ConcurrentLinkedQueuePool(capacity: Int) : IThreadPool {

    private val workingQueue = ConcurrentLinkedQueue<Runnable>()
    private val workers = LinkedBlockingQueue<PoolRunnable>()
    private var isStopped = false

    init {
        for (w in 0 until capacity) {
            val poolThreadRunnable =
                PoolRunnable(workingQueue)

            workers.offer(poolThreadRunnable)
        }
        for (w in workers) {
            Thread(w).start()
        }
    }

    override fun execute(task: Runnable) {
        if (this.isStopped) throw IllegalStateException("ThreadPool is stopped")

        this.workingQueue.offer(task)
    }

    override fun stop() {
        this.isStopped = true
        for (w in workers) {
            w.doStop()
        }
    }

    @Synchronized
    override fun waitUntilAllTasksFinished() {
        while (this.workingQueue.size > 0) {
            try {
                Thread.sleep(1)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}
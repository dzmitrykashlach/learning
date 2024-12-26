package multithreading.threadpool

import java.util.*


class PoolRunnable(queue: AbstractQueue<*>?) : Runnable {
    private var thread: Thread? = null
    private var taskQueue: AbstractQueue<*>? = null
    private var isStopped = false

    init {
        taskQueue = queue
    }

    override fun run() {
        this.thread = Thread.currentThread()
        while (!isStopped()) {
            try {
                val runnable = taskQueue!!.poll() as Runnable
                runnable.run()
            } catch (e: Exception) {
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    @Synchronized
    public fun doStop() {
        isStopped = true
        //break pool thread out of dequeue() call.
        thread!!.interrupt()
    }

    @Synchronized
    fun isStopped(): Boolean {
        return isStopped
    }
}
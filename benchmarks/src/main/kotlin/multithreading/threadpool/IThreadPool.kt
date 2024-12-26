package multithreading.threadpool

interface IThreadPool {
    fun execute(task: Runnable)
    fun stop()
    fun waitUntilAllTasksFinished()
}
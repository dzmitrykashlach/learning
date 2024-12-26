package multithreading

import org.openjdk.jmh.annotations.*
import java.util.concurrent.*
import java.util.concurrent.locks.ReentrantReadWriteLock
import java.util.concurrent.locks.StampedLock


@State(Scope.Benchmark)
class StampedLock {
    @Param("100", "1000", "10000")
    private var NUM_READERS = 0
    private val NUM_WRITERS = 10
    private val NUM_OPERATIONS = 1000

    @Benchmark
    fun optimisticRead() {
        val stampedLock = StampedLock()

        var executor = Executors.newFixedThreadPool(NUM_READERS + NUM_WRITERS)

        for (i in 0 until NUM_READERS) {
            executor.submit {
                for (j in 0 until NUM_OPERATIONS) {
                    var stamp: Long = stampedLock.tryOptimisticRead()
                    // Simulate read operation
                    if (!stampedLock.validate(stamp)) {
                        stamp = stampedLock.readLock()
                        try {
                            // Simulate read operation
                        } finally {
                            stampedLock.unlockRead(stamp)
                        }
                    }
                }
            }
        }

        for (i in 0 until NUM_WRITERS) {
            executor.submit {
                for (j in 0 until NUM_OPERATIONS) {
                    val stamp: Long = stampedLock.writeLock()
                    try {
                        // Simulate write operation
                    } finally {
                        stampedLock.unlockWrite(stamp)
                    }
                }
            }
        }
        executor.shutdown()
        executor.awaitTermination(1, TimeUnit.MINUTES)
    }

    @Benchmark
    fun lockingRead() {
        val reentrantReadWriteLock = ReentrantReadWriteLock()
        val executor = Executors.newFixedThreadPool(NUM_READERS + NUM_WRITERS)
        for (i in 0 until NUM_READERS) {
            executor.submit {
                for (j in 0 until NUM_OPERATIONS) {
                    reentrantReadWriteLock.readLock().lock()
                    try {
                        // Simulate read operation
                    } finally {
                        reentrantReadWriteLock.readLock().unlock()
                    }
                }
            }
        }

        for (i in 0 until NUM_WRITERS) {
            executor.submit {
                for (j in 0 until NUM_OPERATIONS) {
                    reentrantReadWriteLock.writeLock().lock()
                    try {
                        // Simulate write operation
                    } finally {
                        reentrantReadWriteLock.writeLock().unlock()
                    }
                }
            }
        }
        executor.shutdown()
        executor.awaitTermination(1, TimeUnit.MINUTES)
    }
}





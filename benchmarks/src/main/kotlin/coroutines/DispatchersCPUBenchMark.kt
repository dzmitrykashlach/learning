package coroutines

import kotlinx.coroutines.*
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.math.BigInteger
import kotlin.concurrent.thread


@State(Scope.Benchmark)
class DispatchersCPUBenchMark {
    @Param("2000", "4000")
    var factorialSize = 0
    var nCoroutines = 4000


    @Benchmark
    fun coroutinesDispatchersIO(bh:Blackhole) = runBlocking {
        repeat(nCoroutines) {
            async (Dispatchers.IO) {
                bh.consume(factorial(factorialSize))
            }.await()
        }
    }

    @Benchmark
    fun coroutinesDispatchersDefault(bh:Blackhole) = runBlocking {
        repeat(nCoroutines) {
            async(Dispatchers.Default) {
                bh.consume(factorial(factorialSize))
            }.await()
        }
    }


    @Benchmark
    fun threads(bh:Blackhole) {
        val threads = List(nCoroutines) {
            thread(start = true) {
                bh.consume(factorial(factorialSize))
            }
        }
        threads.forEach { it.join() }
    }

    val factorial = fun(n: Int): BigInteger? {
        var result = BigInteger.ONE
        for (i in 2..n) result = result.multiply(BigInteger.valueOf(i.toLong()))
        return result
    }
}





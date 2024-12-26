package bitwise

import org.openjdk.jmh.annotations.*

@State(Scope.Benchmark)
class PowerSetBenchmark {
    @Param("3", "4", "5", "9", "10","11", "20", "26")
    var setSize = 0
    lateinit var set: IntArray

    @Setup
    fun setUp() {
        set = IntArray(setSize) { i -> i }
    }


    @Benchmark
    fun powSetRecursive() {
        val ps = PowerSet(set)
        ps.generateRecursive(
            0, BooleanArray(setSize)
        )

    }

    @Benchmark
    fun powSetBinary() {
        val ps = PowerSet(set)
        ps.generateBinary()
    }

}
package dynamicprogramming.mincost

import org.openjdk.jmh.annotations.*
import java.lang.RuntimeException

@State(Scope.Benchmark)
class CellMinCostBenchmark {

    @Benchmark
    fun minCost5by5() {
        val cost = arrayOf(
            intArrayOf(4, 7, 8, 6, 4),
            intArrayOf(6, 7, 3, 9, 2),
            intArrayOf(3, 8, 1, 2, 4),
            intArrayOf(7, 1, 7, 3, 7),
            intArrayOf(2, 9, 8, 9, 3)
        )
        val cellMinCost = CellMinCost(cost).minCost(4, 4)
        if (cellMinCost != 36) {
            throw RuntimeException("Method returned result which is not expected ->$cellMinCost")
        }
    }

    @Benchmark
    fun minCost10by10() {
        val cost = arrayOf(
            intArrayOf(4, 7, 8, 6, 4, 20, 20, 40, 40, 10),
            intArrayOf(6, 7, 3, 9, 2, 12, 85, 78, 70, 340),
            intArrayOf(3, 8, 1, 2, 4, 13, 14, 98, 32, 23),
            intArrayOf(7, 1, 7, 3, 7, 11, 12, 14, 65, 89),
            intArrayOf(2, 9, 8, 9, 3, 1, 1000, 20, 340, 560),
            intArrayOf(20, 20, 40, 40, 10, 2, 14, 98, 32, 23),
            intArrayOf(14, 98, 32, 23, 3, 4, 600, 600, 600, 600),
            intArrayOf(20, 20, 40, 40, 10, 1, 600, 600, 600, 600),
            intArrayOf(14, 98, 32, 23, 34, 3, 5, 7, 9, 56),
            intArrayOf(120, 220, 20, 20, 40, 40, 10, 40, 1, 2),
        )
        val cellMinCost = CellMinCost(cost).minCost(9, 9)
        if (cellMinCost != 71) {
            throw RuntimeException("Method returned result which is not expected ->$cellMinCost")
        }
    }

    @Benchmark
    fun minCost10by10Memo() {
        val cost = arrayOf(
            intArrayOf(4, 7, 8, 6, 4, 20, 20, 40, 40, 10),
            intArrayOf(6, 7, 3, 9, 2, 12, 85, 78, 70, 340),
            intArrayOf(3, 8, 1, 2, 4, 13, 14, 98, 32, 23),
            intArrayOf(7, 1, 7, 3, 7, 11, 12, 14, 65, 89),
            intArrayOf(2, 9, 8, 9, 3, 1, 1000, 20, 340, 560),
            intArrayOf(20, 20, 40, 40, 10, 2, 14, 98, 32, 23),
            intArrayOf(14, 98, 32, 23, 3, 4, 600, 600, 600, 600),
            intArrayOf(20, 20, 40, 40, 10, 1, 600, 600, 600, 600),
            intArrayOf(14, 98, 32, 23, 34, 3, 5, 7, 9, 56),
            intArrayOf(120, 220, 20, 20, 40, 40, 10, 40, 1, 2),
        )
        val cellMinCost = CellMinCostMemoization(cost).minCost(9, 9)
        if (cellMinCost != 71) {
            throw RuntimeException("Method returned result which is not expected ->$cellMinCost")
        }
    }


}





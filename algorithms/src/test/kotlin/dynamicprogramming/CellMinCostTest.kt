package dynamicprogramming

import com.algorithms.storehouse.logic.dynamicprogramming.lastcell.CellMinCost
import kotlin.test.assertEquals
import kotlin.test.Test

class CellMinCostTest {

    @Test
    fun minCostTest(){
        val cost = arrayOf(
            intArrayOf(4, 7, 8, 6, 4),
            intArrayOf(6, 7, 3, 9, 2),
            intArrayOf(3, 8, 1, 2, 4),
            intArrayOf(7, 1, 7, 3, 7),
            intArrayOf(2, 9, 8, 9, 3)
        )
        val cellMinCost = CellMinCost(cost)
        assertEquals(36,cellMinCost.minCost(4,4))
    }
}
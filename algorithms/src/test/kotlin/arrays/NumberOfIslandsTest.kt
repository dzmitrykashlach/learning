package arrays

import com.algorithms.storehouse.logic.arrays.NumberOfIslands
import kotlin.test.assertEquals
import kotlin.test.Test

class NumberOfIslandsTest {

    @Test
    fun numberOfIslandsTest() {
        val numberOfIslands = NumberOfIslands()
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 0, 0, 0, 1),
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(1, 1, 1, 0, 1),
            intArrayOf(0, 0, 0, 0, 1)
        )
        assertEquals(1,numberOfIslands.numIslands(grid))
    }
}
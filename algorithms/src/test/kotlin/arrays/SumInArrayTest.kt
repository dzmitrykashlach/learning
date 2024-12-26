package arrays

import com.algorithms.storehouse.logic.arrays.SumInArray
import kotlin.test.Test
import kotlin.test.assertEquals

class SumInArrayTest {
    @Test
    fun `Should return indexes if sum exists`() {
        var arr = intArrayOf(1, 4, 20, 3, 10, 5)

        var indexes = SumInArray().find(arr,33)
        assertEquals(4, indexes.first)
        assertEquals(2, indexes.second)

        arr = intArrayOf(1, 4, 20, 3, 10, 5)

        indexes = SumInArray().find(arr,5)
        assertEquals(1, indexes.first)
        assertEquals(0, indexes.second)

        arr = intArrayOf(1, 4, 20, 3, 10, 5)

        indexes = SumInArray().find(arr,15)
        assertEquals(5, indexes.first)
        assertEquals(4, indexes.second)
    }

}
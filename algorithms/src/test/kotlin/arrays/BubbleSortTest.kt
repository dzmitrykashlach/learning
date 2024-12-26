package arrays

import com.algorithms.storehouse.logic.sorting.BubbleSort
import kotlin.test.Test
import kotlin.test.assertEquals
import java.util.*

class BubbleSortTest {
    @Test
    fun bubbleSortTest() {
        val input = intArrayOf(1, 2, 3, 4, 78, 2, 11, 555, 1, 234, 7, 10, 45)
        assertEquals(
            "[1, 1, 2, 2, 3, 4, 7, 10, 11, 45, 78, 234, 555]",
            Arrays.toString(BubbleSort().perform(input))
        )
    }
}
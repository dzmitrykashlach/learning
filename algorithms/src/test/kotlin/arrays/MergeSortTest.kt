package arrays

import com.algorithms.storehouse.logic.sorting.MergeSort
import kotlin.test.Test
import kotlin.test.assertEquals
import java.util.*

class MergeSortTest {
    @Test
    fun mergeSortTest() {
        var input = intArrayOf()
        assertEquals(
            "[]",
            Arrays.toString(MergeSort().perform(input))
        )
        input = intArrayOf(1)
        assertEquals(
            "[1]",
            Arrays.toString(MergeSort().perform(input))
        )
        input = intArrayOf(2,1)
        assertEquals(
            "[1, 2]",
            Arrays.toString(MergeSort().perform(input))
        )
        input = intArrayOf(2, 1, 3)
        assertEquals(
            "[1, 2, 3]",
            Arrays.toString(MergeSort().perform(input))
        )
        input = intArrayOf(2, 4, 1, 3)
        assertEquals(
            "[1, 2, 3, 4]",
            Arrays.toString(MergeSort().perform(input))
        )
        input = intArrayOf(4, 2, 1, 5, 3)
        assertEquals(
            "[1, 2, 3, 4, 5]",
            Arrays.toString(MergeSort().perform(input))
        )
        input = intArrayOf(2, 6, 4, 7, 1, 5, 3)
        assertEquals(
            "[1, 2, 3, 4, 5, 6, 7]",
            Arrays.toString(MergeSort().perform(input))
        )
        input = intArrayOf(1, 2, 3, 4, 78, 2, 11, 555, 1, 234, 7, 10, 45)
        assertEquals(
            "[1, 1, 2, 2, 3, 4, 7, 10, 11, 45, 78, 234, 555]",
            Arrays.toString(MergeSort().perform(input))
        )
    }
}
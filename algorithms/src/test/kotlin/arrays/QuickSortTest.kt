package arrays

import com.algorithms.storehouse.logic.sorting.QuickSort
import kotlin.test.assertEquals
import kotlin.test.Test
import java.util.*

class QuickSortTest {
    @Test
    fun quickSortTest1() {
        val input = intArrayOf()
        assertEquals(
            "[]",
            Arrays.toString(QuickSort(input).perform(0, 0))
        )
    }

    @Test
    fun quickSortTest2() {
        val input = intArrayOf(1)
        assertEquals(
            "[1]",
            Arrays.toString(QuickSort(input).perform(0, 0))
        )
    }

    @Test
    fun quickSortTest3() {
        val input = intArrayOf(2,1)
        assertEquals(
            "[1, 2]",
            Arrays.toString(QuickSort(input).perform(0,1))
        )
    }

    @Test
    fun quickSortTest4() {
        val input = intArrayOf(2, 1, 3)
        assertEquals(
            "[1, 2, 3]",
            Arrays.toString(QuickSort(input).perform(0, 2))
        )
    }

    @Test
    fun quickSortTest5() {
        val input = intArrayOf(2, 4, 1, 3)
        assertEquals(
            "[1, 2, 3, 4]",
            Arrays.toString(QuickSort(input).perform(0, 3))
        )
    }

    @Test
    fun quickSortTest6() {
        val input = intArrayOf(4, 2, 1, 5, 3)
        assertEquals(
            "[1, 2, 3, 4, 5]",
            Arrays.toString(QuickSort(input).perform(0, 4))
        )
    }

    @Test
    fun quickSortTest7() {
        val input = intArrayOf(2, 6, 4, 7, 1, 5, 3)
        assertEquals(
            "[1, 2, 3, 4, 5, 6, 7]",
            Arrays.toString(QuickSort(input).perform(0, 6))
        )
    }

    @Test
    fun quickSortTest8() {
        val input = intArrayOf(555, 2, 1, 11, 4, 3, 78, 2, 1, 234, 7, 10, 45)
        assertEquals(
            "[1, 1, 2, 2, 3, 4, 7, 10, 11, 45, 78, 234, 555]",
            Arrays.toString(QuickSort(input).perform(0, 12))
        )
    }

    @Test
    fun quickSortTest9() {
        val input = intArrayOf(11, 2, 35, 0)
        assertEquals(
            "[0, 2, 11, 35]",
            Arrays.toString(QuickSort(input).perform(0, 3))
        )
    }
}
package arrays

import com.algorithms.storehouse.logic.arrays.CommonNumberInArrays
import kotlin.test.Test
import kotlin.test.assertEquals

class CommonNumberInArraysTest {
    @Test
    fun `Should find common number if it is found`() {
        val arr1 = intArrayOf(1, 2, 4, 5)
        val arr2 = intArrayOf(3, 3, 4)
        val arr3 = intArrayOf(2, 3, 4, 5, 6)

        val cn = CommonNumberInArrays()
        assertEquals(4, cn.commonNumber(arr1, arr2, arr3))
    }

    @Test
    fun `Should return int_min if common number is not found`() {
        var arr1 = intArrayOf(1, 2, 2, 5)
        var arr2 = intArrayOf(3, 3, 4)
        var arr3 = intArrayOf(2, 3, 4, 5, 6)

        var cn = CommonNumberInArrays()
        assertEquals(Int.MIN_VALUE, cn.commonNumber(arr1, arr2, arr3))

        arr1 = intArrayOf(1, 2, 4, 5)
        arr2 = intArrayOf(3, 3, 4)
        arr3 = intArrayOf(2, 3, 5, 5, 6)

        cn = CommonNumberInArrays()
        assertEquals(Int.MIN_VALUE, cn.commonNumber(arr1, arr2, arr3))

    }
}
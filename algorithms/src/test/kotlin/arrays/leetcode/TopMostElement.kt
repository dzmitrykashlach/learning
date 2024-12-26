package arrays.leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

class TopMostElement {
    fun maximumTop(nums: IntArray, k: Int): Int {
        if (nums.size == 1) {
            return -1
        }

        var arr = nums.toList()
        var topMostElement = Int.MIN_VALUE
        for (i in 0 until k) {
            if (i >= arr.size) {
                return topMostElement
            }
            val element = arr[0]
            arr = arr.drop(1)
            topMostElement = if (element > topMostElement) element else topMostElement
        }

        return topMostElement
    }


    @Test
    fun `5,2,2,4,0,6`() {
        val nums = intArrayOf(5, 2, 2, 4, 0, 6)
        val result = TopMostElement().maximumTop(nums, 4)
        assertEquals(5, result)
    }

    @Test
    fun `99,95,68,24,18`() {
        val nums = intArrayOf(99, 95, 68, 24, 18)
        val result = TopMostElement().maximumTop(nums, 69)
        assertEquals(99, result)
    }

    @Test
    fun `2`() {
        val nums = intArrayOf(2)
        val result = TopMostElement().maximumTop(nums, 4)
        assertEquals(-1, result)
    }


}
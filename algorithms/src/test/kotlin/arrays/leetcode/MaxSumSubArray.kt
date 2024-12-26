package arrays.leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

/*
    Kadane's algorithm, O(N)
*/
class MaxSumSubArray {

    fun find(array: IntArray): Int {
        var currSum = 0
        var maxSum = Int.MIN_VALUE
        for (i in array.indices) {
            currSum = currSum.plus(array[i])
            maxSum = if (currSum > maxSum)
                currSum
            else
                maxSum
            currSum = if (currSum < 0)
                0
            else
                currSum
        }
        return maxSum
    }

    @Test
    fun `2 -3 10 -9 16 1 -8`() {
        val arr = intArrayOf(2, -3, 10, -9, 16, 1, -8)
        val maxSum = MaxSumSubArray().find(arr)
        assertEquals(18, maxSum)
    }
}
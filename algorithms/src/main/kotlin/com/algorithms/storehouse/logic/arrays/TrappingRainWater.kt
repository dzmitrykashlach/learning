package com.algorithms.storehouse.logic.arrays

// https://www.geeksforgeeks.org/trapping-rain-water/
class TrappingRainWater {
    fun maxWater(arr: IntArray, n: Int): Int {
        // To store the maximum water
        // that can be stored
        var res = 0

        // For every element of the array
        // except first and last element
        for (i in 1 until n - 1) {

            // Find maximum element on its left
            var left = arr[i]
            for (j in 0 until i) {
                left = Math.max(left, arr[j])
            }

            // Find maximum element on its right
            var right = arr[i]
            for (j in i + 1 until n) {
                right = Math.max(right, arr[j])
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i]
        }
        return res
    }

}
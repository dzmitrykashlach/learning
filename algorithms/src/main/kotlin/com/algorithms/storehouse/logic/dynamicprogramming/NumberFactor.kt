package com.algorithms.storehouse.logic.dynamicprogramming

class NumberFactor(

) {
    private lateinit var dp: IntArray

    fun combinationsTopDown(n: Int): Int {
        if (!this::dp.isInitialized) {
            dp = IntArray(n) { 0 }
        }
        if (n in 0..2) {
            return 1
        }
        if (n == 3) {
            return 2

        }
        if (dp[n - 1] == 0) {
            dp[n - 1] = combinationsTopDown(n - 1) + combinationsTopDown(n - 3) + combinationsTopDown(n - 4)
        }

        return dp[n - 1]
    }

    fun combinationsBottomUp(n: Int): Int {
        if (n < 3) {
            return 1
        }
        if (n == 3) {
            return 2
        }
        if (!this::dp.isInitialized) {
            dp = IntArray(n + 1) { 0 }
        }

        for (i in 0..2) {
            dp[i] = 1
        }
        dp[3] = 2
        for (i in 4..n) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4]
        }
        return dp[n]
    }
}

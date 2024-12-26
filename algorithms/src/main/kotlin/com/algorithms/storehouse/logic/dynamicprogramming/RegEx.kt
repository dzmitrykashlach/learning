package com.algorithms.storehouse.logic.dynamicprogramming

class RegEx(
    val p: String
) {
    var dp = emptyArray<BooleanArray>()

    fun match(
        s: String,
    ): Boolean {
        val rows = s.length + 1
        val columns = p.length + 1
        if (rows == 0 && columns == 0) {
            return true
        }
        if (columns == 0) {
            return false
        }

        dp = Array(rows) { BooleanArray(columns) }
        dp[0][0] = true
        // Deals with patterns with *
        for (i in 2 until columns) {
            if (p[i - 1] == '*') {
                dp[0][i] = true
            }
        }
        // For remaining characters
        for (i in 1 until rows) {
            for (j in 1 until columns) {
                if (s[i - 1] == p[j - 1]
                    || p[j - 1] == '.'
                ) {
                    dp[i][j] = dp[i - 1][j - 1]
                }
                else if (j > 1 && p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2]
                    if (p[j - 2] == '.'
                        || p[j - 2]
                        == s[i - 1]
                    ) {
                        dp[i][j] = dp[i][j] or dp[i - 1][j]
                    }
                }
            }
        }

        return dp[rows - 1][columns - 1]
    }
}
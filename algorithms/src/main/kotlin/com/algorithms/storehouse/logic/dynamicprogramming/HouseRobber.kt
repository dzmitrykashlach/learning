package com.algorithms.storehouse.logic.dynamicprogramming

class HouseRobber {

    fun calculate(houses: IntArray, currentHouse: Int): Int {
        val dp = IntArray(houses.size + 2) { 0 }
        for (i in houses.size - 1 downTo 0) {
            dp[i] = maxOf(houses[i] + dp[i + 2], dp[i + 1])
        }
        return dp[currentHouse]
    }
}
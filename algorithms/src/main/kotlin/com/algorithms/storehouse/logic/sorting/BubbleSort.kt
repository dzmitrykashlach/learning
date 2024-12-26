package com.algorithms.storehouse.logic.sorting

class BubbleSort {
        fun perform(input: IntArray): IntArray {
        var cyclesCount = 0
        while (true) {
            var sorted = true
            for (i in 0 until input.size - 1) {
                if (input[i] > input[i + 1]) {
                    sorted = false
                    val temp = input[i]
                    input[i] = input[i + 1]
                    input[i + 1] = temp
                }
            }
            cyclesCount++
            if (sorted) {
                break
            }
        }
        println("Number of sorting cycles = $cyclesCount")
        return input
    }
}
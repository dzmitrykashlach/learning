package com.algorithms.storehouse.logic.sorting

class QuickSort(private val input: IntArray) {
    fun perform(start: Int, end: Int): IntArray {
        if (start < end) {
            val pivot = processPartition(start, end)
            perform(start, pivot - 1)
            perform(pivot + 1, end)
        }
        return input
    }

    fun swapValues(index1: Int, index2: Int) {
        val temp = input[index2]
        input[index2] = input[index1]
        input[index1] = temp
    }

    fun processPartition(start: Int, end: Int): Int {
        var i = start - 1
        for (j in start..end) {
            if (input[j] <= input[end]) {
                i++
                swapValues(i, j)
            }
        }
        return i
    }
}
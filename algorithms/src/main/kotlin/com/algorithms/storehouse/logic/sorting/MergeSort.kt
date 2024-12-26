package com.algorithms.storehouse.logic.sorting

import com.algorithms.storehouse.logic.arrays.MergeArrays

class MergeSort {

    fun perform(arr: IntArray): IntArray {
        if (arr.size < 2) return arr
        if (arr.size > 2) {
            val middle = arr.size / 2
            val left = perform(arr.sliceArray(0 until middle))
            val right = perform(arr.sliceArray(middle until arr.size))
            return MergeArrays(left, right).perform()
        }
        if (arr[0] > arr[1]) {
            arr[0] = arr[1].also { arr[1] = arr[0] }
        }
        return arr
    }
}
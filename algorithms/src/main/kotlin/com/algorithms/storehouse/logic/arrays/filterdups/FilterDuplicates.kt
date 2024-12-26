package com.algorithms.storehouse.logic.arrays.filterdups

class FilterDuplicates {
    fun execute(array: Array<Int>): Array<Int> {
        val n = array.size
        if (n == 0 || n == 1) {
            return array
        }
        var uniquePointer = 0 //points to unique elements during
        for (i in 0 until n - 1) {
            if (array[i] != array[i + 1]) { //if next element is not equal to current
                array[uniquePointer] = array[i] // put current element to j position
                uniquePointer++
            }
        }
        array[uniquePointer] = array[n - 1] //  put uniquePointer on the last unique element
        return array
    }

}
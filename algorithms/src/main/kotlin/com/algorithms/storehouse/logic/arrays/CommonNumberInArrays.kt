package com.algorithms.storehouse.logic.arrays

class CommonNumberInArrays {
    fun commonNumber(
        arr1: IntArray,
        arr2: IntArray,
        arr3: IntArray,
    ): Int {
        var a1 = 0
        var a2 = 0
        var a3 = 0
        if (arr1.isEmpty() || arr2.isEmpty() || arr3.isEmpty()) return Int.MIN_VALUE
        while (a1 < arr1.size) {
            if (arr1[a1] < arr2[a2]) {
                a1++
                continue
            }
            if (arr1[a1] == arr2[a2]) {
                if (arr2[a2] == arr3[a3]) {
                    return arr2[a2]
                }
                if (arr2[a2] > arr3[a3]) {
//                        move a3 until arr2[a2]<=arr3[a3]
                    while (arr2[a2] > arr3[a3]) {
                        a3++
                    }
                }
                if (arr2[a2] < arr3[a3]) {
//                        move a2 until arr2[a2]>=arr3[a3]
                    while (arr2[a2] < arr3[a3]) {
                        if (a2 < arr2.size - 1) {
                            a2++
                        } else {
                            return Int.MIN_VALUE
                        }
                    }
                }
            } else {
                if (a2 < arr2.size - 1) {
                    a2++
                } else {
                    return Int.MIN_VALUE
                }
            }
        }
        return Int.MIN_VALUE
    }
}
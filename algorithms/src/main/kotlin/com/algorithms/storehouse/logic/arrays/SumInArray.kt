package com.algorithms.storehouse.logic.arrays

class SumInArray {

    fun find(arr: IntArray, sum: Int): Pair<Int, Int> {
        var fp = 0
        var bp = 0
        var resSum = arr[fp]
        while (fp < arr.size - 1 && bp < arr.size - 1) {
            if (resSum < sum) {
                fp++
                resSum = resSum.plus(arr[fp])
            }
            if (resSum == sum) {
                return Pair(fp, bp)
            }
            if (resSum > sum) {
                resSum = resSum.minus(arr[bp])
                bp++
                if (resSum == sum) {
                    return Pair(fp, bp)
                }
            }
        }
        return Pair(-1, -1)
    }
}
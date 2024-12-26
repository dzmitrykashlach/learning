package com.algorithms.storehouse.logic.arrays

class MergeArrays(private val input1: IntArray, private val input2: IntArray) {
    fun perform(): IntArray {
        var input1Ind = 0
        var input2Ind = 0
        val result = IntArray(input1.size + input2.size)
        for (i in result.indices) {
//            if input1Ind is out of input1.size - proceed with input2
            if (input1Ind >= input1.size) {
                result[i] = input2[input2Ind]
                input2Ind++
                continue
            }
//            if input2Ind is out of input2.size - proceed with input1
            if (input2Ind >= input2.size) {
                result[i] = input1[input1Ind]
                input1Ind++
                continue
            }

            if (input1[input1Ind] < input2[input2Ind]) {
                result[i] = input1[input1Ind]
                input1Ind++
            } else {
                result[i] = input2[input2Ind]
                input2Ind++
            }
        }
        return result
    }
}
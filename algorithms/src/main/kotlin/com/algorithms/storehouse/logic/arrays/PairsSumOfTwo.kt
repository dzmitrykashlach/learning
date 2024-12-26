package com.algorithms.storehouse.logic.arrays

/*
https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5106500#overview
 */
class PairsSumOfTwo {
    fun find(input: IntArray, target: Int): HashMap<Int, Int> {
        val pairs = HashMap<Int, Int>()
        for (i in 0 until input.size - 1) {
            if (input[i] <= target) {
                for (j in i + 1 until input.size - 1) {
                    if (input[j] + input[i] == target) {
                        pairs[input[i]] = input[j]
                    }
                }
            }
        }
        return pairs
    }

}
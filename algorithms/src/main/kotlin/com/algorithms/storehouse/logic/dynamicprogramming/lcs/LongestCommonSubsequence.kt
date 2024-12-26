package com.algorithms.storehouse.logic.dynamicprogramming.lcs

class LongestCommonSubsequence {

    fun lcs(s1: String, s2: String, index1: Int, index2: Int): String {
        if (index1 == s1.length || index2 == s2.length) {
            return ""
        }
        return if (s1[index1] == s2[index2]) {
            s1[index1] + lcs(s1, s2, index1 + 1, index2 + 1)
        } else {
            val op1 = lcs(s1, s2, index1, index2 + 1)
            val op2 = lcs(s1, s2, index1 + 1, index2)
            if (op1.length > op2.length) {
                op1
            } else {
                op2
            }
        }
    }
}
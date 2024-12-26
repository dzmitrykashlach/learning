package com.algorithms.storehouse.logic.strings

class LongestPalindrome() {

    fun findLength(str: String): Int {
        var max = 0
        for (i in 0..str.length - 2) {
            for (j in str.length downTo i + 1) {
                if (isPalindrome(str.substring(i, j)) && (j - i > max)) {
                    max = j-i
                }
            }
        }
        return max
    }

    fun isPalindrome(s: String): Boolean {
        if (s.length == 1) return true
        return if (s[0] == s[s.length - 1]) {
            isPalindrome(s.substring(1, s.length - 1))
        } else false
    }

}
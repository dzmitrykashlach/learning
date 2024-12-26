package com.algorithms.storehouse.logic.strings

/*
https://leetcode.com/problems/longest-valid-parentheses/
 */
class LongestValidParentheses {
    private val LEFT_BRACKET = '('
    private val RIGHT_BRACKET = ')'
    fun longestValidParentheses(s: String): Int {
        var maxChain = 0
        var currentChain = 0
        val input = s.toCharArray()
        val length = s.length - 1
        var index = 0
        while (index < length) {
            if (((input[index] == LEFT_BRACKET) && (input[index + 1] == LEFT_BRACKET))
                or ((input[index] == RIGHT_BRACKET) && (input[index + 1] == RIGHT_BRACKET))
            ) {
                currentChain = 0
                index++
                continue
            }
            if ((input[index] == LEFT_BRACKET) and (input[index + 1] == RIGHT_BRACKET)) {
                currentChain += 2
                index++
            }
            maxChain = Math.max(currentChain, maxChain)
            index++
        }
        return maxChain
    }
}
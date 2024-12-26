package com.algorithms.storehouse.logic.strings

class TwoStringsShuffle {
    /*
    You are given 3 strings: first,  second, and third.
    Third String is said to be a shuffle of first and second if it can be formed by
    interleaving the characters of first and second String
    in a way that maintains the left to the right ordering
    of the characters from each string.

    For example, given first = "abc" and second = "def",  third = "dabecf"
    is a valid shuffle since it preserves the character ordering of the two strings.
    So, given these 3 strings write a function that detects whether the third String
    is a valid shuffle of first and second String.
     */
    fun check(s1: String, s2: String, s3: String): Boolean {
        if (s3.length != s1.length + s2.length) return false
        var s1p = 0
        var s2p = 0
        var s3p = 0

        while (s3p < s3.length - 1) {
            when(s3[s3p]){
                s1[s1p] -> s1p++
                s2[s2p] -> s2p++
                else -> return false
            }
            s3p++
        }
        return true
    }
}
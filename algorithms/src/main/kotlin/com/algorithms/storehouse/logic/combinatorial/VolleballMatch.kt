package com.algorithms.storehouse.logic.combinatorial

import kotlin.math.pow


/*
https://www.hackerrank.com/contests/w1/challenges/volleyball-match
https://thedataincubator.github.io/coding-challenges/challenges/volleyball-match.html
 */
class VolleballMatch {

    /*
    https://mathworld.wolfram.com/BinomialCoefficient.html
    https://www.w3resource.com/java-exercises/math/java-math-exercise-24.php
     */
    fun nCr(n: Int, r: Int): Double {
        if (r > n - r) {
            n - r
        }
        var binom: Long = 1
        for (i in 1..r) {
            binom = binom * (n + 1 - i) / i
        }
        return binom.toDouble()
    }

    fun getScoresCombinations(a: Int, b: Int):Double{
        var a = a
        var b = b
        if (a < b) {
//            we're swapping variables without using temporary variable
            a -= b
            b += a
            a = b - a
        }
//        3 cases of invalid scores
        if (a < 25){
            throw RuntimeException("Please, provide valid score.")
        }
        if (a == 25 && b > 23){
            throw RuntimeException("Please, provide valid score.")
        }
        if (a > 25 && a - b != 2){
            throw RuntimeException("Please, provide valid score.")
        }
//        # base case, team A wins 25:b with b <= 23
        if (a == 25){
            return nCr(24 + b, 24)

        }

//        Math.pow(2.0,b-24.0)
//        # last case, team A wins a:b with a > 25 and a-b == 2
        return nCr(48, 24) * 2.0.pow(b - 24.0)

    }


}
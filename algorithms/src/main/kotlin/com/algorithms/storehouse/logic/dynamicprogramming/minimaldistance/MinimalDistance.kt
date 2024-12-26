package com.algorithms.storehouse.logic.dynamicprogramming.minimaldistance

import java.util.*

class MinimalDistance(
    val word1: String,
    val word2: String
) {
    /*
       @Dzmitry Kashlach:
          5: cumbersome implementation
        Suggested improvement:
          - use System.arraycopy() as more readable option
        */
    private fun insertIntoArray(arr: CharArray, index: Int, newItem: Char): CharArray {
        val result = CharArray(arr.size + 1)
        System.arraycopy(arr, 0, result, 0, index)
        result[index] = newItem
        System.arraycopy(arr, index, result, index + 1, result.size - index - 1)
        return result
    }

    fun calculate(): Int {
        val word1Len = word1.length
        val word2Len = word2.length
        val dp = Array(word1Len + 1) { IntArray(word2Len + 1) }
        for (i in 0..word1Len) {
            dp[i][0] = i
        }
        for (j in 0..word2Len) {
            dp[0][j] = j
        }
        for (i in 1..word1Len) {
            for (j in 1..word2Len) {
                val deletion = dp[i][j - 1] + 1
                val insertion = dp[i - 1][j] + 1
                val substitution = dp[i - 1][j - 1] + if (word1[i - 1] == word2[j - 1]) 0 else 1
                dp[i][j] = Math.min(Math.min(deletion, insertion), substitution)
            }
        }
        var distance = dp[word1Len][word2Len]


        /*
        @Dzmitry Kashlach:
           4: unclear variable names
         Suggested improvement:
           - rename variables
         */
        var word1Ind = word1Len
        var word2Ind = word2Len
        /*
        @Dzmitry Kashlach:
           3: char instead of String
         Suggested improvement:
           - Although in java 9+ replacing String with char shouldn't give memory profit,
           for me it looks a bit more understandable to represent word as char[] rather than String[]
           Plus printing out word as char[] gives more clarity about processing order
         */
        var curWord = word2.toCharArray()
        println(Arrays.toString(curWord))
        /*
  @Dzmitry Kashlach:
     7: If according to requirements we just need to return number of steps,
     we can drop while(distance > 0) and return dp[word1Len][word2Len].
     Time complexity will still be O(wordLen1 x wordLen2)
       */while (distance > 0) {
            val deletion = dp[word1Ind][word2Ind - 1]
            /*
  @Dzmitry Kashlach:
     6: algorithm is throwing java.lang.ArrayIndexOutOfBoundsException in cases when
     we need to do insertions and first characters are not equal, e.g.
     when word1 = "zt" & word2 = "ewy"
   Suggested improvement:
       dp[word1Ind>0?word1Ind - 1:1][word2Ind - 1] instead of dp[word1Ind - 1][word2Ind - 1]
       for lines 99 & 100
       */
            val insertion = dp[if (word1Ind > 0) word1Ind - 1 else 1][word2Ind]
            val substitution = dp[if (word1Ind > 0) word1Ind - 1 else 1][word2Ind - 1]
            if (substitution < distance) {
                curWord[word2Ind - 1] = word1[word1Ind - 1]
                word1Ind--
                word2Ind--
                distance = substitution
                println(Arrays.toString(curWord))
            } else if (deletion < distance) {
                curWord[word2Ind - 1] = Character.MIN_VALUE
                word2Ind--
                distance = deletion
                println(Arrays.toString(curWord))
            } else if (insertion < distance) {
                curWord = insertIntoArray(curWord, word2Ind, word1[word1Ind - 1])
                word1Ind--
                distance = insertion
                println(Arrays.toString(curWord))
            } else {
                word1Ind--
                word2Ind--
            }
        }
        /*
        @Dzmitry Kashlach:
           2: void method is not convenient for unit-test
         Suggested improvement:
             added return value;
         */println(dp[word1Len][word2Len])
        return dp[word1Len][word2Len]
    }
}

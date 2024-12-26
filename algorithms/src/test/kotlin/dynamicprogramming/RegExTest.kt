package dynamicprogramming

import com.algorithms.storehouse.logic.dynamicprogramming.RegEx
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/*
https://leetcode.com/problems/regular-expression-matching/description/

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
 */
class RegExTest {

    @Test
    fun no_wildcards(){
        val re = RegEx("a")
        assertFalse { re.match("aa") }
    }

    @Test
    fun two_wildcards(){
        val re = RegEx("a*b*")
        assertTrue { re.match("aabb") }
    }

    @Test
    fun any(){
        val re = RegEx(".*")
        assertTrue { re.match("ab") }
    }
}
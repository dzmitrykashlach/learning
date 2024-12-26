package dynamicprogramming.lcs

import com.algorithms.storehouse.logic.dynamicprogramming.lcs.LongestCommonSubsequence
import kotlin.test.assertEquals
import kotlin.test.Test

class LongestCommonSubsequenceTest {

    @Test
    fun lcpTest() {
        val s1 = "elephant"
        val s2 = "erepat"
        val lcs = LongestCommonSubsequence()
        val result = lcs.lcs(s1, s2, 0, 0)
        assertEquals("eepat", result)
    }
}
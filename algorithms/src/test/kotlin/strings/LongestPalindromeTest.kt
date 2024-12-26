package strings

import com.algorithms.storehouse.logic.strings.LongestPalindrome
import kotlin.test.Test
import kotlin.test.assertEquals
class LongestPalindromeTest {

    @Test
    fun findLongestPalindrome(){
        val lp = LongestPalindrome()
        assertEquals(5,lp.findLength("VBARABAC"))
        assertEquals(7,lp.findLength("ABARABAC"))
        assertEquals(3,lp.findLength("ABA"))
    }

    @Test
    fun isPalindrome(){
        var lp = LongestPalindrome()
        assertEquals(true,lp.isPalindrome("ARA"))
        lp = LongestPalindrome()
        assertEquals(true,lp.isPalindrome("CABARABAC"))
        lp = LongestPalindrome()
        assertEquals(false,lp.isPalindrome("CABARABACz"))
    }
}
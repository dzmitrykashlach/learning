package strings

import com.algorithms.storehouse.logic.strings.LongestValidParentheses
import kotlin.test.assertEquals
import kotlin.test.Test

class LongestValidParenthesesTest {
    @Test
    fun twoPairs() {
        val longestValidParentheses = LongestValidParentheses()
        assertEquals(4, longestValidParentheses.longestValidParentheses("(()())))))(").toLong())
    }

    @Test
    fun twoPairsPlusOne() {
        val longestValidParentheses = LongestValidParentheses()
        assertEquals(4, longestValidParentheses.longestValidParentheses("(()())))())(").toLong())
    }

    @Test
    fun threePairsPlusFour() {
        val longestValidParentheses = LongestValidParentheses()
        assertEquals(8, longestValidParentheses.longestValidParentheses("()()())))()()()()").toLong())
    }

    @Test
    fun onePairPlusTwo() {
        val longestValidParentheses = LongestValidParentheses()
        assertEquals(4, longestValidParentheses.longestValidParentheses("(())))()())(").toLong())
    }

    @Test
    fun onePairInTheBeginning() {
        val longestValidParentheses = LongestValidParentheses()
        assertEquals(2, longestValidParentheses.longestValidParentheses("())))").toLong())
    }

    @Test
    fun onePairInTheEnd() {
        val longestValidParentheses = LongestValidParentheses()
        assertEquals(2, longestValidParentheses.longestValidParentheses(")))()").toLong())
    }

    @Test
    fun twoPairInTheMiddle() {
        val longestValidParentheses = LongestValidParentheses()
        assertEquals(4, longestValidParentheses.longestValidParentheses(")()())").toLong())
    }
}
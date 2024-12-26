package strings

import com.algorithms.storehouse.logic.strings.Anagrams
import kotlin.test.assertTrue
import kotlin.test.Test

class AnagramsTest {
        @Test
        fun anagramsTest() {
            val a = Anagrams("abcndhfg", "ndhfgabc")
            assertTrue(a.check())
        }
}
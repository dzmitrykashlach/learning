package strings

import com.algorithms.storehouse.logic.strings.TwoStringsShuffle
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TwoStringsShuffleTest {

    @Test
    fun `Should detect valid shuffle`() {
        val s1 = "abc"
        val s2 = "def"
        val s3 = "dabecf"
        assertTrue { TwoStringsShuffle().check(s1,s2,s3) }

    }

    @Test
    fun `Should get false if shuffle is not valid`() {
        var s1 = "abc"
        var s2 = "def"
        var s3 = "wabecf"
        assertFalse { TwoStringsShuffle().check(s1,s2,s3) }

        s3 = "dabhcf"
        assertFalse { TwoStringsShuffle().check(s1,s2,s3) }
    }
}
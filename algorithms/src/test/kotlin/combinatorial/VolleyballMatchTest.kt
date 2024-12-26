package combinatorial

import com.algorithms.storehouse.logic.combinatorial.VolleballMatch
import kotlin.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertFailsWith

class VolleyballMatchTest {

    @Test
    fun volleyBallMatchTest_25_3() {
        assertEquals(2925.0, VolleballMatch().getScoresCombinations(3, 25))
    }

    @Test
    fun volleyBallMatchTest_24_26() {
        assertEquals(3.22476036831E13, VolleballMatch().getScoresCombinations(24, 26))

    }

    @Test
    fun volleyBallMatchTest_invalidScore() {
        assertFailsWith<RuntimeException>(
            block = {
                VolleballMatch().getScoresCombinations(3, 24)
            }
        )
        assertFailsWith<RuntimeException>(
            block = {
                VolleballMatch().getScoresCombinations(24, 25)
            }
        )
        assertFailsWith<RuntimeException>(
            block = {
                VolleballMatch().getScoresCombinations(26, 23)
            }
        )
    }


    @Test
    fun binomialCoefficientsTest() {
        val vm = VolleballMatch()
        assertEquals(10.0, vm.nCr(5, 3))
    }
}
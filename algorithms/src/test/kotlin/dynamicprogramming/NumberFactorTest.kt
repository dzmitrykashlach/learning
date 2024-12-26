package dynamicprogramming

import com.algorithms.storehouse.logic.dynamicprogramming.NumberFactor
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberFactorTest {

    @Test
    fun numberFactorTopDown(){

        for (n in 0..2) {
            assertEquals(1, NumberFactor().combinationsTopDown(n))
        }
        assertEquals(2, NumberFactor().combinationsBottomUp(3))
        assertEquals(4, NumberFactor().combinationsTopDown(4))
        assertEquals(6, NumberFactor().combinationsTopDown(5))
    }

    @Test
    fun numberFactorBottomUp(){

        for (n in 1..2) {
            assertEquals(1, NumberFactor().combinationsBottomUp(n))
        }
        assertEquals(2, NumberFactor().combinationsBottomUp(3))
        assertEquals(4, NumberFactor().combinationsBottomUp(4))
        assertEquals(6, NumberFactor().combinationsBottomUp(5))
    }
}
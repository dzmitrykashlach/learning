package bitwise

import kotlin.test.Test
import kotlin.test.assertEquals

class PowerSetTest {

    @Test
    fun powerSetTestRecursive() {
        var ps = PowerSet(intArrayOf(1, 2, 4))
        ps.generateRecursive(0, booleanArrayOf(false, false, false))
        assertEquals(8, ps.subSets.size)
        assertEquals(2, ps.subSets[5][1])

        ps = PowerSet(intArrayOf(1, 2, 4, 6, 3))
        ps.generateRecursive(0, booleanArrayOf(false, false, false,false,false))
        assertEquals(32, ps.subSets.size)
        assertEquals(6, ps.subSets[21][3])
    }

    @Test
    fun powerSetTestBinary() {
        var ps = PowerSet(intArrayOf(1, 2, 4))
        ps.generateBinary()
        assertEquals(8, ps.subSets.size)
        assertEquals(4, ps.subSets[5][2])

        ps = PowerSet(intArrayOf(1, 2, 4, 6, 3))
        ps.generateBinary()
        assertEquals(32, ps.subSets.size)
        assertEquals(4, ps.subSets[21][2])
    }

}
package arrays

import com.algorithms.storehouse.logic.streaming.parkingroof.ParkingRoof
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.Test

class ParkingRoofTest {
    @Test
    fun test63() {
        val parking = intArrayOf(0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1)
        val parkingRoof = ParkingRoof(parking)
        val roofOpt = parkingRoof.calculateShortestRoof(3)
        val (key, value) = roofOpt.orElseThrow()
        assertEquals(6, (key).toLong())
        assertEquals(3, (value).toLong())
    }

    @Test
    fun test14() {
        val parking = intArrayOf(0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0)
        val parkingRoof = ParkingRoof(parking)
        val roofOpt = parkingRoof.calculateShortestRoof(4)
        val (key, value) = roofOpt.orElseThrow()
        assertEquals(1, (key).toLong())
        assertTrue(value >= 4)
    }
}
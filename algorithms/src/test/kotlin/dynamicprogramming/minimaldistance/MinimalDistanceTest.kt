package dynamicprogramming.minimaldistance

import com.algorithms.storehouse.logic.dynamicprogramming.minimaldistance.MinimalDistance
import kotlin.test.assertEquals
import kotlin.test.Test

class MinimalDistanceTest {
    @Test
    fun minimaldistanceTestReplace() {
        val minimalDistance = MinimalDistance("elevator", "everest")
        assertEquals(6, minimalDistance.calculate().toLong())
    }

    @Test
    fun minimaldistanceTestReplace0() {
        val minimalDistance = MinimalDistance("elevatourist", "elevatourist")
        assertEquals(0, minimalDistance.calculate().toLong())
    }

    @Test
    fun minimaldistanceTestReplace00() {
        val minimalDistance = MinimalDistance("", "")
        assertEquals(0, minimalDistance.calculate().toLong())
    }

    @Test
    fun minimaldistanceTestInsertFirstChar() {
        val minimalDistance = MinimalDistance("zt", "ewy")
        assertEquals(3, minimalDistance.calculate().toLong())
    }

    @Test
    fun minimaldistanceTestReplace12() {
        val minimalDistance = MinimalDistance("1", "0")
        assertEquals(1, minimalDistance.calculate().toLong())
    }

    @Test
    fun minimaldistanceTestReplace13() {
        val minimalDistance = MinimalDistance("ever", "elle")
        assertEquals(3, minimalDistance.calculate().toLong())
    }

    @Test
    fun minimaldistanceTestReplace1() {
        val minimalDistance = MinimalDistance("elevatourist", "elevatourisz")
        assertEquals(1, minimalDistance.calculate().toLong())
    }

    @Test
    fun minimaldistanceTestInsert() {
        val minimalDistance = MinimalDistance("elevator", "everestutor")
        assertEquals(6, minimalDistance.calculate().toLong())
    }

    @Test
    fun minimaldistanceTestDelete() {
        val minimalDistance = MinimalDistance("elevatourist", "everest")
        assertEquals(7, minimalDistance.calculate().toLong())
    }
}

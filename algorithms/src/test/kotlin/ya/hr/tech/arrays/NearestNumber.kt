package ya.hr.tech.arrays

import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://coderun.yandex.ru/selections/hr-tech-interview/problems/nearest-number
 */

class NearestNumber {
    fun find(elements: IntArray, x: Int): Pair<Int, Int> {
        var diff = Int.MAX_VALUE
        var nearest = elements.first()
        elements.forEach {
            val currentDiff = abs(it - x)
            if (currentDiff < diff || (currentDiff == diff && it < nearest)) {
                nearest = it
                diff = currentDiff
            }
        }
        return diff to nearest
    }
}

class NearestNumberTest {
    @Test
    fun positive() {
        val elements = intArrayOf(1, 435, 7, 9, -4, -56, -100, -394)
        var nearest = NearestNumber().find(elements, -0)
        assertEquals(1, nearest.second)
        nearest = NearestNumber().find(elements, -58)
        assertEquals(-56, nearest.second)
        nearest = NearestNumber().find(elements, -58)
        assertEquals(-56, nearest.second)
        nearest = NearestNumber().find(elements, -5)
        assertEquals(-4, nearest.second)
    }
}
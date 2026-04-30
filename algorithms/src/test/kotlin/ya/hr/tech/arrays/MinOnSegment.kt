package ya.hr.tech.arrays

import kotlin.test.Test
import kotlin.test.assertEquals

/*
https://coderun.yandex.ru/selections/hr-tech-interview/problems/minimum-of-the-segment
 */
class MinOnSegment {
    fun find(elements: IntArray, k: Int): List<Int> {
        var start = 0
        val results = mutableListOf<Int>()
        for (w in k - 1..elements.size - 1) {
            // set window position
            var localMin = Int.MAX_VALUE
            for (e in start..w) {
                if (elements[e] < localMin) {
                    localMin = elements[e]
                }
            }
            start++
            results.add(localMin)
        }
        return results
    }
}

class MinOnSegmentTest {
    @Test
    fun `find returns mins for each window`() {
        var result = MinOnSegment().find(intArrayOf(1, 3, 2, 4, 5, 3, 1), 3)
        assertEquals(listOf(1, 2, 2, 3, 1), result)
        result = MinOnSegment().find(intArrayOf(1), 1)
        assertEquals(listOf(1), result)
    }
}
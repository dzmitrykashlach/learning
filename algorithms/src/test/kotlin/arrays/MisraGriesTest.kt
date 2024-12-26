package arrays

import com.algorithms.storehouse.logic.streaming.MisraGries
import kotlin.test.assertEquals
import kotlin.test.Test

class MisraGriesTest {
    @Test
    fun misraGriesTest() {
        val misraGries = MisraGries()
        val source: List<Int> = ArrayList(mutableListOf(7, 2, 7, 3, 7, 5, 7, 7, 8, 7, 7, 8, 7, 7, 78, 7))
        val result = misraGries.perform(source)
        assertEquals(1, result.keys.size)
        assertEquals(4, result.get(7))
    }
}
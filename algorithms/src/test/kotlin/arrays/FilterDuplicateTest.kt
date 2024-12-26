package arrays

import com.algorithms.storehouse.logic.arrays.filterdups.FilterDuplicates
import kotlin.test.assertEquals
import kotlin.test.Test

class FilterDuplicateTest {

    @Test
    fun filterDuplicateTest(){
        val filterDuplicates = FilterDuplicates()
        val arr = arrayOf(1, 2, 2, 2, 5, 7, 9, 11, 13, 13)
        assertEquals("[1, 2, 5, 7, 9, 11, 13, 11, 13, 13]",
            filterDuplicates.execute(arr).contentDeepToString())
    }
}
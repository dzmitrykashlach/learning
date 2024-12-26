package arrays.leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

class MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val r: MutableList<IntArray> = mutableListOf(intervals[0])
        for (i in 1 until intervals.size) {
            if(intervals[i][0]>r.last()[1]){
                r.add(intervals[i])
            }else{
                r.last()[1] = intervals[i][1]
            }
        }
        return r.toTypedArray()
    }

    @Test
    fun `{{1,3},{2,6},{8,10},{15,18}}`() {
        var intervals: Array<IntArray> = arrayOf (
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 13),
            intArrayOf(11, 18)
        )
        var r = MergeIntervals().merge(intervals)
        assertEquals(2,r.size)
        assertEquals(1,r[0][0])
        assertEquals(6,r[0][1])
        assertEquals(8,r[1][0])
        assertEquals(18,r[1][1])
    }
}
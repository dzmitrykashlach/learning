package arrays

import com.algorithms.storehouse.logic.arrays.PerfectRectangle
import com.algorithms.storehouse.logic.arrays.PerfectRectangle.Rectangle
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/*
https://leetcode.com/problems/perfect-rectangle/
 */
class PerfectRectangleTest {

    @Test
    fun solid_rectangle() {
        /*
        Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]] - true
         */
        val rectangles = arrayListOf(
            Rectangle(Pair(1, 1), Pair(3, 3)),
            Rectangle(Pair(3, 1), Pair(4, 2)),
            Rectangle(Pair(3, 2), Pair(4, 4)),
            Rectangle(Pair(1, 3), Pair(2, 4)),
            Rectangle(Pair(2, 3), Pair(3, 4)),
        )
        val pr = PerfectRectangle()
        assertTrue(pr.isPerfect(rectangles))
    }

    @Test
    fun rectangle_with_a_gap() {
        /*
     Input: rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]] - false
      */
        val rectangles = arrayListOf(
            Rectangle(Pair(1, 1), Pair(2, 3)),
            Rectangle(Pair(1, 3), Pair(2, 4)),
            Rectangle(Pair(3, 1), Pair(4, 2)),
            Rectangle(Pair(3, 2), Pair(4, 4))
        )
        val pr = PerfectRectangle()
        assertFalse(pr.isPerfect(rectangles))
    }

    @Test
    fun overlapping_rectangles() {
        /*
Input: rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]] - false
        */
        val rectangles = arrayListOf(
            Rectangle(Pair(1, 1), Pair(3, 3)),
            Rectangle(Pair(3, 1), Pair(4, 2)),
            Rectangle(Pair(1, 3), Pair(2, 4)),
            Rectangle(Pair(2, 2), Pair(4, 4))
        )
        val pr = PerfectRectangle()
        assertFalse(pr.isPerfect(rectangles))
    }
}
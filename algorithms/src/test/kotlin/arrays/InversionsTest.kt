package arrays

import com.algorithms.storehouse.logic.arrays.Inversions
import kotlin.test.Test
import kotlin.test.assertEquals

class InversionsTest {
    @Test
    fun `Should find 0 inversions`() {
        val inversions = Inversions()
        val array = intArrayOf(1, 4, 5, 6, 20)
        assertEquals(0, inversions.avlTreeCount(array))
    }

    /*
Input: arr[] = {5, 20, 6}
Output: 1
(20, 6).
*/
    @Test
    fun `Should find 1 inversion`() {
        val inversions = Inversions()
        val array = intArrayOf(5, 20, 6)
        assertEquals(1, inversions.avlTreeCount(array))
    }

    /*
    Input: arr[] = {20, 5, 6}
    Output: 2
    (20, 5), (20, 6).
    */
    @Test
    fun `Should find 2 inversions`() {
        val inversions = Inversions()
        val array = intArrayOf(20, 5, 6)
        assertEquals(2, inversions.avlTreeCount(array))
    }

    /*
    Input: arr[] = {20, 6, 5}
    Output: 3
    (20, 6), (20, 5), (6, 5).
    */
    @Test
    fun `Should find 3 inversions`() {
        val inversions = Inversions()
        val array = intArrayOf(20, 6, 5)
        assertEquals(3, inversions.avlTreeCount(array))
    }

    /*
    Input: arr[] = {20, 1, 6, 5}
    Output: 4
    (20, 6), (20, 5), (6, 5), (20, 1).
    */
    @Test
    fun `Should find 4 inversions`() {
        val inversions = Inversions()
        val array = intArrayOf(20, 1, 6, 5)
        assertEquals(4, inversions.avlTreeCount(array))
//        assertEquals(3, inversions.avlTreeCount(array))
        println()
    }

    /*
    Input: arr[] = {1, 20, 6, 4, 5}
    Output: 5
    (20, 6), (20, 4), (20, 5), (6, 4), (6, 5).
    */
    @Test
    fun `Should find 5 inversions`() {
        val inversions = Inversions()
        val array = intArrayOf(1, 20, 6, 4, 5)
        assertEquals(5, inversions.avlTreeCount(array))
    }

    /*
    Input: arr[] = {1, 20, 6, 5, 4}
    Output: 6
    (20, 6), (20, 4), (20, 5), (6, 4), (6, 5), (5,4).
    */
    @Test
    fun `Should find 6 inversions`() {
        val inversions = Inversions()
        val array = intArrayOf(1, 20, 6, 5, 4)
        assertEquals(6, inversions.avlTreeCount(array))
    }

}

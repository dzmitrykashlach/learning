package arrays

import com.algorithms.storehouse.logic.arrays.rotatematrix.RotateMatrix
import kotlin.test.assertEquals
import kotlin.test.Test
import java.util.*

class MatrixRotate {

    @Test
    fun matrixRotate() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(7, 8, 9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16, 17, 18),
            intArrayOf(19, 20, 21, 22, 23, 24),
            intArrayOf(25, 26, 27, 28, 29, 30),
            intArrayOf(31, 32, 33, 34, 35, 36)
        )
        val rm = RotateMatrix()
        rm.perform(matrix)
        assertEquals(
            "[[31, 25, 19, 13, 7, 1], " +
                    "[32, 26, 20, 14, 8, 2], " +
                    "[33, 27, 21, 15, 9, 3]," +
                    " [34, 28, 22, 16, 10, 4]," +
                    " [35, 29, 23, 17, 11, 5]," +
                    " [36, 30, 24, 18, 12, 6]]",
            Arrays.deepToString(matrix)
        )
    }
}
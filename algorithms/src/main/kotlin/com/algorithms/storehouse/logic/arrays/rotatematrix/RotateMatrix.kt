package com.algorithms.storehouse.logic.arrays.rotatematrix


/*
Time complexity = O(N), N = n*n;
Space complexity = O(1);
 */
class RotateMatrix {
    fun perform(matrix: Array<IntArray>): Boolean {
        if (matrix.size == 0 || matrix.size != matrix[0].size) return false
        val n = matrix.size
        for (layer in 0 until n / 2) {
            //  we're defining layer of matrix for modification(moving from borders to the center)
//            element to start with
            val last = n - 1 - layer
            for (i in layer until last) {
//                offset = distance from last element in row/column
                val offset = i - layer
                //                we store upper-left element of layer to temp variable
                val top = matrix[layer][i]
                //                bottom-left element goes to upper-left
                matrix[layer][i] = matrix[last - offset][layer]
                //               bottom-right element goes to bottom-left
                matrix[last - offset][layer] = matrix[last][last - offset]
                //                upper-right element goes to bottom-right
                matrix[last][last - offset] = matrix[i][last]
                //                upper-right element equals top(upper-left)
                matrix[i][last] = top
            }
        }
        return true
    }


}
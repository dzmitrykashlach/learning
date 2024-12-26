package com.algorithms.storehouse.logic.arrays

// https://www.geeksforgeeks.org/find-number-of-islands/
class NumberOfIslands {
    var ROWS = 0
    var COLS = 0
    fun numIslands(M: Array<IntArray>): Int {
        val ROW = M.size
        val COL = M[0].size
        var count = 0
        for (i in 0 until ROW) {
            for (j in 0 until COL) {
                if (M[i][j] == 1) {
                    M[i][j] = 0
                    count++
                    DFS(M, i + 1, j, ROW, COL) //right side traversal
                    DFS(M, i - 1, j, ROW, COL) //left side traversal
                    DFS(M, i, j + 1, ROW, COL) //upward side traversal
                    DFS(M, i, j - 1, ROW, COL) //downward side traversal
                    DFS(M, i + 1, j + 1, ROW, COL) //upward-right side traversal
                    DFS(M, i - 1, j - 1, ROW, COL) //downward-left side traversal
                    DFS(M, i + 1, j - 1, ROW, COL) //downward-right side traversal
                    DFS(M, i - 1, j + 1, ROW, COL) //upward-left side traversal
                }
            }
        }
        return count
    }

    fun DFS(M: Array<IntArray>, i: Int, j: Int, ROW: Int, COL: Int) {
        // Base condition
        // if i less than 0 or j less than 0 or i greater than ROW-1 or j greater than COL- or if M[i][j] != 1 then we will simply return
        if (i < 0 || j < 0 || i > ROW - 1 || j > COL - 1 || M[i][j] != 1) {
            return
        }
        if (M[i][j] == 1) {
            M[i][j] = 0
            DFS(M, i + 1, j, ROW, COL) //right side traversal
            DFS(M, i - 1, j, ROW, COL) //left side traversal
            DFS(M, i, j + 1, ROW, COL) //upward side traversal
            DFS(M, i, j - 1, ROW, COL) //downward side traversal
            DFS(M, i + 1, j + 1, ROW, COL) //upward-right side traversal
            DFS(M, i - 1, j - 1, ROW, COL) //downward-left side traversal
            DFS(M, i + 1, j - 1, ROW, COL) //downward-right side traversal
            DFS(M, i - 1, j + 1, ROW, COL) //upward-left side traversal
        }
    }


}
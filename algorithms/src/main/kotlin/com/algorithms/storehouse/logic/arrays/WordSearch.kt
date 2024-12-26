package com.algorithms.storehouse.logic.arrays

class WordSearch(// Rows and columns in the given grid
    private val rows: Int, private val columns: Int,
    // For searching in all 4 direction
    var x: IntArray = intArrayOf(-1, 0, 0, 1),
    var y: IntArray = intArrayOf(0, -1, 1, 0)
) {
    // searches in 4 directions, no dioganals
    fun lookup(
        grid: Array<CharArray>, row: Int,
        col: Int, word: String
    ): Boolean {
        // stop in case if first char of word doesn't match given position
        if (grid[row][col] != word[0]) return false
        val len = word.length

        // Search word in 4 directions
        for (dir in 0..3) {
            // Initialize starting position for given direction
            var k: Int
            var rd = row + x[dir]
            var cd = col + y[dir]

            // First character is already checked,
            // check remaining letters
            k = 1
            while (k < len) {

                // break if out-of-bound
                if (rd >= rows || rd < 0 || cd >= columns || cd < 0) break

                // break if no match
                if (grid[rd][cd] != word[k]) break

                // move further in this direction
                rd += x[dir]
                cd += y[dir]
                k++
            }

            // if all chars matched, k should be equal to lenth of word
            if (k == len) return true
        }
        return false
    }

    // Searches given word in a given
    // matrix in all 4 directions
    fun wordSearch(
        grid: Array<CharArray>,
        word: String
    ) {
        // Consider every point as starting and search given word
        for (row in 0 until rows) {
            for (col in 0 until columns) {
                if (grid[row][col] == word[0] &&
                    lookup(grid, row, col, word)
                ) println(
                    "Word is found at $row, $col"
                )
            }
        }
    }

}
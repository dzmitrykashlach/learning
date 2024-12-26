package com.algorithms.storehouse.logic.backtracking


class NQueens(
    val n: Int
) {
    val chessBoard = Array(n) { BooleanArray(n) }
    var counter = n

    /*
      We're checking if this cell is safe for placing the queen
     */
    fun checkIfSafe(x: Int, y: Int): Boolean {
        /* Check this column only upward */
        for (i in 0 until x) if (chessBoard[i][y]) return false

        /* Check upper diagonal on right side */
        var i: Int = x
        var j: Int = y
        while (j < n && i >= 0) {
            if (chessBoard[i][j]) return false
            i--
            j++
        }

        /* Check upper diagonal on left side */
        i = x
        j = y
        while (i >= 0 && j >= 0) {
            if (chessBoard[i][j]) return false
            i--
            j--
        }
        return true
    }

    /*
         1) Start in the leftmost column
         2) If all queens are placed -> return true
         3) Try all rows in the current column.
            For every row do:
               3.1 if the queen can be placed safely in this row
                 then mark this [row][column] = true and recursively check
                 if placing queen here leads to a solution.
               3.2 if placing the queen in [row][column] leads to a solution
                 then return true
               3.3 if placing queen doesn't lead to a solution then
                  mark this [row][column] = false and go to step 3.1 and
                  try other rows.
          4) If all rows have been tried and nothing worked return false to trigger
              backtracking
          */
    fun solve(row: Int): Boolean {
        if (n < 4) {
            return false
        }
        if (counter == 0) return true
        for (i in 0 until n) {
//            for (j in y until n) {
            if (checkIfSafe(row, i)) {
                chessBoard[row][i] = true
                counter -= 1

                if (solve(row + 1)) {
                    return true
                }
                chessBoard[row][i] = false
                counter += 1
            }
        }
        return false
    }
}
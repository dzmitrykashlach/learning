package com.algorithms.storehouse.logic.graphs.dfs

class MazeEscape {
    val maze = arrayOf(
        intArrayOf(1, 1, 3, 0, 0),
        intArrayOf(1, 2, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1,1 )
    )

    fun findExit(maze: Array<IntArray>, startRow: Int, startCol: Int) {
        val row = maze.size
        val col = maze[0].size
        var x = startRow
        var y = startCol
        for (i in -1..1) {
            for (j in -1..1) {
                if (maze[x + i][y + j] == 0) {
                    maze[x + i][y + j] = 1
                    x = x + i
                    y = y + j
                    if (dfs(maze, x + 1, y, row, col)) return  //right side traversal
                    if (dfs(maze, x - 1, y, row, col)) return  //left side traversal
                    if (dfs(maze, x, y + 1, row, col)) return  //upward side traversal
                    if (dfs(maze, x, y - 1, row, col)) return  //downward side traversal
                }
            }
        }
    }

    fun dfs(maze: Array<IntArray>, x: Int, y: Int, row: Int, col: Int): Boolean {
        // Base condition
        // if i less than 0 or j less than 0 or i greater than ROW-1
        // or j greater than COL- or if M[i][j] == 1 then we will simply return
        if (x < 0 || y < 0 || x > row - 1 || y > col - 1 || maze[x][y] == 1) {
            return false
        }
        if (maze[x][y] == 3) {
            println("Exit is found at i = $x, j=$y")
            return true
        }
        if (maze[x][y] != 1) {
            maze[x][y] = 1
            if (dfs(maze, x + 1, y, row, col)) return true //right side traversal
            if (dfs(maze, x - 1, y, row, col)) return true //left side traversal
            return if (dfs(maze, x, y + 1, row, col)) true else dfs(maze, x, y - 1, row, col) //upward side traversal
            //downward side traversal
        }
        return false
    }
}
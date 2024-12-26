package com.algorithms.storehouse.logic.graphs.shortpathkeys

class ShortestPathDFS(
    val maze: Array<IntArray>,
    val start: Pair<Int, Int>,
    val finish: Pair<Int, Int>
) {
    // Declare a variable to store the shortest path
    private var shortestPath: Int = 0
    val visited: Array<BooleanArray> = Array(maze.size) { BooleanArray(maze[0].size) }

    // Method to find the shortest path in a given maze
    fun findShortestPath(): Int {

        // Check if the maze is empty or null, if so return 0
        if (maze == null || maze.isEmpty() || maze[0].isEmpty()) {
            return 0
        }

        // Initialize shortestPath to the maximum possible value
        shortestPath = Integer.MAX_VALUE

        // Initialize a boolean array to keep track of visited cells


        // Invoke the dfs() method to find the shortest path
        dfs(start.first, start.second, 0)

        // Return the shortest path, or 0 if it was not found
        shortestPath = if (shortestPath == Integer.MAX_VALUE) 0 else shortestPath
        return shortestPath
    }

    // Method to perform DFS traversal to find the shortest path
    fun dfs(row: Int, col: Int, distance: Int) {

        // Check if the current cell is out of bounds, a wall or has already been visited
        if (row < 0 || row >= maze.size || col < 0 || col >= maze[0].size || maze[row][col] == 1 || visited[row][col]) {
            return
        }

        // Check if the current cell is the destination, if so update the shortestPath variable and return
        if (row == finish.first && col == finish.second) {
            shortestPath = shortestPath.coerceAtMost(distance)
            return
        }

        // Mark the current cell as visited
        visited[row][col] = true

        // Explore all possible paths from the current cell
        dfs( row + 1, col, distance + 1)
        dfs( row - 1, col, distance + 1)
        dfs( row, col + 1, distance + 1)
        dfs( row, col - 1, distance + 1)

        // Unmark the current cell as visited
        visited[row][col] = false
    }
}
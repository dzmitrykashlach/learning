package com.algorithms.storehouse.logic.graphs.shortpathkeys

import java.util.*

/*
The algorithm then starts by adding the start cell to the priority queue with distance 0.
It continues to loop until the priority queue is empty or the end cell is reached.
In each iteration, the cell with the smallest distance is selected from the queue and its neighbors are explored.
The distance of each neighbor is updated if a shorter path is found and the neighbor is added to the priority queue.
The method returns -1 if the end cell cannot be reached or the shortest path length if the end cell is reached.
The main method creates a maze and calls the shortestPath function with the start and end coordinates.
The length of the shortest path is printed to the console.

Complexity Analysis: The time complexity of the Dijkstra's algorithm implementation
in the given code is O(N^2 log N), where N is the number of nodes (or cells) in the input grid.
The reason for this is that we use a priority queue to process the adjacent nodes of each node in the grid,
taking at most O(log N) time per insertion or removal, and we ensure that each node is processed only once.
In the worst case, all nodes are visited, and therefore the overall time complexity is O(N^2 log N).
The space complexity is also O(N^2) because the algorithm stores the distance and visited status of each node in two separate N x N arrays.
 */

class DijkstraShortestPath(
    val maze: Array<IntArray>,
    val start: Pair<Int, Int>,
    val finish: Pair<Int, Int>

) {
    val n = maze.size
    val m = maze[0].size
    // constant representing infinity
    val infinity: Int = Integer.MAX_VALUE
    // arrays representing the directions for moving in the maze
    val dx: Array<Int> = arrayOf(0, 0, 1, -1)
    val dy: Array<Int> = arrayOf(1, -1, 0, 0)

    // 2D arrays representing the shortest distances and visited cells
    // initialize all distances to infinity except the starting cell
    val dist = Array(n) { IntArray(m) { infinity } }.also { it[start.first][start.second] = 0 }

    // BooleanArray int[n][m];
    val visited = Array(n) { BooleanArray(m) { false } }


    fun shortestPath(): Int {
        // create a priority queue for storing cells to visit
        val pq = PriorityQueue<IntArray> { a, b -> a[2] - b[2] }
        pq.offer(intArrayOf(start.first, start.second, 0))
        // iterate while there are cells to visit
        while (!pq.isEmpty()) {
            // remove the cell with the smallest distance from the priority queue
            val curr = pq.poll()
            val x = curr[0]
            val y = curr[1]
            val d = curr[2]

            // if the cell has already been visited, skip it
            if (visited[x][y]) continue

            // mark the cell as visited
            visited[x][y] = true

            // if we've reached the end cell, return the shortest distance
            if (x == finish.first && y == finish.second) return d

            // iterate over the neighboring cells and update their distances if necessary
            for (i: Int in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx in 0 until n && ny >= 0 && ny < m && maze[nx][ny] == 0 && !visited[nx][ny]) {
                    val nd = d + 1
                    if (nd < dist[nx][ny]) {
                        dist[nx][ny] = nd
                        pq.offer(intArrayOf(nx, ny, nd))
                    }
                }
            }
        }

        // if we couldn't reach the end cell, return -1
        return -1
    }
}
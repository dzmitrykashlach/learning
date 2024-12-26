package arrays.shortpathkeys

import com.algorithms.storehouse.logic.graphs.shortpathkeys.DijkstraShortestPath
import kotlin.test.Test
import kotlin.test.assertTrue


class DijkstraShortestPathTest {

    @Test
    fun findDijkstraShortestPathTest() {
        val maze = arrayOf(
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 1, 1, 1, 0),
            intArrayOf(0, 0, 0, 0, 0)
        )

        val spdfs = DijkstraShortestPath(maze,Pair(0, 0), Pair(4, 4))
        val shortest = spdfs.shortestPath()
        assertTrue(8 == shortest)
    }

}
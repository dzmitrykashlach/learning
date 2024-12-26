package arrays.shortpathkeys

import com.algorithms.storehouse.logic.graphs.shortpathkeys.ShortestPathDFS
import kotlin.test.Test
import kotlin.test.assertTrue


class ShortestPathDFSTest {

    @Test
    fun findShortestPathTest() {
        val maze = arrayOf(
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(0, 0, 0, 1, 0)
        )
        val spdfs = ShortestPathDFS(maze,Pair(0, 0), Pair(4, 4))
        val shortest = spdfs.findShortestPath()
        assertTrue(12 == shortest)
    }
    @Test
    fun findShortestPathTest_twoBranches() {
        val maze = arrayOf(
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 1, 1, 1, 0),
            intArrayOf(0, 0, 0, 0, 0)
        )
        val spdfs = ShortestPathDFS(maze,Pair(0, 0), Pair(4, 1))
        val shortest = spdfs.findShortestPath()
        assertTrue(5 == shortest)
    }
}
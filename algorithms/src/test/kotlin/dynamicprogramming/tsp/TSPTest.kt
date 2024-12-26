package dynamicprogramming.tsp

import com.algorithms.storehouse.logic.graphs.dynamicprogramming.tsp.TravellingSalesmanProblem
import kotlin.test.assertEquals
import kotlin.test.Test

class TSPTest {


    @Test
    fun tspTest_5_vertices() {
        /*
        How to fill adjacency matrix for directed graph:
        - row means vertex, which has outgoing edges;
        - column means vertex, which has incoming edges;
         */
        val graph = arrayOf(
            intArrayOf(0, 9, 1, 0, 0),
            intArrayOf(0, 0, 0, 11, 0),
            intArrayOf(0, 2, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 20),
            intArrayOf(40, 0, 0, 0, 0)
        )


        val tsp = TravellingSalesmanProblem(5, graph)
        tsp.solve(0, 0)
        assertEquals("[0, 4, 3, 1, 2, 0]", tsp.minPath.toString())
        assertEquals(74, tsp.min)
    }

    @Test
    fun tspTest_7_vertices() {
        /*
        How to fill adjacency matrix for directed graph:
        - row means vertex, which has outgoing edges;
        - column means vertex, which has incoming edges;
         */
        val graph = arrayOf(
            intArrayOf(0, 70, 1, 0, 0, 0, 0),
            intArrayOf(0, 0, 30, 5, 0, 0, 0),
            intArrayOf(0, 3, 0, 50, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 8, 100, 0),
            intArrayOf(0, 0, 0, 0, 0, 12, 175),
            intArrayOf(0, 0, 0, 0, 200, 0, 16),
            intArrayOf(10, 0, 0, 0, 0, 0, 0),
        )


        val tsp = TravellingSalesmanProblem(7, graph)
        tsp.solve(0, 0)
        assertEquals("[0, 6, 5, 4, 3, 1, 2, 0]", tsp.minPath.toString())
        assertEquals(55, tsp.min)
    }

    @Test
    fun tspTest_25_Vertices() {
        /*
        How to fill adjacency matrix for directed graph:
        - row means vertex, which has outgoing edges;
        - column means vertex, which has incoming edges;
      */
        val graph = arrayOf(
            intArrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            )


        val tsp = TravellingSalesmanProblem(25, graph)
        tsp.solve(0, 0)
        assertEquals("[0, 5, 23, 6, 9, 8, 7, 24, 10, 21, 20, 17, 18, 11, 12, 13, 14, 15, 4, 3, 16, 2, 19, 22, 1, 0]", tsp.minPath.toString())
        assertEquals(25, tsp.min)
    }
}
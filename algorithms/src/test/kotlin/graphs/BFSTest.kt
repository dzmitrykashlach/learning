package graphs

import com.algorithms.storehouse.logic.graphs.bfs.BFS
import com.algorithms.storehouse.entities.graphs.Edge
import com.algorithms.storehouse.entities.graphs.Vertex
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BFSTest {

    @Test
    fun `Check size and content of 1st slice`() {
        val _1 = Vertex(
            1, mutableListOf(
            )
        )
        val _2 = Vertex(
            2, mutableListOf(
            )
        )
        val _3 = Vertex(
            3, mutableListOf(
            )
        )
        val _4 = Vertex(
            4, mutableListOf(
            )
        )
        val _5 = Vertex(
            5, mutableListOf(
            )
        )
        val _6 = Vertex(
            6, mutableListOf(
            )
        )
        val _7 = Vertex(
            7, mutableListOf(
            )
        )

        _1.adjucencyList.apply {
            add(Edge(1, _3))
            add(Edge(3, _4))
            add(Edge(4, _2))
        }

        _3.adjucencyList.apply {
            add(Edge(12, _5))
            add(Edge(10, _7))
        }

        _4.adjucencyList.apply {
            add(Edge(5, _2))
            add(Edge(8, _7))
        }

        _5.adjucencyList.apply {
            add(Edge(6, _6))
            add(Edge(3, _7))
        }

        _7.adjucencyList.apply {
            add(Edge(6, _6))
        }

        val traverse = BFS().perform(_1)
        assertEquals(7,traverse.size)
        val slice = traverse.slice(0..3)
        assertTrue {
            slice.contains(_1)
            slice.contains(_3)
            slice.contains(_4)
            slice.contains(_2)
        }
    }
}
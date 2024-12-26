package graphs

import com.algorithms.storehouse.logic.graphs.bfs.dijkstra.Dijkstra
import com.algorithms.storehouse.logic.graphs.bfs.dijkstra.DijkstraVertex
import com.algorithms.storehouse.logic.graphs.bfs.dijkstra.Edge
import kotlin.test.assertEquals
import kotlin.test.Test
import java.util.*

class DijkstraTest {
    @Test
    fun dijkstraTest() {
        val a = DijkstraVertex("A")
        val b = DijkstraVertex("B")
        val c = DijkstraVertex("C")
        val d = DijkstraVertex("D")
        val e = DijkstraVertex("E")
        val f = DijkstraVertex("F")
        val g = DijkstraVertex("G")
        val h = DijkstraVertex("H")
        a.addNeighbour(Edge(5.0, b))
        b.addNeighbour(Edge(4.0, c))
        b.addNeighbour(Edge(6.0, e))
        b.addNeighbour(Edge(10.0, g))
        c.addNeighbour(Edge(25.0, a))
        c.addNeighbour(Edge(1.0, e))
        d.addNeighbour(Edge(2.0, g))
        e.addNeighbour(Edge(40.0, h))
        //        e.addNeighbour(new Edge(35, f));
//        if this edge is added - algorithm gives non-optimal route. RCA is not available
        e.addNeighbour(Edge(1.0, d))
        f.addNeighbour(Edge(1.0, h))
        g.addNeighbour(Edge(4.0, f))
        g.addNeighbour(Edge(30.0, h))
        val dijkstra = Dijkstra()
        val route = dijkstra.calculate(a, h)
        assertEquals(
            "[H-18.0, F-17.0, G-13.0, D-11.0, E-10.0, C-9.0, B-5.0, A-0.0]",
            Arrays.toString(route.toTypedArray())
        )
    }

    @Test
    fun dijkstraTest1() {
        val d = DijkstraVertex("D")
        val e = DijkstraVertex("E")
        val f = DijkstraVertex("F")
        val g = DijkstraVertex("G")
        val h = DijkstraVertex("H")
        d.addNeighbour(Edge(2.0, g))
        e.addNeighbour(Edge(40.0, h))
        e.addNeighbour(Edge(35.0, f))
        e.addNeighbour(Edge(1.0, d))
        f.addNeighbour(Edge(1.0, h))
        g.addNeighbour(Edge(4.0, f))
        g.addNeighbour(Edge(30.0, h))
        val dijkstra = Dijkstra()
        val route = dijkstra.calculate(e, h)
        assertEquals(
            "[H-33.0, G-3.0, D-1.0, E-0.0]",
            Arrays.toString(route.toTypedArray())
        )
    }
}
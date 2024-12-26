package graphs

import com.algorithms.storehouse.logic.graphs.dfs.toposort.TopologicalSorting
import com.algorithms.storehouse.entities.graphs.dfs.toposort.Vertex
import kotlin.test.Test
import kotlin.test.assertEquals

class TopologicalSortTest {
    @Test
    fun test() {
        val a = Vertex("A")
        val b = Vertex("B")
        val c = Vertex("C")
        val d = Vertex("D")
        val e = Vertex("E")
        val f = Vertex("F")
        val g = Vertex("G")
        a.addNeighbour(c)
        a.addNeighbour(b)
        a.addNeighbour(g)
        c.addNeighbour(d)
        c.addNeighbour(b)
        d.addNeighbour(e)
        e.addNeighbour(f)
        g.addNeighbour(e)
        b.addNeighbour(f)

        /*
    - - - > B - - > -
    -   -           -
    A > C > D > E > F
    -           -
    - - > G - > -

    Expected result:
    1) A B C G D E F
    2) A G C B D E F

    */
        val topologicalSorting = TopologicalSorting()
        val sortedGraph = topologicalSorting.sort(a)
        assertEquals("A", sortedGraph.pop().name)
        assertEquals("G", sortedGraph.pop().name)
        assertEquals("C", sortedGraph.pop().name)
        assertEquals("B", sortedGraph.pop().name)
        assertEquals("D", sortedGraph.pop().name)
        assertEquals("E", sortedGraph.pop().name)
        assertEquals("F", sortedGraph.pop().name)
    }
}
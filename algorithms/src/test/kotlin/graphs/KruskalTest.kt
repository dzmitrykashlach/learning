package graphs

import com.algorithms.storehouse.logic.graphs.mst.kruskal.Kruskal
import com.algorithms.storehouse.entities.graphs.mst.kruskal.Edge
import com.algorithms.storehouse.entities.graphs.mst.kruskal.Vertex
import kotlin.test.assertEquals
import kotlin.test.Test

internal class KruskalTest {
    @Test
    fun testSum() {
        val a = Vertex("A")
        val b = Vertex("B")
        val c = Vertex("C")
        val d = Vertex("D")
        val e = Vertex("E")
        val vertices = mutableListOf<Vertex>()
        vertices.add(a)
        vertices.add(b)
        vertices.add(c)
        vertices.add(d)
        vertices.add(e)

        val edges = mutableListOf<Edge>()
        val ab = Edge(5, a, b)
        val bc = Edge(10, b, c)
        val cd = Edge(6, c, d)
        val db = Edge(8, d, b)
        val ac = Edge(13, a, c)
        val ae = Edge(15, e, a)
        val ec = Edge(20, e, c)
        edges.add(ab)
        edges.add(bc)
        edges.add(cd)
        edges.add(db)
        edges.add(ac)
        edges.add(ae)
        edges.add(ec)
        val kruskal = Kruskal()
        assertEquals(34, kruskal.calculate(vertices, edges))
    }
}
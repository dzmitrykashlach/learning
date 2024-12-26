package graphs

import com.algorithms.storehouse.logic.graphs.bellmanford.BellmanFord
import com.algorithms.storehouse.entities.graphs.bellmanford.Vertex
import com.algorithms.storehouse.entities.graphs.bellmanford.Edge
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import java.util.*

class BellmanFordTest {
    @Test
    fun positiveTest() {
        val a = Vertex("A")
        val b = Vertex("B")
        val c = Vertex("C")
        val d = Vertex("D")
        val e = Vertex("E")
        val f = Vertex("F")
        val g = Vertex("G")
        val h = Vertex("H")
        val ab = Edge(5.0, a, b)
        a.addNeighbour(ab)
        val bc = Edge(4.0, b, c)
        val be = Edge(6.0, b, e)
        val bg = Edge(10.0, b, g)
        b.addNeighbour(bc)
        b.addNeighbour(be)
        b.addNeighbour(bg)
        val ca = Edge(25.0, c, a)
        val ce = Edge(1.0, c, e)
        c.addNeighbour(ca)
        c.addNeighbour(ce)
        val dg = Edge(2.0, d, g)
        d.addNeighbour(dg)
        val eh = Edge(40.0, e, h)
        val ef = Edge(35.0, e, f)
        val ed = Edge(1.0, e, d)
        e.addNeighbour(eh)
        e.addNeighbour(ef)
        e.addNeighbour(ed)
        val fh = Edge(1.0, f, h)
        f.addNeighbour(fh)
        val gf = Edge(4.0, g, f)
        val gh = Edge(30.0, g, h)
        g.addNeighbour(gf)
        g.addNeighbour(gh)
        var edges = Arrays.asList(ab, bc, be, bg, ca, ce, dg, eh, ef, ed, fh, gf, gh)
        val bellmanFord = BellmanFord(7)
        var route: LinkedList<Vertex> = bellmanFord.calculate(a, e, edges)
        assertEquals(
            "[E-10.0, C-9.0, B-5.0, A-0.0]",
            Arrays.toString(route.toTypedArray())
        )
        route = bellmanFord.calculate(a, h, edges)
        assertEquals(
            "[H-18.0, F-17.0, G-13.0, D-11.0, E-10.0, C-9.0, B-5.0, A-0.0]",
            Arrays.toString(route.toTypedArray())
        )
        gh.weight = -30.0
        route = bellmanFord.calculate(a, h, edges)
        assertEquals(
            "[H--17.0, G-13.0, D-11.0, E-10.0, C-9.0, B-5.0, A-0.0]",
            Arrays.toString(route.toTypedArray())
        )
        val ge = Edge(-5.0, g, e)
        g.addNeighbour(ge)
        edges = Arrays.asList(ab, bc, be, bg, ca, ce, dg, eh, ef, ed, fh, gf, gh, ge)
        val finalEdges = edges
        assertFailsWith<RuntimeException>(
            block = {
                bellmanFord.calculate(a, h, finalEdges)
            }
        )
    }

    @Test
    fun negativeEdge() {
        val a = Vertex("A")
        val b = Vertex("B")
        val c = Vertex("C")
        val d = Vertex("D")
        val e = Vertex("E")
        val f = Vertex("F")
        val g = Vertex("G")
        val h = Vertex("H")
        val ab = Edge(5.0, a, b)
        a.addNeighbour(ab)
        val bc = Edge(4.0, b, c)
        val be = Edge(6.0, b, e)
        val bg = Edge(10.0, b, g)
        b.addNeighbour(bc)
        b.addNeighbour(be)
        b.addNeighbour(bg)
        val ca = Edge(25.0, c, a)
        val ce = Edge(1.0, c, e)
        c.addNeighbour(ca)
        c.addNeighbour(ce)
        val dg = Edge(2.0, d, g)
        d.addNeighbour(dg)
        val eh = Edge(40.0, e, h)
        val ef = Edge(35.0, e, f)
        val ed = Edge(1.0, e, d)
        e.addNeighbour(eh)
        e.addNeighbour(ef)
        e.addNeighbour(ed)
        val fh = Edge(1.0, f, h)
        f.addNeighbour(fh)
        val gf = Edge(4.0, g, f)
        val gh = Edge(-30.0, g, h)
        g.addNeighbour(gf)
        g.addNeighbour(gh)
        val edges = Arrays.asList(ab, bc, be, bg, ca, ce, dg, eh, ef, ed, fh, gf, gh)
        val bellmanFord = BellmanFord(7)
        val route = bellmanFord.calculate(a, h, edges)
        assertEquals(
            "[H--17.0, G-13.0, D-11.0, E-10.0, C-9.0, B-5.0, A-0.0]",
            Arrays.toString(route.toTypedArray())
        )
    }

    @Test
    fun negativeCycle() {
        val a = Vertex("A")
        val b = Vertex("B")
        val c = Vertex("C")
        val d = Vertex("D")
        val e = Vertex("E")
        val f = Vertex("F")
        val g = Vertex("G")
        val h = Vertex("H")
        val ab = Edge(5.0, a, b)
        a.addNeighbour(ab)
        val bc = Edge(4.0, b, c)
        val be = Edge(6.0, b, e)
        val bg = Edge(10.0, b, g)
        b.addNeighbour(bc)
        b.addNeighbour(be)
        b.addNeighbour(bg)
        val ca = Edge(25.0, c, a)
        val ce = Edge(1.0, c, e)
        c.addNeighbour(ca)
        c.addNeighbour(ce)
        val dg = Edge(2.0, d, g)
        d.addNeighbour(dg)
        val eh = Edge(40.0, e, h)
        val ef = Edge(35.0, e, f)
        val ed = Edge(1.0, e, d)
        e.addNeighbour(eh)
        e.addNeighbour(ef)
        e.addNeighbour(ed)
        val fh = Edge(1.0, f, h)
        f.addNeighbour(fh)
        val gf = Edge(4.0, g, f)
        val gh = Edge(-30.0, g, h)
        g.addNeighbour(gf)
        g.addNeighbour(gh)
        val bellmanFord = BellmanFord(7)
        val ge = Edge(-5.0, g, e)
        g.addNeighbour(ge)
        val edges = Arrays.asList(ab, bc, be, bg, ca, ce, dg, eh, ef, ed, fh, gf, gh, ge)
        assertFailsWith<RuntimeException>(
            block = {
                bellmanFord.calculate(a, h, edges)
            }
        )
    }
}
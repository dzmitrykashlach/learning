package graphs

import com.algorithms.storehouse.logic.graphs.mst.prim.Prim
import com.algorithms.storehouse.entities.graphs.mst.prim.Vertex
import kotlin.test.assertEquals
import kotlin.test.Test

class PrimTest {
    @Test
    fun primCalculationTest() {
        val a = Vertex("A")
        val b = Vertex("B")
        val c = Vertex("C")
        val d = Vertex("D")
        val e = Vertex("E")


        a.adjucencyList[b] = 5
        b.adjucencyList[a] = 5

        a.adjucencyList[c] = 13
        c.adjucencyList[a] = 13

        b.adjucencyList[c] = 10
        c.adjucencyList[b] = 10

        b.adjucencyList[d] = 8
        d.adjucencyList[b] = 8

        d.adjucencyList[c] = 6
        c.adjucencyList[d] = 6

        a.adjucencyList[e] = 15
        e.adjucencyList[a] = 15

        e.adjucencyList[c] = 20
        c.adjucencyList[e] = 20

        e.weight=0

        assertEquals(34, Prim().iterateNeighbors(e))
       }
}
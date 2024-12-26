package graphs

import com.algorithms.storehouse.entities.graphs.dfs.euleriancycle.Edge
import com.algorithms.storehouse.logic.graphs.dfs.euleriancycle.EulerianCycle
import kotlin.test.assertEquals
import kotlin.test.Test
import kotlin.test.fail

class EulerianCycleTest {

    @Test
    fun eulerianCycleTest() {
        val graph = ArrayList<ArrayList<Edge>>()
        val v0 = ArrayList<Edge>()
        val e01 = Edge(0, 1)
        v0.add(e01)

        val v1 = ArrayList<Edge>()
        val e13 = Edge(1, 3)
        val e14 = Edge(1, 4)
        v1.add(e13)
        v1.add(e14)

        val v2 = ArrayList<Edge>()
        val e21 = Edge(2, 1)
        v2.add(e21)

        val v3 = ArrayList<Edge>()
        val e34 = Edge(3, 4)
        v3.add(e34)

        val v4 = ArrayList<Edge>()
        val e42 = Edge(4, 2)
        val e45 = Edge(4, 5)
        v4.add(e42)
        v4.add(e45)

        val v5 = ArrayList<Edge>()
        val e50 = Edge(5, 0)
        v5.add(e50)

        graph.add(v0)
        graph.add(v1)
        graph.add(v2)
        graph.add(v3)
        graph.add(v4)
        graph.add(v5)

        val cycle = EulerianCycle(graph)
        val path = cycle.find(0)
        assertEquals("[0, 5, 4, 3, 1, 2, 4, 1, 0]",path.toString())
        assertEquals(9,path.size)
    }

    @Test
    fun eulerianCycleTestOdd() {
        val graph = ArrayList<ArrayList<Edge>>()
        val v0 = ArrayList<Edge>()
        val e01 = Edge(0, 1)
        v0.add(e01)

        val v1 = ArrayList<Edge>()
        val e13 = Edge(1, 3)
        val e14 = Edge(1, 4)
        v1.add(e13)
        v1.add(e14)

        val v2 = ArrayList<Edge>()
        val e21 = Edge(2, 1)
        v2.add(e21)

        val v3 = ArrayList<Edge>()
        val e34 = Edge(3, 4)
        v3.add(e34)

        val v4 = ArrayList<Edge>()
        val e42 = Edge(4, 2)
        val e45 = Edge(4, 5)
        val e40 = Edge(4, 0)
        v4.add(e42)
        v4.add(e45)
        v4.add(e40)

        val v5 = ArrayList<Edge>()
        val e50 = Edge(5, 0)
        v5.add(e50)

        graph.add(v0)
        graph.add(v1)
        graph.add(v2)
        graph.add(v3)
        graph.add(v4)
        graph.add(v5)


        val cycle = EulerianCycle(graph)
        try {
            cycle.find(0)
        }catch (e: RuntimeException){
             return
        }
        fail("Expected Runtime exception was not thrown")
    }
}
package graphs

import com.algorithms.storehouse.logic.graphs.dfs.cycledetection.CyclesDetection
import com.algorithms.storehouse.entities.graphs.dfs.cyclesdetection.Vertex
import kotlin.test.assertEquals
import kotlin.test.Test

class CycleDetectionTest {

        @Test
        fun cycleDetection() {
            val v0 = Vertex("A")
            val v1 = Vertex("B")
            val v2 = Vertex("C")
            val v3 = Vertex("D")
            val v4 = Vertex("E")
            val v5 = Vertex("F")

//        we have to hadle connections between vertices
            v5.addNeighbour(v0)
            v0.addNeighbour(v4)
            v0.addNeighbour(v2)
            v4.addNeighbour(v5)
            v2.addNeighbour(v1)
            v2.addNeighbour(v3)
            val graph: MutableList<Vertex> = ArrayList()
            graph.add(v0)
            graph.add(v1)
            graph.add(v2)
            graph.add(v3)
            graph.add(v4)
            graph.add(v5)
            val detection = CyclesDetection()
            assertEquals("A",detection.detectCycles(graph).name)
        }
}
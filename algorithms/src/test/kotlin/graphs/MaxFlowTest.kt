package graphs

import com.algorithms.storehouse.entities.graphs.maxflow.Edge
import com.algorithms.storehouse.logic.graphs.maxflow.FordFulkerson
import com.algorithms.storehouse.logic.graphs.maxflow.MaxFlowNetwork
import com.algorithms.storehouse.entities.graphs.maxflow.Vertex
import kotlin.test.assertEquals
import kotlin.test.Test

class MaxFlowTest {

    @Test
    fun maxFlowTest4() {
        val maxFlowNet = MaxFlowNetwork(4)
        val zero_s = Vertex(0)
        val one = Vertex(1)
        val two = Vertex(2)
        val three_t = Vertex(3)


        maxFlowNet.addEdge(Edge(zero_s, one, 4))
        maxFlowNet.addEdge(Edge(zero_s, two, 5))
        maxFlowNet.addEdge(Edge(one, three_t, 7))
        maxFlowNet.addEdge(Edge(two, one, 4))
        maxFlowNet.addEdge(Edge(two, three_t, 1))

        val fordFulkerson = FordFulkerson(maxFlowNet, zero_s, three_t)
        fordFulkerson.calculate()
        assertEquals(8.0, fordFulkerson.valueMaxFlow, 0.0)
    }

    @Test
    fun maxFlowTest10() {
        val maxFlowNet = MaxFlowNetwork(11)
        val zero = Vertex(0)
        val one = Vertex(1)
        val two = Vertex(2)
        val three = Vertex(3)
        val four = Vertex(4)
        val five = Vertex(5)
        val six = Vertex(6)
        val seven = Vertex(7)
        val eight = Vertex(8)
        val nine = Vertex(9)
        val ten = Vertex(10)


        maxFlowNet.addEdge(Edge(zero, one, 7))
        maxFlowNet.addEdge(Edge(zero, two, 2))
        maxFlowNet.addEdge(Edge(zero, three, 1))

        maxFlowNet.addEdge(Edge(one, four, 2))
        maxFlowNet.addEdge(Edge(one, five, 4))

        maxFlowNet.addEdge(Edge(two, five, 5))
        maxFlowNet.addEdge(Edge(two, six, 6))

        maxFlowNet.addEdge(Edge(three, four, 4))
        maxFlowNet.addEdge(Edge(three, eight, 8))

        maxFlowNet.addEdge(Edge(four, seven, 7))
        maxFlowNet.addEdge(Edge(four, eight, 1))

        maxFlowNet.addEdge(Edge(five, seven, 3))
        maxFlowNet.addEdge(Edge(five, nine, 3))
        maxFlowNet.addEdge(Edge(five, six, 8))

        maxFlowNet.addEdge(Edge(six, nine, 3))

        maxFlowNet.addEdge(Edge(seven, ten, 1))
        maxFlowNet.addEdge(Edge(eight, ten, 3))
        maxFlowNet.addEdge(Edge(nine, ten, 4))


        val fordFulkerson = FordFulkerson(maxFlowNet, zero, ten)
        fordFulkerson.calculate()
        assertEquals(7.0, fordFulkerson.valueMaxFlow, 0.0)
    }

    @Test
    fun maxFlowTest6() {
        val maxFlowNet = MaxFlowNetwork(6)
        val zero = Vertex(0)
        val one = Vertex(1)
        val two = Vertex(2)
        val three = Vertex(3)
        val four = Vertex(4)
        val five = Vertex(5)

        maxFlowNet.addEdge(Edge(zero, one, 7))
        maxFlowNet.addEdge(Edge(zero, four, 4))

        maxFlowNet.addEdge(Edge(one, two, 5))
        maxFlowNet.addEdge(Edge(one, three, 3))

        maxFlowNet.addEdge(Edge(two, five, 8))

        maxFlowNet.addEdge(Edge(three, two, 3))
        maxFlowNet.addEdge(Edge(three, five, 5))

        maxFlowNet.addEdge(Edge(four, one, 3))
        maxFlowNet.addEdge(Edge(four, three, 2))

        val fordFulkerson = FordFulkerson(maxFlowNet, zero, five)
        fordFulkerson.calculate()
        assertEquals(10.0, fordFulkerson.valueMaxFlow, 0.0)
    }

}
package com.algorithms.storehouse.logic.graphs.maxflow

import com.algorithms.storehouse.entities.graphs.maxflow.Edge
import com.algorithms.storehouse.entities.graphs.maxflow.Vertex
import java.util.LinkedList


class FordFulkerson (flowNet: MaxFlowNetwork, s: Vertex, t: Vertex) {
    lateinit var marked //marked[v.getId()] = true if there is a path from s -> v in the residual graph
            : BooleanArray
    private lateinit var edgeTo //edgeTo[v] = edges in the augmenting path
            : Array<Edge?>
    var valueMaxFlow = 0.0
    val calculate = fun() {
        while (hasAugmentingPath(flowNet, s, t)) {
            var minValue = Int.MAX_VALUE
            var v = t
            while (v !== s) {
//                if current residual capacity is less than minValue - we update minValue with it
                minValue = minValue.coerceAtMost(edgeTo[v.id]!!.residualCapacity(v))
                v = edgeTo[v.id]!!.oppositeVertex(v)
            }
            v = t
//                once minValue is determined, we iterate through residual graph once again and update edge's flow with residual flow value
            while (v !== s) {
                edgeTo[v.id]?.addResidualFlow(v, minValue)
                v = edgeTo[v.id]!!.oppositeVertex(v)
            }
            valueMaxFlow += minValue
        }
    }

    val hasAugmentingPath = fun(flowNet: MaxFlowNetwork, s: Vertex, t: Vertex): Boolean {
        edgeTo = arrayOfNulls(flowNet.numVertices)
        marked = BooleanArray(flowNet.numVertices)
        val queue = LinkedList<Vertex>()
        queue.add(s)
        marked[s.id] = true
        while (queue.isNotEmpty() && !marked[t.id]) {
            val v = queue.remove()
            for (e: Edge in flowNet.adjucenciesList[v.id]) {
                val w = e.oppositeVertex(v)
                if (e.residualCapacity(w) > 0) {
                    if (!marked[w.id]) {
                        edgeTo[w.id] = e
                        marked[w.id] = true
                        queue.add(w)

                    }
                }
            }
        }
        return marked[t.id]
    }
}
package com.algorithms.storehouse.logic.graphs.bellmanford

import com.algorithms.storehouse.entities.graphs.bellmanford.Vertex
import com.algorithms.storehouse.entities.graphs.bellmanford.Edge
import java.util.*
import java.util.function.Consumer

/*
 Time complexity = O((V-1)*E)
 */
class BellmanFord constructor(val iterations: Int ) {
//    private val iterations = 0

    fun calculate(from: Vertex, to: Vertex, edges: List<Edge>): LinkedList<Vertex> {
        from.distance = 0.0
        for (i in 0 until iterations) {
            edges.forEach(Consumer { e: Edge ->
                if (e.startVertex!!.distance + e.weight < e.targetVertex!!.distance) {
                    // update distance for target vertex of each edge if new distance is less
                    e.targetVertex!!.distance = e.startVertex!!.distance + e.weight
                    // update predecessor
                    e.targetVertex!!.predecessor = e.startVertex
                }
            })
        }
        edges.forEach(Consumer { e: Edge ->
            if (e.startVertex!!.distance + e.weight < e.targetVertex!!.distance) {
//                print out negative cycle
                println("Negative cycle is detected:")
                var cycleNode = e.startVertex
                do {
                    println(cycleNode)
                    cycleNode = cycleNode!!.predecessor
                } while (cycleNode != e.startVertex)
                throw RuntimeException("Negative cycle is detected")
            }
        })
        return extractRoute(to)
    }

    fun extractRoute(to: Vertex): LinkedList<Vertex> {
        val route = LinkedList<Vertex>()
        route.add(to)
        var dv = to
        while (dv.predecessor != null) {
            route.add(dv.predecessor!!)
            dv = dv.predecessor!!
        }
        return route
    }
}
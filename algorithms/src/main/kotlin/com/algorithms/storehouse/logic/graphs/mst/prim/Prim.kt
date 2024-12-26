package com.algorithms.storehouse.logic.graphs.mst.prim

import com.algorithms.storehouse.entities.graphs.mst.prim.Vertex

class Prim {
    var cost: Int = 0

    fun iterateNeighbors(vertex: Vertex): Int {
        vertex.visited = true
        val adjMap = vertex.adjucencyList
        for (v: Vertex in adjMap.keys) {
            if (!v.visited && v.weight > adjMap[v]!!) {
                v.weight = adjMap[v]!!
            }
        }
        val next: Map.Entry<Vertex, Int> =
            try {
                adjMap.filter { a -> !a.key.visited }
                    .minWith { x, y -> x.key.weight.compareTo(y.key.weight) }
            } catch (e: NoSuchElementException) {
                return cost
            }
        cost += next.value
        if (!next.key.visited)
            iterateNeighbors(next.key)
        return cost
    }

}
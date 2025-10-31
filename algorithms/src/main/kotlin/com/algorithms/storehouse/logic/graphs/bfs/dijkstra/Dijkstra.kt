package com.algorithms.storehouse.logic.graphs.bfs.dijkstra

import lombok.NoArgsConstructor
import java.util.*

@NoArgsConstructor
class Dijkstra {
    fun calculate(from: DijkstraVertex, to: DijkstraVertex): LinkedList<DijkstraVertex> {
        from.distance = 0.0
        bfsDijkstra(from)
        return extractRoute(to)
    }

    private fun bfsDijkstra(dv: DijkstraVertex) {
        if (!dv.visited) {
            dv.visited = true
            // select local optimum
            dv.adjacencyList.forEach { e ->
                if (dv.distance + e.weight < e.targetDijkstraVertex?.distance!!) {
                    // update distance for target vertex of each edge if new distance is less
                    e.targetDijkstraVertex?.distance = dv.distance + e.weight
                    // update predecessor
                    e.targetDijkstraVertex?.predecessor = dv
                }
                bfsDijkstra(e.targetDijkstraVertex!!)
            }
        }
    }

    private fun extractRoute(from: DijkstraVertex): LinkedList<DijkstraVertex> {
        val route = LinkedList<DijkstraVertex>()
        route.add(from)
        var dv = from
        while (dv.predecessor != null) {
            route.add(dv.predecessor!!)
            dv = dv.predecessor!!
        }
        return route
    }
}
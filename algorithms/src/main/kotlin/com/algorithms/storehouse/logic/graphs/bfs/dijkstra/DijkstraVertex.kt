package com.algorithms.storehouse.logic.graphs.bfs.dijkstra

class DijkstraVertex(private val name: String) : Comparable<DijkstraVertex> {
    var visited = false
    var adjacencyList: MutableList<Edge> = ArrayList()

    //    distance from the source
    var distance: Double = Double.POSITIVE_INFINITY

    //    previous vertex on the shortest path
    var predecessor: DijkstraVertex? = null

    fun addNeighbour(edge: Edge) {
        adjacencyList.add(edge)
    }

    override fun compareTo(other: DijkstraVertex): Int {
//        v1 < v2 if v1.distance < v2.distance
//        v2 < v1 if v2.distance < v1.distance
        return java.lang.Double.compare(distance, other.distance)
    }

    override fun toString(): String {
        return name + '-' + distance
    }
}
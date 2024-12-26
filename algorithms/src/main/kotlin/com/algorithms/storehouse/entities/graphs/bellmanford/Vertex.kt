package com.algorithms.storehouse.entities.graphs.bellmanford

//@Getter
//@Setter
class Vertex(private val name: String) : Comparable<Vertex> {
    private val adjacencyList: MutableList<Edge>

    //    distance from the source
    var distance: Double

    //    previous vertex on the shortest path
    var predecessor: Vertex? = null

    init {
        adjacencyList = ArrayList()
        distance = Double.POSITIVE_INFINITY
    }

    fun addNeighbour(edge: Edge) {
        adjacencyList.add(edge)
    }

    override fun compareTo(other: Vertex): Int {
//        v1 < v2 if v1.distance < v2.distance
//        v2 < v1 if v2.distance < v1.distance
        return java.lang.Double.compare(distance, other.distance)
    }

    override fun toString(): String {
        return name + '-' + distance
    }
}
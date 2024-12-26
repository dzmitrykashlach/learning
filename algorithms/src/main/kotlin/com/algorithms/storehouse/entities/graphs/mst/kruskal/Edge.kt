package com.algorithms.storehouse.entities.graphs.mst.kruskal

data class Edge(
    val weight: Int,
    val firstVertex: Vertex,
    val secondVertex: Vertex
) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return weight - other.weight
    }
}
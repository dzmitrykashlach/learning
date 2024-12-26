package com.algorithms.storehouse.entities.graphs.mst.kruskal

data class Vertex(
    val name: String,
    var disjointSet: List<Vertex> = emptyList()
) {
    override fun toString(): String = "Vertex - $name"
}